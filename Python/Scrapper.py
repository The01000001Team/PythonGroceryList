import requests
import re
import jarray
import 

TAG_RE = re.compile(r'<[^>]+>')

def remove_tags(text): #Remove HTML Tags (I know.. the post.. but very specific use!)
    return TAG_RE.sub('', text)


x = raw_input("Enter the website for the recipe from FoodNetwork: ") #Prompts user for website to scrape\
#Will only work for Food Network for now
r = requests.get(x)
code = r.status_code

if code != requests.codes.ok: #Did it have an error?
	System.out.println("Sorry, there was an error and cannot proceed")
	exit()

f = open ("recipe.txt", "w") #Open to write
recipe = r.text
f.write(remove_tags(recipe.encode('utf-8')).strip()) #Puts the text into a text file with no HTML
#Have to parse through and find the first Ingredients (with the space)
f.close()

list = []

f = open ("recipe.txt", "r")
for line in f:
	if "Ingredients" in line and not "Ingredients\"" in line: #Does the list of ingredients start?
		while not "Directions" in line: #Print until directions
			if not line.isspace(): #Avoid empty lines
				list.append(line)
			line = next(f)	#Proceed to the next line in the file

f.close() #Close the text file

for e in list:
	print e
