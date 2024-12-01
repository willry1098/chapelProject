# Chapel Seating and Attendance Management System

This project provides a complete solution for managing student seating and attendance during assemblies in a school chapel. It consists of two main components:

1. **Python Application**: Generates a graphical layout of the chapel with students assigned to seats based on their names and seniority.  
2. **Java Mobile Application**: Allows faculty to mark student attendance during assembly and email reports to school administrators.

---

## Features

### Python Application: Chapel Seat Assignment
- **Input**: CSV file containing student names and forms.  
- **Output**: CSV file representing the graphical seating layout of the chapel.  
- **Seating Assignment**: Students are assigned seats alphabetically within their form, with priority given by seniority.

### Java Mobile Application: Attendance Management
- **Platform**: Built for Galaxy Note 7 tablets (download directly to devices).  
- **Main Features**:
  - Displays a grid view of the chapel's lower floor seating.
  - Drop-down menu to select a student form and highlight students (red = absent).
  - Tap buttons to toggle individual student attendance (white = present).
  - Attendance submission launches the GMail app with a pre-filled email containing absent students' details.
  
---

## Setup and Usage

### Python Application
1. **Requirements**:
   - Python 3.8+
   - Required libraries (install with `pip install -r requirements.txt`):
     - `pandas`
     - `numpy`
2. **Usage**:
   - Place your input CSV (`students.csv`) in the project directory. The file should include:
     ```
     Name, Form
     John Doe, 12A
     Jane Smith, 11B
     ...
     ```
   - Run the script:
     ```bash
     python generate_seating.py
     ```
   - The output CSV (`chapel_seating.csv`) will be generated in the project directory.

### Java Mobile Application
1. **Installation**:
   - Directly download the APK to Galaxy Note 7 tablets.
   - Install the APK (ensure permissions for third-party apps are enabled).  
2. **Usage**:
   - Open the app on the tablet.
   - Navigate through the chapel grid view.
   - Select the desired form from the drop-down menu to mark all students as absent (red).
   - Tap individual student buttons to toggle attendance (white = present).
   - Submit the attendance by clicking the "Submit Attendance" button:
     - Automatically launches GMail with absent students pre-filled in the email body.
     - Send the email to **Jim Peck** or designated school administrators.


