from PIL import Image
from PIL.ExifTags import TAGS


def getMetadata(picture):
    
    try:
        image = Image.open(picture)
    except IOError:
        print("Nem lehet a képet megnyitni!")
    
    exif = {}
    returnMetadata = {}
    try:    
        if(image._getexif().items() != None):
            for tag, value in image._getexif().items():
                if tag in TAGS:
                    exif[TAGS[tag]] = value
    except AttributeError:
        pass
    
    try:
        if 'ImageWidth' in exif:
            returnMetadata['width'] = exif['ImageWidth']
        if 'ImageLength' in exif:
            returnMetadata['height'] = exif['ImageLength']
        if 'DateTime' in exif:
            returnMetadata['original_date'] = exif['DateTime']
    except KeyError:
        pass
    
    return returnMetadata
