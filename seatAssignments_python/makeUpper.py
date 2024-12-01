# Chapel Seating Scripting (Upper Level)
# William Ryan
# August 2023

# Takes in a CSV of all MS students
# organized alphabetically by last name, followed by ascending form order
    # Form 1 (A --> Z)
    # Form 2 (A --> Z)
    # Form 3 (A --> Z)

import csv

#GLOBAL VARIABLES
wholeChapelArray = [[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[]]

# FUNCTION DEFINITIONS

# creates 26Wx32L array of dictionaries (containing each seat info -- including assignability)
def buildChapel():
    for row in range(0, 32):
        for letter in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
            wholeChapelArray[row].append(buildNextSeat(row, letter))

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
def buildStudentRoster():

    filePointer = open("middleSchoolRoster.csv", "r")

    # declare empty list
    studentRoster = []

    # get student info from CSV
    for line in filePointer:

        # remove unwanted characters from input string (",\n"
        line = line.replace("\n", "")
        line = line.replace("\"", "")
        line = line.replace("\ufeff", "")

        # split string into list [lastName, firstName, Form]
        studentInfo = line.split(",")
        # print(studentInfo)

        # add individual student to full roster
        studentRoster.append(studentInfo)

    filePointer.close()

    return(studentRoster)

# assigns each open seat to a student
def assignSeats(studentRoster):

    # Assign zone 5 of chapel (upper organ-left) {FORM 1}
    for row in range (9, 6, -1):
        for column in range (10, 3, -1):
            currentStudent = studentRoster.pop(0)
            wholeChapelArray[row][column]["nameLast"] = currentStudent[0]
            wholeChapelArray[row][column]["nameFirst"] = currentStudent[1]
            wholeChapelArray[row][column]["form"] = currentStudent[2]
    for row in range (4, 0, -1):
        for column in range (8, 4, -1):
            currentStudent = studentRoster.pop(0)
            wholeChapelArray[row][column]["nameLast"] = currentStudent[0]
            wholeChapelArray[row][column]["nameFirst"] = currentStudent[1]
            wholeChapelArray[row][column]["form"] = currentStudent[2]
    # Assign zone 6 of chapel (upper wing left) {FORM 1}
    # Column 2 (C)
    for row in range (8, 16, 1): # CHANGE FIRST PARAMETER TO ADJUST FOR YEAR-YEAR VARIANCE
        if (studentRoster[0][2] == "Form I"):
            currentStudent = studentRoster.pop(0)
            wholeChapelArray[row][2]["nameLast"] = currentStudent[0]
            wholeChapelArray[row][2]["nameFirst"] = currentStudent[1]
            wholeChapelArray[row][2]["form"] = currentStudent[2]
    # Column 1 (B)
    for row in range (15, 6, -1): # CHANGE FIRST PARAMETER TO ADJUST FOR YEAR-YEAR VARIANCE
        if (studentRoster[0][2] == "Form I"):
            currentStudent = studentRoster.pop(0)
            wholeChapelArray[row][1]["nameLast"] = currentStudent[0]
            wholeChapelArray[row][1]["nameFirst"] = currentStudent[1]
            wholeChapelArray[row][1]["form"] = currentStudent[2]
    # the following section fills in the curved benches in the very back corner {FORM 1}
    if (studentRoster[0][2] == "Form I"):
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[5][1]["nameLast"] = currentStudent[0]
        wholeChapelArray[5][1]["nameFirst"] = currentStudent[1]
        wholeChapelArray[5][1]["form"] = currentStudent[2]
    if (studentRoster[0][2] == "Form I"):
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[5][2]["nameLast"] = currentStudent[0]
        wholeChapelArray[5][2]["nameFirst"] = currentStudent[1]
        wholeChapelArray[5][2]["form"] = currentStudent[2]
    if (studentRoster[0][2] == "Form I"):
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[3][1]["nameLast"] = currentStudent[0]
        wholeChapelArray[3][1]["nameFirst"] = currentStudent[1]
        wholeChapelArray[3][1]["form"] = currentStudent[2]
    if (studentRoster[0][2] == "Form I"):
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[3][2]["nameLast"] = currentStudent[0]
        wholeChapelArray[3][2]["nameFirst"] = currentStudent[1]
        wholeChapelArray[3][2]["form"] = currentStudent[2]

    # Assign zone 7 of chapel (upper organ-right) {FORM 2}
    for row in range (9, 6, -1):
        for column in range (12, 19, 1):
            currentStudent = studentRoster.pop(0)
            wholeChapelArray[row][column]["nameLast"] = currentStudent[0]
            wholeChapelArray[row][column]["nameFirst"] = currentStudent[1]
            wholeChapelArray[row][column]["form"] = currentStudent[2]
    for row in range (4, 0, -1):
        for column in range (14, 18, 1):
            currentStudent = studentRoster.pop(0)
            wholeChapelArray[row][column]["nameLast"] = currentStudent[0]
            wholeChapelArray[row][column]["nameFirst"] = currentStudent[1]
            wholeChapelArray[row][column]["form"] = currentStudent[2]
    # Assign zone 8 of chapel (upper wing right) {FORM 2}
    # Column 20 (U)
    for row in range (9, 24, 1): # CHANGE SECOND PARAMETER TO ADJUST FOR YEAR-YEAR VARIANCE
        if (studentRoster[0][2] == "Form II"):
            currentStudent = studentRoster.pop(0)
            wholeChapelArray[row][20]["nameLast"] = currentStudent[0]
            wholeChapelArray[row][20]["nameFirst"] = currentStudent[1]
            wholeChapelArray[row][20]["form"] = currentStudent[2]
    # Column 21 (V)
    for row in range (23, 8, -1): # CHANGE SECOND PARAMETER TO ADJUST FOR YEAR-YEAR VARIANCE
        if (studentRoster[0][2] == "Form II"):
            currentStudent = studentRoster.pop(0)
            wholeChapelArray[row][21]["nameLast"] = currentStudent[0]
            wholeChapelArray[row][21]["nameFirst"] = currentStudent[1]
            wholeChapelArray[row][21]["form"] = currentStudent[2]
    # the following section fills in the curved benches in the very back corner {FORM 2}
    if (studentRoster[0][2] == "Form II"):
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[5][20]["nameLast"] = currentStudent[0]
        wholeChapelArray[5][20]["nameFirst"] = currentStudent[1]
        wholeChapelArray[5][20]["form"] = currentStudent[2]
    if (studentRoster[0][2] == "Form II"):
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[5][21]["nameLast"] = currentStudent[0]
        wholeChapelArray[5][21]["nameFirst"] = currentStudent[1]
        wholeChapelArray[5][21]["form"] = currentStudent[2]
    if (studentRoster[0][2] == "Form II"):
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[3][20]["nameLast"] = currentStudent[0]
        wholeChapelArray[3][20]["nameFirst"] = currentStudent[1]
        wholeChapelArray[3][20]["form"] = currentStudent[2]
    if (studentRoster[0][2] == "Form II"):
        currentStudent = studentRoster.pop(0)
        wholeChapelArray[3][21]["nameLast"] = currentStudent[0]
        wholeChapelArray[3][21]["nameFirst"] = currentStudent[1]
        wholeChapelArray[3][21]["form"] = currentStudent[2]



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
    with open("./chapelUpper.csv", "w") as csvPointer:
        write = csv.writer(csvPointer)
        write.writerows(myCSVlist)


### MAIN CODE ###
if __name__ == '__main__':

    buildChapel()

    # List of lists containing info for student [lastName, firstName, Form]
    studentRoster = buildStudentRoster()

    print(studentRoster)

    assignSeats(studentRoster)

    # printChapel()

    makeCSV()

    # makeList()
