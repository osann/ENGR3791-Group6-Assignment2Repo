package StudentDatabase;

// Imports
import org.apache.commons.text.WordUtils;
import java.util.ArrayList;

public class Student {

    // Variables
    protected int studentNum; // Maybe change this to StringBuilder or String?
    protected String familyName;
    protected String givenName;
    protected String degree;

    // Topic Variables
    ArrayList<Topic> topicArrayList = new ArrayList<Topic>();

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
    public void printStudent() {
        String fullName = WordUtils.capitalizeFully(givenName + " " + familyName);
        System.out.println("Academic Record For: " + fullName +
                "\nDegree:   " + WordUtils.capitalizeFully(degree));
    }

    // Getters/Setters
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getStudentNum() {
        return studentNum;
    }

}

