package StudentDatabase;
/*
 * -- Student Database Program - Assignment 2 --
 * -- ENGR3791 - Software Testing --
 *
 * Author(s): Jack Harris
 */

// Imports
import java.lang.StringBuilder;

/**
 *  Represents a Students topic.
 *  Each Student has a list of topics.
 *  Holds topicCode, grade and an optional mark.
 */
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

    public String[] returnTopicInformation(){
        if (mark > 0) {
            return new String[]{this.getTopicCode(), this.getGrade(), String.valueOf(this.getMark())};
        } else {
            return new String[]{this.getTopicCode(), this.getGrade()};
        }
    }

    /**
     * Simply maps the enum grades to a number.
     * @return
     * Returns mark correlating to grade.
     */
    public int mapGradeToMark() {
        switch (this.grade) {
            case FL -> {
                return 0;
            }
            case PS -> {
                return 50;
            }
            case CR -> {
                return 60;
            }
            case DN -> {
                return 70;
            }
            case HD -> {
                return 80;
            }
        }
        return -1;
    }

    // Getters/Setters
    public String getTopicCode() {
        return String.valueOf(topicCode);
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
