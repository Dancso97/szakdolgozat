import cv2
import imutils
import numpy as np
import pytesseract
import os
import re
from metadata import getMetadata
from utils import uploadToServer

# TODO: Export pictures to a separate dir
###

pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files (x86)\Tesseract\tesseract.exe'
#heightImg = 100
#widthImg = 300


def start_reading():
    dirname = "kepek/"
    included_extensions = ['jpg', 'jpeg', 'bmp', 'png', 'JPG']
    file_names = [fn for fn in os.listdir(dirname) if any(fn.endswith(ext) for ext in included_extensions)]
    i = 0
    for imageName in file_names:
        print(imageName)
        plate_number = readLicensePlate(dirname + imageName)
        if plate_number != '':
            print(plate_number)
            # uploadToServer(imageName,getMetadata(dirname+imageName), plate_number)

        i += 1


def reorder(myPoints):
    myPoints = myPoints.reshape((4, 2))
    myPointsNew = np.zeros((4, 1, 2), dtype=np.int32)
    add = myPoints.sum(1)

    myPointsNew[0] = myPoints[np.argmin(add)]
    myPointsNew[3] = myPoints[np.argmax(add)]
    diff = np.diff(myPoints, axis=1)
    myPointsNew[1] = myPoints[np.argmin(diff)]
    myPointsNew[2] = myPoints[np.argmax(diff)]

    return myPointsNew


def biggestContour(contours):
    biggest = None
    max_area = 0
    for i in contours:
        area = cv2.contourArea(i)
        if area > 2500:
            peri = cv2.arcLength(i, True)
            approx = cv2.approxPolyDP(i, 0.02 * peri, True)
            if area > max_area and len(approx) == 4:
                biggest = approx
                max_area = area
    return biggest, max_area


def drawRectangle(img, biggest, thickness):
    cv2.line(img, (biggest[0][0][0], biggest[0][0][1]), (biggest[1][0][0], biggest[1][0][1]), (0, 255, 0), thickness)
    cv2.line(img, (biggest[0][0][0], biggest[0][0][1]), (biggest[2][0][0], biggest[2][0][1]), (0, 255, 0), thickness)
    cv2.line(img, (biggest[3][0][0], biggest[3][0][1]), (biggest[2][0][0], biggest[2][0][1]), (0, 255, 0), thickness)
    cv2.line(img, (biggest[3][0][0], biggest[3][0][1]), (biggest[1][0][0], biggest[1][0][1]), (0, 255, 0), thickness)

    return img


def readLicensePlate(imageName):
    img = cv2.imread(imageName)
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    cv2.GaussianBlur(gray, (5, 5), 1)  # GaussianBlur
    cv2.bilateralFilter(gray, 10, 17, 17)
    edged = cv2.Canny(gray, 30, 200)  # Edge detection

    ## FIND ALL COUNTOURS
    imgBigContour = img.copy()
    contours = cv2.findContours(edged.copy(), cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    contours = imutils.grab_contours(contours)
    contours = sorted(contours, key=cv2.contourArea, reverse=True)[:10]

    # FIND THE BIGGEST COUNTOUR
    biggest, maxArea = biggestContour(contours)  # FIND THE BIGGEST CONTOUR
    if biggest is not None:
        biggest = reorder(biggest)
        cv2.drawContours(imgBigContour, biggest, -1, (0, 255, 0), 20)  # DRAW THE BIGGEST CONTOUR
        sample = imgBigContour.copy()
        imgBigContour = drawRectangle(imgBigContour, biggest, 2)

        cv2.namedWindow('Kep', cv2.WINDOW_NORMAL)
        cv2.resizeWindow('Kep', 500, 500)
        cv2.imshow('Kep', imgBigContour)
        cv2.waitKey(0)

        # PREPARE POINTS FOR WARP

        widthImg = (biggest.max(axis=0)[0][0] - biggest.min(axis=0)[0][0]) + 100
        heightImg = (biggest.max(axis=0)[0][1] - biggest.min(axis=0)[0][1]) + 100

        pts1 = np.float32(biggest)
        pts2 = np.float32([[0, 0], [widthImg, 0], [0, heightImg], [widthImg, heightImg]])

        matrix = cv2.getPerspectiveTransform(pts1, pts2)

        imgWarpColored = cv2.warpPerspective(img, matrix, (widthImg, heightImg))

        cv2.resizeWindow('Kep', widthImg, heightImg)
        cv2.imshow("Csak rendszam", imgWarpColored)
        cv2.waitKey(0)

        # OCR
        textSample = pytesseract.image_to_string(sample, config='--tessdata-dir "C:\\Program Files (x86)\\Tesseract\\tessdata" --psm 6 --oem 2')
        text = pytesseract.image_to_string(imgWarpColored, config='--tessdata-dir "C:\\Program Files (x86)\\Tesseract\\tessdata" --psm 6 --oem 2')

        print("Found text : {}".format(textSample.replace(" ", "")))
        print("Found text : {}".format(text.replace(" ", "")))
        license_plate_string = re.findall(r"[A-Z]{3}", text.replace(" ", ""))
        license_plate_numbers = re.findall(r"[0-9]{3}",text.replace(" ", ""))
        license_plate = ''
        if len(license_plate_string) > 0 and len(license_plate_numbers) > 0:
            license_plate = license_plate_string[0] + '-' + license_plate_numbers[0]
            print("License plate {}".format(license_plate))

        if len(license_plate) > 0:
            return license_plate

        return ''
    else:
        print("No contour found")
        return ''

start_reading()