import requests
import re
import unicodedata
import os, sys

from bs4 import BeautifulSoup
from sys import argv
#from java.lang import String
#from jarray import array



x = raw_input("Enter the website for the recipe from FoodNetwork: ") #Prompts user for website to scrape\
#Will only work for Food Network for now
r = requests.get(x)
code = r.status_code

if code != requests.codes.ok: #Did it have an error?
	System.out.println("Sorry, there was an error and cannot proceed")
	exit()

##f = open ("recipe.txt", "w") #Open to write
recipe = r.text

soup = BeautifulSoup(r.text.encode("utf-8"), "html.parser")
print soup.prettify()
#f.write(=recipe.encode('utf-8')).strip()) #Puts the text into a text file with no HTML
#Have to parse through and find the first Ingredients (with the space)
#f.close()

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