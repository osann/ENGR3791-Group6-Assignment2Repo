# ENGR3791-Group6-Assignment2Repo
Repo that will serve as the code base for our Java application.


### Potential objects

Student.java

ArtStudent.java | MedStudent.java **implements** Student.java

Prize.java

Result.java


### Student variables

int studentNum (7 digits)

String familyName

String givenName

String degree (Limited to "Science", "Arts", "Medicine")

ArrayList Result resultsList

**ArtStudent.java specific**

String major

String minor

**MedStudent.java specific**

ArrayList Prize prizeList


### Prize.java

String prizeName

String prizeDesc

String prizeTopic

int minAttempt


### Result.java

String topicCode (8 characters)

String grade ("FL","PS","CR","DN" or "HD")

int mark (0-100, optional)