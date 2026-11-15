#!/usr/local/bin/python

#Script to validate username and Password

def user_info():
    name=str(input("Enter your name: "))
    if name == "Anjum":
        print("User is Valid, Welcome",name)
        return True
    else:
        print("Invalid User")
        return False


def password_info():
    password=input("Enter your password: ")
    if len(password)<8:
        print("Invalid password, password must contain 8 or above characters")
    else:
        print("Valid password, Welcome to systen klogin: ")

if user_info():
    password_info()

