#!/usr/bin/python

# create a file for write and read

def file_write():
    file=open("file.txt","w")
    file.write("This is my devops course \n")
    file.write("Linux calss is completed \n")
    file.write("My first month class is going on \n")
    file.close()

def file_read():
    file=open("file.txt","r")
    print(file.read())
    file.close()

#file_write()
file_read()


