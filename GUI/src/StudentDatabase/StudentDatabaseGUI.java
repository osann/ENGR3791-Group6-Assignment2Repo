package StudentDatabase;

import javax.swing.*;

public class StudentDatabaseGUI extends JFrame{

    private JPanel mainPanel;
    private JLabel awardPrizesLabel;
    private JLabel topicDetailsLabel;
    private JLabel degreeOptionsLabel;
    private JLabel studentDetailsLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox comboBox2;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField10;
    private JTextField textField9;
    private JTextField textField11;
    private JButton addStudentButton;
    private JButton findStudentButton;
    private JButton addTopicResultButton;
    private JButton findTopicResultButton;
    private JButton printAllRecordsButton;
    private JButton clearAllRecordsButton;
    private JButton awardPrizeButton;


    private void createUIComponents() {

    }


    public StudentDatabaseGUI() {
        setTitle("Student Database Program");
        setSize(1500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createUIComponents();

        setContentPane(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        StudentDatabaseGUI myFr = new StudentDatabaseGUI();
    }

}
