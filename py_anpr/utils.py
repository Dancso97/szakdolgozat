import requests
import subprocess
from time import sleep
import psutil
import json

tries = 0

DATA_UPLOAD_URL = 'http://localhost:8080/data/upload'
BACKEND_HEALTH_URL = 'http://localhost:8080/actuator/health'
FRONTEND_URL = 'http://localhost:4200/'
BACKEND_RUN = 'mvn spring-boot:run -f D:\\Git\\szakdolgozat\\pom.xml'
FRONTEND_RUN = "angular-http-server -p 4200 --path D:\\Git\\szakdolgozat\\smol-fn\\dist\\smol-fn"


def uploadToServer(imageName, imageMetadata, plate_number):
    print("In server upload!\n")

    imageMetadata['name'] = imageName
    print("Metadata is {}".format(imageMetadata))
    print("Plate is {}".format(plate_number))
    files = [
        ('plate', plate_number),
        ('file', (imageName, open('kepek/{}'.format(imageName), 'rb'), 'image/jpeg')),
        ('metadata', ('metadata', json.dumps(imageMetadata), 'application/json'))
    ]

    response = requests.post(DATA_UPLOAD_URL, files=files)
    print('HTTP Response: {}'.format(response.status_code))


def checkServerStatus(SERVER_URL):
    global tries

    print("Checking servers status\n")
    try:
        if requests.get(SERVER_URL):
            tries += 1
            print("Server : {} is up! ".format(SERVER_URL))
            return True
    except:
        if tries < 5:
            print("{} is not available\nRetrying.... {}\n".format(SERVER_URL, tries))
            tries += 1
            sleep(15)
            checkServerStatus(SERVER_URL)
        else:
            print("Trying exceeded\n Sleeping a bit...")
            sleep(15)
            tries = 0
            checkServerStatus(SERVER_URL)


def startProcess(process):
    time = 0
    p = subprocess.Popen(process, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    while True:
        line = p.stdout.readline()
        print(line.decode('utf-8').strip())

        if line.decode('utf-8').strip() == 'Listening on 4200':
            break

        if time > 20:
            break

        time += 1
    if p.pid is not None or p.pid > 0:
        print("{} pid: {} ".format(process, str(p.pid)))
        return p.pid
    else:
        return -1


def stopProcess(processPid):
    print("Killing {}".format(processPid))
    parent = psutil.Process(processPid)
    for child in parent.children(recursive=True):  # or parent.children() for recursive=False
        child.kill()
    parent.kill()