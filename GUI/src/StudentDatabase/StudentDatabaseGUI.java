package StudentDatabase;

import javax.swing.*;

public class StudentDatabaseGUI {

    private JPanel MAIN;
    private JPanel Student;
    private JLabel studentDataBaseProgramLabel;
    private JPanel DegreeOptions1;
    private JPanel TopicDetails;
    private JPanel AwardPries;
    private JLabel studentNumberLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel familyNameLabel;
    private JLabel givenNameSLabel;
    private JLabel studentDetailsLabel;
    private JLabel degreeLabel;
    private JComboBox DegreeComboBox;
    private JLabel degreeOptionsLabel;
    private JLabel artsMajiorLabel;
    private JTextField artsMajiorTextField;
    private JLabel artsMinorLabel;
    private JTextField artsMinorTextField;
    private JLabel medicinePrizesLabel;
    private JButton addStudentButton;
    private JButton findStudentButton;
    private JButton enterStudentButton;
    private JTextField MedicinePrizesTextField;
    private JLabel topicCodeLabel;
    private JTextField TopicCodeTextField;
    private JLabel markLabel;
    private JTextField MarkTextField;
    private JLabel gradeLabel;
    private JComboBox comboBox1;
    private JButton addTopicResultButton;
    private JButton findTopicResultButton;
    private JLabel prizeNameLabel;
    private JTextField PrizeNameTextField;
    private JTextField templateTextField;
    private JTextField NOfTtextField;
    private JButton printAllRecordsButton;
    private JButton clearAllRecordsButton;
    private JButton awardPrizeButton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public static void MainFrame(){
        JFrame frame = new JFrame("Student DataBase Program");
        frame.setSize(1000,700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {

    }

}
