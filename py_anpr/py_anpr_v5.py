import cv2
import imutils
import numpy as np
import pytesseract
from matplotlib import pyplot as plt
import os
import re

###

pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files (x86)\Tesseract\tesseract.exe'
heightImg = 100
widthImg  = 300

###

def main():
    dirname="kepek/"
    included_extensions = ['jpg','jpeg', 'bmp', 'png', 'JPG']
    file_names = [fn for fn in os.listdir(dirname) if any(fn.endswith(ext) for ext in included_extensions)]

    for imageName in file_names:
        print(imageName)
        readLicensePlate(dirname+imageName)

def reorder(myPoints):

    myPoints = myPoints.reshape((4, 2))
    myPointsNew = np.zeros((4, 1, 2), dtype=np.int32)
    add = myPoints.sum(1)

    myPointsNew[0] = myPoints[np.argmin(add)]
    myPointsNew[3] =myPoints[np.argmax(add)]
    diff = np.diff(myPoints, axis=1)
    myPointsNew[1] =myPoints[np.argmin(diff)]
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

def drawRectangle(img,biggest,thickness):
    cv2.line(img, (biggest[0][0][0], biggest[0][0][1]), (biggest[1][0][0], biggest[1][0][1]), (0, 255, 0), thickness)
    cv2.line(img, (biggest[0][0][0], biggest[0][0][1]), (biggest[2][0][0], biggest[2][0][1]), (0, 255, 0), thickness)
    cv2.line(img, (biggest[3][0][0], biggest[3][0][1]), (biggest[2][0][0], biggest[2][0][1]), (0, 255, 0), thickness)
    cv2.line(img, (biggest[3][0][0], biggest[3][0][1]), (biggest[1][0][0], biggest[1][0][1]), (0, 255, 0), thickness)

    return img

def readLicensePlate(imageName):
    img = cv2.imread(imageName)
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    imgBlur = cv2.GaussianBlur(gray, (5, 5), 1) #GaussianBlur
    bfilter = cv2.bilateralFilter(gray, 13, 17, 17) #Noise reduction
    edged = cv2.Canny(gray, 30, 200) #Edge detection

    ## FIND ALL COUNTOURS
    imgBigContour = img.copy()
    contours = cv2.findContours(edged.copy(), cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    contours = imutils.grab_contours(contours)
    contours = sorted(contours, key = cv2.contourArea, reverse = True)[:10]

    # FIND THE BIGGEST COUNTOUR
    biggest, maxArea = biggestContour(contours) # FIND THE BIGGEST CONTOUR
    if biggest is not None:
        biggest=reorder(biggest)
        cv2.drawContours(imgBigContour, biggest, -1, (0, 255, 0), 20) # DRAW THE BIGGEST CONTOUR
        imgBigContour = drawRectangle(imgBigContour,biggest,2)
        
        #PREPARE POINTS FOR WARP
        
        pts1 = np.float32(biggest) 
        pts2 = np.float32([[0, 0],[widthImg, 0], [0, heightImg],[widthImg, heightImg]]) 

        matrix = cv2.getPerspectiveTransform(pts1, pts2)
        imgWarpColored = cv2.warpPerspective(img, matrix, (widthImg, heightImg))
        
        #OCR
        text = pytesseract.image_to_string(imgWarpColored, config='--psm 11')
        license_plate = re.findall(r"[A-Z]{1,3}.[0-9]{1,3}", text.replace(" ", "") )
        print("Detected license plate Number is: {} With re filter: {}".format(text, license_plate))

    else:
        print("No contour found")


main()