import requests
import unicodedata
import os, sys

from bs4 import BeautifulSoup
from sys import argv
from java.lang import String
from jarray import array

#Computes the median of the array
def median(array):
    if len(array) == 0:
        med = None
        sys.exit()
    array.sort()
    return array[len(array)/2]


script, x = argv #Parameter for user to search an item
#Will only work for Target now

try:
	r = requests.get('http://www.target.com/s?searchTerm='+x+'&category=9975358%7CAll%7Cmatchallpartial%7Cgrocery+%26+essentials&lnk') #Does the website work?
	code = r.status_code
except:
	med = None #Handle error
	sys.exit() #Bai


soup = BeautifulSoup(r.text.encode("utf-8", "ignore"), 'html.parser') #Parse through HTML
prices = [] #List for prices

for price in soup.find_all('p', class_='price price-label'):
	for character in price.text:
			if character == "$": #Save only actual prices
				prices.append(unicodedata.normalize('NFKD',((price.text).strip(' $\t\n\r'))).encode('ascii','ignore'))



med = float(median(prices)) #Store the median of all the prices
