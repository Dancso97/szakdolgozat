import requests
import subprocess
from time import sleep
import psutil

tries = 0

DATA_UPLOAD_URL = 'http://localhost:8080/'
BACKEND_HEALTH_URL = 'http://localhost:8080/actuator/health'
FRONTEND_URL = 'http://localhost:3000'
BACKEND_RUN =  'mvn spring-boot:run -f D:\\Git\\szakdolgozat\\pom.xml'
FRONTEND_RUN = "npm start --prefix D:\\Git\\szakdolgozat\\prime_frontend\\"

def uploadToServer(pictureName):
    print("In server upload!\n")
    
    #TODO: Add correct url
    files = {'file': open('{}.jpg'.format(pictureName), 'rb')}
    statuscode = requests.post(DATA_UPLOAD_URL, files=files)
    print("HTTP status: {}".format(statuscode))

def checkServerStatus(SERVER_URL):
    
    global tries
    
    print("Checking servers status\n")
    try:
    
        if(requests.get(SERVER_URL)):
        
            tries+=1
            print("Server : {} is up! ".format(SERVER_URL))
           
            return True
    
    except:
        
        if(tries < 5):
            
            print("{} is not available\nRetrying.... {}\n".format(SERVER_URL, tries))
            tries+=1
            
            sleep(5)
            checkServerStatus(SERVER_URL)
            
        else:
            
            print("Trying exceeded\n Sleeping a bit...")
            sleep(10)
            tries = 0
            checkServerStatus(SERVER_URL)
            
            
def startProcess(process):    
    p = subprocess.Popen(process ,shell=True, stdout = subprocess.PIPE, stderr = subprocess.PIPE)
    if( p.pid is not None or p.pid > 0 ):
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
    

    