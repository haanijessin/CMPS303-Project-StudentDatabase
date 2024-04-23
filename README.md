# CMPS303-Project-QU-Student-Database

**Qatar University Spring2021 Dept. of Computer Science and Eng.**  
**CMPS303 - Data Structure**  
**Course Project**

In this project, we aim to implement a structure that improves operations of inserting and searching for a student at Qatar University. To achieve this, we'll use a hash table that contains trees (treeTable), where each tree holds only data of students admitted in a specific year.

![Figure 1](https://i.imgur.com/CS96OXi.png)

We will keep data for 20 years, so the table length is 20, and your hash function will be h(year)= year % 20. Using linear probing, implement the following functionalities in treeTable:

## Implementation

1. Each node in the tree will hold an object of type Student.
2. Student class has: id (int), name(String), address(String), GPA(double).
3. A treeTable class that applies the structure above, which has the following methods:

   - void insert(Student): This method inserts students in the appropriate tree based on his id.
   - Student find(int): It receives an id and returns the student record with that id, or null if it was not found.
   - Student update(int): It receives an id and it will allow the user to update the selected record, or return null if it was not found.
   - boolean remove(int): It receives a student's id, removes his record if found, and returns true, or returns false if it was not found.
   - void printStudent(int): It receives an integer number representing the year, then prints students' data who were admitted in that year using inorder approach.
   - void printAll(): This method prints all students in the treeTable using the preorder approach.
   - ArrayList<Student> studentWithGPA(double): It returns an ArrayList of all students whose GPA is below the received parameter.

4. The main application has a menu with the following functionalities:

   - Add new student: Prompts the user to enter student’s data, then inserts it into the treeTable.
   - Search for a student: Prompts the user to enter an id then searches in treeTable and displays the result.
   - Update student’s data: Allows the user to update the student’s information.
   - Delete a student: Prompts the user to enter a student id, then removes his record, or displays a message indicating this student was not found.
   - Display student’s data: Prompts the user to enter a year, then displays students’ data of that year.
   - Display students' data: Prints all students in the treeTable using the preorder approach.
   - Display students with less GPA: Prompts the user to enter a number, then displays students’ data whose GPA is less than the input value.
   - Save to file: Saves treeTable to a file.
   - Load data: Loads data from a file to treeTable.
