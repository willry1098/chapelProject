# Chapel Seating Scripting (Lower Level)
# William Ryan
# August 2022

# Usage:
#  Input: a csv file <"studentRoster.csv"> containing the names of all students 
#             organized alphabetically by last name, followed by descending form order
#             Form 6 (A --> Z)
#             Form 5 (A --> Z)
#             Form 4 (A --> Z) ...
#  Output: a csv file containing the assigned seats of the lower floor of the chapel.

import csv

#GLOBAL VARIABLES
wholeChapelArray = [[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[]]

# FUNCTION DEFINITIONS

# creates 26x32 array of dictionaries (containing each seat info -- including assignability)
def buildChapel():
    for row in range(0, 32):
        for letter in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
            wholeChapelArray[row].append(buildNextSeat(row, letter))

    # assignment boolean adjustments {INCOMPLETE}
    for row in wholeChapelArray:
        for seat in row:
            if seat["row"] == 1 and (seat["col"] > 'S' and seat["col"] < 'W'):
                seat["assignable"] = True
            elif seat["row"] == 2 and ((seat["col"] > 'I' and seat["col"] < 'P') or (seat["col"] > 'S' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 3 and ( (seat["col"] > 'C' and seat["col"] < 'G') or (seat["col"] > 'I' and seat["col"] < 'Q') or (seat["col"] > 'S' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 4 and ( (seat["col"] > 'C' and seat["col"] < 'G') or (seat["col"] > 'I' and seat["col"] < 'Q') or (seat["col"] > 'S' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 5 and ( (seat["col"] > 'C' and seat["col"] < 'G') or (seat["col"] > 'I' and seat["col"] < 'R') or (seat["col"] > 'S' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 6 and ( (seat["col"] > 'C' and seat["col"] < 'H') or (seat["col"] > 'I' and seat["col"] < 'R') or (seat["col"] > 'R' and seat["col"] < 'W')):
                seat["assignable"] = True
            # Rows 7 and 8 have seats removed for AV Table -- c.2022
            elif seat["row"] == 7 and ( (seat["col"] > 'C' and seat["col"] < 'F') or (seat["col"] > 'H' and seat["col"] < 'R')):
                seat["assignable"] = True
            elif seat["row"] == 8 and ( (seat["col"] > 'C' and seat["col"] < 'F') or (seat["col"] > 'H' and seat["col"] < 'R')):
                seat["assignable"] = True
            elif seat["row"] == 9 and ( (seat["col"] > 'C' and seat["col"] < 'H') or (seat["col"] > 'H' and seat["col"] < 'R') or (seat["col"] > 'R' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 10 and ( (seat["col"] > 'C' and seat["col"] < 'H') or (seat["col"] > 'H' and seat["col"] < 'R') or (seat["col"] > 'R' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 11 and ( (seat["col"] > 'C' and seat["col"] < 'H') or (seat["col"] > 'H' and seat["col"] < 'R') or (seat["col"] > 'R' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 12 and ( (seat["col"] > 'C' and seat["col"] < 'H') or (seat["col"] > 'H' and seat["col"] < 'R') or (seat["col"] > 'R' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 13 and ( (seat["col"] > 'C' and seat["col"] < 'H') or (seat["col"] > 'H' and seat["col"] < 'R') or (seat["col"] > 'R' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 14 and ( (seat["col"] > 'C' and seat["col"] < 'H') or (seat["col"] > 'H' and seat["col"] < 'R') or (seat["col"] > 'R' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 15 and ( (seat["col"] > 'C' and seat["col"] < 'H') or (seat["col"] > 'H' and seat["col"] < 'R') or (seat["col"] > 'R' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 16 and ( (seat["col"] > 'C' and seat["col"] < 'H') or (seat["col"] > 'H' and seat["col"] < 'R') or (seat["col"] > 'R' and seat["col"] < 'W')):
                seat["assignable"] = True
            elif seat["row"] == 17 and ( (seat["col"] > 'C' and seat["col"] < 'H') or (seat["col"] > 'J' and seat["col"] < 'P') or (seat["col"] > 'R' and seat["col"] < 'W')):
                seat["assignable"] = True
            # Row 18 includes faculty reserved seating
            elif seat["row"] == 18 and ( (seat["col"] > 'J' and seat["col"] < 'P') ):
                seat["assignable"] = True
            # Rows 19 and 20 are used for the horizontal alley
            elif seat["row"] == 21 and ( (seat["col"] > 'A' and seat["col"] < 'D') or (seat["col"] > 'F' and seat["col"] < 'U') or (seat["col"] > 'W' and seat["col"] < 'Z')):
                seat["assignable"] = True
            elif seat["row"] == 22 and ( (seat["col"] > 'A' and seat["col"] < 'D') or (seat["col"] > 'F' and seat["col"] < 'U') or (seat["col"] > 'W' and seat["col"] < 'Z')):
                seat["assignable"] = True
            elif seat["row"] == 23 and ( (seat["col"] > 'A' and seat["col"] < 'F') or (seat["col"] > 'F' and seat["col"] < 'U') or (seat["col"] > 'U' and seat["col"] < 'Z')):
                seat["assignable"] = True
            elif seat["row"] == 24 and ( (seat["col"] > 'A' and seat["col"] < 'F') or (seat["col"] > 'U' and seat["col"] < 'Z')):
                seat["assignable"] = True
            elif seat["row"] == 25 and ( (seat["col"] > 'A' and seat["col"] < 'F') or (seat["col"] > 'U' and seat["col"] < 'Z')):
                seat["assignable"] = True
            elif seat["row"] == 26 and ( (seat["col"] > 'A' and seat["col"] < 'F') or (seat["col"] > 'U' and seat["col"] < 'Z')):
                seat["assignable"] = True
            elif seat["row"] == 27 and ( (seat["col"] > 'A' and seat["col"] < 'F') or (seat["col"] > 'U' and seat["col"] < 'Z')):
                seat["assignable"] = True
            elif seat["row"] == 28 and ( (seat["col"] > 'A' and seat["col"] < 'C') or (seat["col"] > 'U' and seat["col"] < 'Z')):
                seat["assignable"] = True
            elif seat["row"] == 29 and ( (seat["col"] > 'A' and seat["col"] < 'C') or (seat["col"] > 'U' and seat["col"] < 'Z')):
                seat["assignable"] = True

# prints column and row of each seat in grid
def printChapel():
    for row in wholeChapelArray:
        for seat in row:
            #print(seat["col"], seat["row"], end = " | ")
            print(seat["nameFirst"][1], seat["nameLast"], end=" | ")
        print()

# creates a dictionary with a single seat's information
def buildNextSeat(rowLetter, colNumber, assignable = False, nameLast = "", nameFirst = "  ", form = 0):
    newSeat = {
        "row"       : rowLetter,
        "col"       : colNumber,
        "assignable": assignable,
        "nameLast"  : nameLast,
        "nameFirst" : nameFirst,
        "form"      : form,
        "attendance": True
    }
    return newSeat

# returns a list of all student lists [lastName, firstName, form]
def buildStudentRoster(filePointer):

    # declare empty list
    studentRoster = []

    # get student info from CSV
    for line in filePointer:

        # remove unwanted characters from input string (",\n"
        line = line.replace("\n", "")
        line = line.replace("\"", "")
        line = line.replace("\ufeff", "")

        # split string into list
        studentInfo = line.split(",")
        # print(studentInfo)

        # add individual student to full roster
        studentRoster.append(studentInfo)

    return(studentRoster)

# assigns each open seat to a student
def assignSeats(studentRoster):

    # Assign zone 1 of chapel (lower stage-right)
    #   Column numbers represent location in python array
    #   Column letters represent location in Excel representation
    for i in range(7):  # Col 21 (V)
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[29-i][21]["nameLast"]  = currentStudent[0]
        wholeChapelArray[29-i][21]["nameFirst"] = currentStudent[1]
        wholeChapelArray[29-i][21]["form"]      = currentStudent[2]
    for i in range(7):  # Col 22 (W)
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[29-i][22]["nameLast"]  = currentStudent[0]
        wholeChapelArray[29-i][22]["nameFirst"] = currentStudent[1]
        wholeChapelArray[29-i][22]["form"]      = currentStudent[2]
    for i in range(9):  # Col 23 (X)
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[29-i][23]["nameLast"]  = currentStudent[0]
        wholeChapelArray[29-i][23]["nameFirst"] = currentStudent[1]
        wholeChapelArray[29-i][23]["form"]      = currentStudent[2]
    for i in range(9):  # Col 24 (Y)
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[29-i][24]["nameLast"]  = currentStudent[0]
        wholeChapelArray[29-i][24]["nameFirst"] = currentStudent[1]
        wholeChapelArray[29-i][24]["form"]      = currentStudent[2]

    # Assign zone 2 (lower stage-left)
    for i in range(5):  # Col 5 (E)
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[27-i][4]["nameLast"]  = currentStudent[0]
        wholeChapelArray[27-i][4]["nameFirst"] = currentStudent[1]
        wholeChapelArray[27-i][4]["form"]      = currentStudent[2]
    for i in range(5):  # Col 4 (D)
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[27-i][3]["nameLast"]  = currentStudent[0]
        wholeChapelArray[27-i][3]["nameFirst"] = currentStudent[1]
        wholeChapelArray[27-i][3]["form"]      = currentStudent[2]
    for i in range(7):  # Col 3 (C)
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[27-i][2]["nameLast"]  = currentStudent[0]
        wholeChapelArray[27-i][2]["nameFirst"] = currentStudent[1]
        wholeChapelArray[27-i][2]["form"]      = currentStudent[2]
    for i in range(9):  # Col 1 (B)
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[29-i][1]["nameLast"]  = currentStudent[0]
        wholeChapelArray[29-i][1]["nameFirst"] = currentStudent[1]
        wholeChapelArray[29-i][1]["form"]      = currentStudent[2]

    # Assign zone 3 (lower center)
    for i in range (19, 5, -1):
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[23][i]["nameLast"] = currentStudent[0]
        wholeChapelArray[23][i]["nameFirst"] = currentStudent[1]
        wholeChapelArray[23][i]["form"] = currentStudent[2]
    for i in range (19, 5, -1):
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[22][i]["nameLast"] = currentStudent[0]
        wholeChapelArray[22][i]["nameFirst"] = currentStudent[1]
        wholeChapelArray[22][i]["form"] = currentStudent[2]
    for i in range (19, 5, -1):
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[21][i]["nameLast"] = currentStudent[0]
        wholeChapelArray[21][i]["nameFirst"] = currentStudent[1]
        wholeChapelArray[21][i]["form"] = currentStudent[2]


    # Assign zone 4 (rest of bottom floor -- Excel rows 19 to 1)
    for row in range (20, 0, -1):
        for col in range(25, 0, -1):
            seat = wholeChapelArray[row][col]
            if (seat["assignable"]):
                currentStudent    = studentRoster.pop(0)
                seat["nameLast"]  = currentStudent[0]
                seat["nameFirst"]  = currentStudent[1]
                seat["form"]      = currentStudent[2]
                #print(seat)
            else:
                #print(seat)
                pass

# creates a csv file which conforms to the chapel diagram with all seats assigned
def makeCSV():
    myCSVstring = ""
    for i in range (1, 32):
        for j in range (0, 26):
            if (wholeChapelArray[i][j]["nameFirst"][1] != " "):
                myCSVstring += (wholeChapelArray[i][j]["nameFirst"][1] + ". " + wholeChapelArray[i][j]["nameLast"])
            myCSVstring += ","
        myCSVstring += "\n"
    #print(myCSVstring)

    myCSVlist = [[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[]]
    for i in range (0, 32):
        for j in range (0, 26):
            if (wholeChapelArray[i][j]["nameFirst"][1] != " "):
                myCSVlist[i].append(wholeChapelArray[i][j]["nameFirst"][1] + ". " + wholeChapelArray[i][j]["nameLast"])
            else:
                myCSVlist[i].append("")
    #print(myCSVlist)
    with open("./chapelLower.csv", "w") as csvPointer:
        write = csv.writer(csvPointer)
        write.writerows(myCSVlist)

def makeList():
    chapelList = []
    for row in range(1, 30):
        for col in range(1, 25):
            seat = wholeChapelArray[row][col]
            if len(seat["nameFirst"]) > 2:
                chapelList.append(seat["nameFirst"][1] + " " + seat["nameLast"] + "-" + seat["form"])
            else:
                chapelList.append("")

    for name in chapelList:
        print(name, end = "\", \"")


### MAIN CODE ###
if __name__ == '__main__':

    buildChapel()

    # List of lists containing info for student
    filePointer = open("studentRoster.csv", "r")
    studentRoster = buildStudentRoster(filePointer)
    filePointer.close()

    print(studentRoster)

    assignSeats(studentRoster)

    # printChapel()

    makeCSV()

    makeList()


