import requests
import unicodedata
import os, sys


from sys import argv
from java.lang import String
from jarray import array



script, x = argv
try:
    r = requests.get(x)
    code = r.status_code
except:
    jythonArray = None
    sys.exit()

soup = BeautifulSoup(r.text.encde("utf-8", "ignore"), 'html.parser') #Parse through HTML 
list = [] #List for the recipe ingredients 

for ingredient in soup.find_all('li', itemprop_='ingredients'):
	list.append(unicodedata.normalize('NFKD',((ingredient.text).strip(' \t\n\r'))).encode('ascii','ignore'))


jythonArray = array(list, String)

