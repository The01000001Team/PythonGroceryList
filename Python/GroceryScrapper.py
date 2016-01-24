import requests
import re
import unicodedata
import os, sys

from bs4 import BeautifulSoup
from sys import argv
from java.lang import String
from jarray import array

def median(array):
    array.sort()
    return array[len(array)/2]

#x = raw_input("Enter the name of the item we are searching for: ") #Prompts user item to search
#Will only work for Target now
script, x = argv

try:
	r = requests.get('http://www.target.com/s?searchTerm='+x)
	code = r.status_code
except: 
	jythonArray = None
	sys.exit()

#if code != requests.codes.ok: #Did it have an error?
#	System.out.println("Sorry, there was an error and cannot proceed")
#	exit()

f = open ("groceries", "w") #Open to write
pricesList = r.text

soup = BeautifulSoup(r.text.encode("utf-8", "ignore"), 'html.parser')
prices = []

for price in soup.find_all('p', class_='price price-label'):
	for character in price.text:
			if character == "$":
				prices.append(unicodedata.normalize('NFKD',((price.text).strip(' $\t\n\r'))).encode('ascii','ignore'))
			

	
med = median(prices)


#print soup.prettify()
f.write(soup.encode("utf-8").strip()) #Puts the text into a text file with no HTML
#Have to parse through and find the first Ingredients (with the space)
f.close()

#list = []

#f = open ("recipe.txt", "r")
#for line in f:
#	if "Ingredients" in line and not "Ingredients\"" in line: #Does the list of ingredients start?
#		while not "Directions" in line: #Print until directions
#			if not line.isspace(): #Avoid empty lines
#				list.append(unicodedata.normalize('NFKD',(line.strip(' \t\n\r'))).encode('ascii','ignore'))
#			line = next(f)	#Proceed to the next line in the file

			
#jythonArray = array(list, String)
#f.close() #Close the text file
#os.remove(f.name) #removes the file from memory
