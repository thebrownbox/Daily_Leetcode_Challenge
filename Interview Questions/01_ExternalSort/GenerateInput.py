"""
Create file with random 1 - MAX_BYTE_PER_LINE characters (a-z)
Command: python GenerateInput.py fileSize fileName
Default: fileSize:1MB, fileName:"input.txt" 
"""

import sys
import random
import string

DEFAULT_FILE_SIZE = 1 # in MegaByte (MB)
DEFAULT_FILE_NAME = "input.txt"
MAX_BYTE_PER_LINE = 70# = number of char in one line

def main(fileSize, fileName):
    print("Generate file " + fileName + " size " + str(fileSize) + " MB")
    fileSize = fileSize * 1024 * 1024
    total_bytes = 0    
    file = open(fileName, 'w')
    while total_bytes < fileSize:
        number_of_char = random.randrange(1, MAX_BYTE_PER_LINE)
        line = "".join(random.choices(string.ascii_lowercase,k=number_of_char))
        file.write(line)
        file.write('\n')
        total_bytes += (number_of_char+2)
    file.close()

if __name__ == "__main__":
    fileSize = DEFAULT_FILE_SIZE
    fileName = DEFAULT_FILE_NAME
    if len(sys.argv) > 1:
        fileSize = int(sys.argv[1])
    if len(sys.argv) > 2:
        fileName = sys.argv[2]
    main(fileSize, fileName)