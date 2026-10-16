#!/usr/bin/python


filename = input("Enter filename: ")

file = open(filename, "r")
content = file.read()
file.close()

lines = len(content.splitlines())
words = len(content.split())
characters = len(content)

print(f"Lines: {lines}")
print(f"Words: {words}")
print(f"Characters: {characters}")
