package StudentDatabase;

// Imports
import java.lang.StringBuilder;

// Authors: Jack Harris,

public class Topic {

    // Enum to handle the options for grades
    private enum Grade {
        FL,
        PS,
        CR,
        DN,
        HD
    }

    // Variables
    protected StringBuilder topicCode = new StringBuilder(8);
    protected Grade grade;
    protected int mark;

    // Default Constructor
    public Topic(
            String newTopicCode,
            String newGrade) {

        this.topicCode.append(newTopicCode); // TODO: Add a check to make sure newTopicCode is 8 Char

        this.grade = Grade.valueOf(newGrade); // TODO: Add a check to make sure newGrade is 2 Char
                                                // !! This will fail the enum check at least, maybe add a handle
    }

    // Constructor to handle optional marks variable
    public Topic(
            String newTopicCode,
            String newGrade,
            int newMark) {
        // Call default constructor
        this(newTopicCode, newGrade);

        // Check if newMark > 0 and < 100
        if (newMark < 0 || newMark > 100) {
            throw new IllegalArgumentException();
        } else {
            this.mark = newMark;
        }
    }

    // Class functions
    public void printTopicResults(){
        System.out.println("Topic Code: " + this.topicCode +
                "\nGrade:      " + this.grade);
    }

    // Getters/Setters
    public StringBuilder getTopicCode() {
        return topicCode;
    }

    public void setTopicCode(StringBuilder topicCode) {
        this.topicCode = topicCode;
    }

    public String getGrade() {
        return grade.toString();
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
