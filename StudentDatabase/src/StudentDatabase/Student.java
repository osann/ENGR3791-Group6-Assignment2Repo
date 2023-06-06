package StudentDatabase;
/*
 * -- Student Database Program - Assignment 2 --
 * -- ENGR3791 - Software Testing --
 *
 * Author(s): Jack Harris
 */

// Imports
import org.apache.commons.text.WordUtils;
import java.util.ArrayList;

/**
 *  Represents a single Student.
 *  Holds studentNum, familyName, givenName, degree and a topicList.
 */
public class Student {
    // Variables
    protected int studentNum;       /* This needs to be updated so the number must be 7 digits */
    protected String familyName;
    protected String givenName;
    protected String degree;

    // Topic Variables
    protected ArrayList<Topic> topicList = new ArrayList<>();

    // Constructor
    public Student(
            int newStudentNum,
            String newFamilyName,
            String newGivenName,
            String newDegree) {

        this.studentNum = newStudentNum;
        this.familyName = newFamilyName.toLowerCase();
        this.givenName = newGivenName.toLowerCase();
        this.degree = newDegree.toLowerCase();
    }

    // Class functions
    /**
     * Add Topic objects to a Student's Topic array list.
     * @param topicCode
     * Code of the Topic, example "COMP1234"
     * @param grade
     * Grade of the topic, "FL, PS, CR, DN, HD" are valid.
     */
    public void addTopicResults(String topicCode, String grade) {
        Topic newTopic = new Topic(topicCode, grade);
        this.topicList.add(newTopic);
    }

    /**
     * Overloaded method to handle accepting a mark.
     * Add Topic objects to a Student's Topic array list.
     * @param topicCode
     * Code of the Topic, example "COMP1234"
     * @param grade
     * Grade of the topic, "FL, PS, CR, DN, HD" are valid.
     * @param mark
     * Mark for the topic, 1-100
     */
    public void addTopicResults(String topicCode, String grade, int mark) {
        Topic newTopic = new Topic(topicCode, grade, mark);
        this.topicList.add(newTopic);
    }

    /**
     *  Prints the Students details followed by all topics and grades.
     *  If the Topic holds a mark variable it prints this too.
     *  This can easily be changed to return the topicResult String instead of printing it.
     */
    public void printStudentTopicResults() {
        for (Topic topic : topicList) {
            String topicResult = topic.topicCode + " " + topic.grade + " ";
            if (topic.mark != 0) {
                topicResult += topic.mark;
            }
            System.out.println(topicResult);
        }

    }

    public void printStudentDetails() {
        String fullName = WordUtils.capitalizeFully(getGivenName() + " " + getFamilyName() +
                " (" + getStudentNum() + ")");
        System.out.println("Academic Record For: " + fullName +
                "\nDegree:   " + WordUtils.capitalizeFully(degree));
    }

    public String[] returnStudentInformation() {
        return new String[]{String.valueOf(this.studentNum), this.familyName, this.givenName, this.degree};
    }

    public Topic returnTopic(String topicCode) throws Exception {
        for (Topic topic : this.topicList) {
            if (String.valueOf(topic.getTopicCode()).equals(topicCode)) {
                return topic;
            }
        }
        throw new Exception("topicCode does not match.");
    }

    public String[] returnStudentTopicInformation(String topicCode) {
        String[] topicInfo = new String[3];

        try {
            topicInfo = this.returnTopic(topicCode).returnTopicInformation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topicInfo;
    }

    // Getters/Setters
    public String getFamilyName() {
        return familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getDegree() {
        return degree;
    }

    public int getStudentNum() {
        return studentNum;
    }

}

