import sys
import utils
from py_anpr_v5 import start_reading

engineRunning = False
backendPid = 0
frontendPid = 0

def menu():
    print("--- Menu ---")
    print("1,Start engine\n2,Stop engine\n3,Start reading license plates\n4,Exit the program")
    choice = input()
    startChoice(choice)


def startChoice(choice):
    global engineRunning

    try:
        if choice == '1':
            autoRun()
            menu()
        if choice == '2':
            autoStop()
            menu()
        if choice == '3':
            if engineRunning:
                start_reading()
                menu()
            else:
                print("You tricky!\nEngine wasn't even running\nI will start for you if you want!")
                autoRun()
                menu()
        if choice == '4':
            if engineRunning:
                autoStop()
                print("Goodbye, see you later!")
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
    print("Auto running backend and frontend subsystems")

    global backendPid
    global frontendPid
    global engineRunning

    backendStatus = None
    frontendStatus = None

    backendPid = utils.startProcess(utils.BACKEND_RUN)
    if backendPid > 0:
        while backendStatus is None:
            backendStatus = utils.checkServerStatus(utils.BACKEND_HEALTH_URL)

    frontendPid = utils.startProcess(utils.FRONTEND_RUN)
    if frontendPid > 0:
        while frontendStatus is None:
            frontendStatus = utils.checkServerStatus(utils.FRONTEND_URL)

    if backendStatus and frontendStatus:
        print("Backend and Frontend up and running")
        engineRunning = True
        return
    else:
        if backendPid != 0 and frontendPid != 0:
            engineRunning = True
            return


def autoStop():
    global backendPid
    global frontendPid
    global engineRunning

    if not engineRunning:
        print("Engine is not running\nBack to menu...")
        menu()

    if backendPid != 0 and frontendPid != 0:
        print("Stopping processes")
        utils.stopProcess(backendPid)
        utils.stopProcess(frontendPid)
        engineRunning = False
        backendPid=0
        frontendPid = 0
    else:
        if backendPid > 0:
            print("Backend was started,stopping...")
            utils.stopProcess(backendPid)
            backendPid = 0
        if frontendPid > 0:
            print("Frontend was started,stopping...")
            utils.stopProcess(frontendPid)
            frontendPid = 0
        else:
            print("None of processes was started by me :( ")

    print("Engine stopped!")
    return
    menu()
