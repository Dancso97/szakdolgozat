import requests
from time import sleep

BACKEND_URL = 'http://localhost:8080/actuator/health'
FRONTEND_URL = 'http://localhost:3000'

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
