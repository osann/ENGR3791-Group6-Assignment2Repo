# ENGR3791-Group6-Assignment2Repo
Repo that will serve as the code base for our Java application.


### Potential objects

Student.java

ArtStudent.java | MedStudent.java | StemStudent.java **implements** Student.java

Prize.java

Topic.java

### Object Relationships

Each degree has its own object of Student (ArtStudent.java | MedStudent.java | StemStudent.java)

Each Student object has an array of Topic objects

A MedStudent has an array of up to 10 Prize objects

### Student variables

int studentNum (7 digits)

String familyName

String givenName

String degree (Limited to "Science", "Arts", "Medicine")

ArrayList Topic topicList

**ArtStudent.java specific**

String major

String minor

**MedStudent.java specific**

ArrayList Prize prizeList


### Prize.java

String prizeName

StringBuilder prizeTopic

int min


### Topic.java

StringBuilder topicCode (8 characters)

enum grade ("FL","PS","CR","DN" or "HD")

int mark (0-100, optional)