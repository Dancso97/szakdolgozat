import requests

def uploadToServer(pictureName):
    print("In server upload!\n")
    url = 'http://localhost:8080/data/upload'
    files = {'file': open('{}.jpg'.format(pictureName), 'rb')}
    statuscode = requests.post(url, files=files)
    print("HTTP status: {}".format(statuscode))