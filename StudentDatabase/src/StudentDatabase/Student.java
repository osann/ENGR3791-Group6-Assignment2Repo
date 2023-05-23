package StudentDatabase;

// Imports
import org.apache.commons.text.WordUtils;
import java.util.ArrayList;

public class Student {

    // Variables
    protected int studentNum;       /* This needs to be updated so the number must be 7 digits */
    protected String familyName;
    protected String givenName;
    protected String degree;

    // Topic Variables
    ArrayList<Topic> topicList = new ArrayList<>();

    public Student() {
        // Throw an error?
        // Needed this for some reason

    }

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
    public void addTopicResults(String topicCode, String grade) {
        Topic newTopic = new Topic(topicCode, grade);
        topicList.add(newTopic);
    }

    /**
     *  Prints the Students details followed by all topics and grades.
     *  - TODO: Handle topics with marks variable.
     */
    public void printStudentTopicResults() {
        this.printStudentDetails();

        for (Topic topic : topicList) {
            System.out.println(topic.topicCode + " " + topic.grade);
        }

    }

    public void printStudentDetails() {
        String fullName = WordUtils.capitalizeFully(getGivenName() + " " + getFamilyName() +
                " (" + getStudentNum() + ")");
        System.out.println("Academic Record For: " + fullName +
                "\nDegree:   " + WordUtils.capitalizeFully(degree));
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

