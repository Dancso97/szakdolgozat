import utils
from py_anpr_v5 import start_reading
import time
import sys

engineRunning = False
backendPid = 0
frontendPid = 0
lastChoice = -1
def menu():
    print("--- Menu ---")
    print("1,Start engine\n2,Stop engine\n3,Start reading license plates\n4,Exit the program")
    choice = input()
    startChoice(choice)
    
    
def startChoice(choice):
    global engineRunning
    global lastChoice
    if(choice == lastChoice):
        print("Nem választható kétszer ugyan az a menü!\n")
        menu()
    try:
        if choice == '1':
            autoRun()
        if choice == '2':
            autoStop()
        if choice == '3':
            startReading()
        if choice == '4':
            if(engineRunning):
                autoStop()
                sys.exit(0)
            sys.exit(0)
        else:
            print("CHOICE CALLED {}".format(choice))
            print("Invalid option")
            menu()
    except ValueError:
        print("Invalid option with exception")
        menu()

def autoRun():
    print("Autorunning backend and frontend subsystems")
    
    global backendPid 
    global frontendPid
    global engineRunning
    
    backendPid = utils.startProcess(utils.BACKEND_RUN)
    backendStatus = utils.checkServerStatus(utils.BACKEND_HEALTH_URL)
    
    frontendPid = utils.startProcess(utils.FRONTEND_RUN)
    frontendStatus = utils.checkServerStatus(utils.FRONTEND_URL)
    
    if(backendStatus and frontendStatus):
        print("Backend and Frontend up and running")
        engineRunning = True
        menu()
    else:
        if(backendPid != 0 and frontendPid != 0):
            engineRunning = True


def autoStop():
    global backendPid 
    global frontendPid
    global engineRunning
    
    if(not engineRunning):
        print("Engine is not running\n Exiting...")
        menu()
           
    if(backendPid != 0 and frontendPid != 0):
        print("Stopping processes")
        utils.stopProcess(backendPid)
        utils.stopProcess(frontendPid)
    
    backendPid, frontendPid = 0
    engineRunning = False
    
    print("Engine stopped!")
    menu()
    
def startReading():
    if(not engineRunning):
        print("Engine is not running\n Exiting...")
    start_reading()