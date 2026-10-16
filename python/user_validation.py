#!/usr/local/bin/python


# Script to validate username and password 


def user_info():
    while True:
        name=str(input("Enter your name: "))
        if len(name) >=6 and name.isupper() and name.isalpha():
            print("User is Valid, Welcome ", name)
            break 
        else:
            print("Invalid user, username must be 6 or more chars along with alphanumeric and UPPERCASE")
        


def password_info():
    password=input("Enter your password: ")
    if len(password) < 8:
        print("Invalid Password, Password must contains 8 or above chars")
    else:
        print("Valid Password, Welcome to System login!")


user_info()
password_info()
