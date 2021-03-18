import utils
from py_anpr_v5 import start_reading
import time


switcher = {
    1: autoRun
    2: autoStop
} 

def autoRun():
    print("ar")

    '''
 
    bpid = utils.startProcess(utils.BACKEND_RUN)
    time.sleep(5)
    backendStatus = utils.checkServerStatus(utils.BACKEND_URL)

    if( backendStatus is True ):
        utils.startProcess(utils.FRONTEND_RUN)
        time.sleep(5)
        frontendStatus = utils.checkServerStatus(utils.FRONTEND_URL)
    
    
    if(backendStatus and frontendStatus):
        print("both up and running")            
        #start_reading()
    '''


def autoStop():
    print("as")


def main():
    print("Welcome to ANPR!\n")
   

def menu()
    print("--- Menu ---")
    print("1,Start engine\n2,Stop engine")
    choice = input()
    funcToCall = switcher.get(choice, "Invalid input")



if __name__ == "__main__":
    main()