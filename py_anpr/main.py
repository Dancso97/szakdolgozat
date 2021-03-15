import utils
from py_anpr_v5 import start_reading

def main():
    print("Welcome to ANPR!\n")
    backendStatus = utils.checkServerStatus(utils.BACKEND_URL)
    frontendStatus = utils.checkServerStatus(utils.FRONTEND_URL)
    if(backendStatus and frontendStatus):
        print("both up and running")
        
        
        #start_reading()
    
if __name__ == "__main__":
    main()