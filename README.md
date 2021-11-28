# CMPS303-Project-QU-Student-Database

**Qatar University Spring2021 Dept. of Computer Science and Eng.**

**CMPS303 - Data Structure**

**Course Project** 

Student ID at Qatar University is composed of year of admission and students number.  In this project, we aim to implement a structure that improves operations of inserting and searching for a student. To enhance these operations when using tree data structure, we will use hash table that contains trees (***treeTable***) where each tree holds only data of students admitted in a specific year. Figure 1 illustrates this concept: 

![](https://i.imgur.com/CS96OXi.png)

We will keep data for 20 years so the table length is 20, and your hash function will be h(year)= year% 20. Using linear probing implement the following functionalities in treeTable: 

**Implementation:** 

1-  Each node in the tree will hold an object of type Student. 

2-  Student class has: id (int), name(String), address(String), GPA(double). 

3-  Implement a class ***treeTable*** that apply the structure above, which has the following methods: 

1) ***void insert(Student)***, this method inserts students in the appropriate tree based on his id. 
1) ***Student find(int)***, it receives an id, and returns student record with that id, or it returns null if it was not found. 
1) ***Student update(int)***, it receives an id, and it will allow the user to update the selected record, or it returns null if it was not found. 
1) ***boolean remove(int)***, it receives student’ id, removes his record if found and returns true, or returns false if it was not found. 
1) ***void  printStudent (int)***,  it receives an  integer  number  represents the  year,  then prints students’ data who were admitted in that year using inoder approach. 
1) ***void printAll()***, this method prints all students in the treeTable using preorder approach. 
1) ***Student studentWithGPA(double)***, it returns array list of all students whose GPA is below the received parameter. 

4-  Your main application should have a menu with the following functionalities: 

1) ***Add new student***: which prompts user to enter student’s data, then insert it to the *treeTable.*
1) ***Search for a student***: which prompts user to enter an id then search in *treeTable* and display the result. 
1) ***Update student’s data***: which will allow the user to update the student’s information. 
1) ***Delete a student***: which prompts user to enter a student id, then remove his record, or display a message indicating this student was not found. 
1) ***Display student’s data***: which prompts the user to enter a year, then display students’ data of that year. 
1) ***Display  students’  data***:  which  prints  all  students  in  the  treeTable  using  the  preorder approach. 
1) ***Display students with less GPA***: it prompts user to enter a number, then display students’ data whose GPA is less than the input value. 
1) ***Save to file***: which saves treeTable to a file.
1) ***Load data***: which loads data from a file to treeTable. 

