import sys
import requests
import subprocess
from time import sleep

BACKEND_URL = 'http://localhost:8080/actuator/health'
FRONTEND_URL = 'http://localhost:3000'
BACKEND_RUN =  'mvn spring-boot:run -f D:\\Git\\szakdolgozat\\pom.xml'
FRONTEND_RUN = "npm start --prefix D:\\Git\\szakdolgozat\\prime_frontend\\"

def uploadToServer(pictureName):
    print("In server upload!\n")
    url = SERVER_URL + '/data/upload'
    files = {'file': open('{}.jpg'.format(pictureName), 'rb')}
    statuscode = requests.post(url, files=files)
    print("HTTP status: {}".format(statuscode))

def checkServerStatus(SERVER_URL):
    print("Checking servers status\n")
    try:
        if(requests.get(SERVER_URL)):
            print("Server is up!\n")
            return True
    except:
        print("{} is not available\nRetrying....\n".format(SERVER_URL))
        sleep(5)
        checkServerStatus(SERVER_URL)

def startProcess(process):    
    p = subprocess.Popen(process ,shell=True, stdout = subprocess.PIPE, stderr = subprocess.PIPE)
    if( p.pid is not None or p.pid > 0 ):
        print("{} pid: {} ".format(process, str(p.pid)))
    else:
        return -1