import requests

website = input("Enter website URL: ")

response = requests.get(website, timeout=5)

if response.status_code == 200:
    print("Website is UP and healthy")
else:
    print("Not OK")
