package StudentDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentDatabaseGUI extends JFrame{

    private JPanel mainPanel;
    private JLabel awardPrizesLabel;
    private JLabel topicDetailsLabel;
    private JLabel degreeOptionsLabel;
    private JLabel studentDetailsLabel;
    private JTextField studentNumberTextField;
    private JTextField FamilyNameTextField;
    private JTextField gNametextField;
    private JComboBox degreeComboBox;
    private JTextField aMtextField;
    private JTextField aMinorTextField;
    private JTextField mPTextField;
    private JComboBox gComboBox;
    private JTextField tCodeTextField;
    private JTextField markTextField;
    private JTextField templateTextField;
    private JTextField nOTTextField;
    private JButton addStudentButton;
    private JButton findStudentButton;
    private JButton addTopicResultButton;
    private JButton findTopicResultButton;
    private JButton printAllRecordsButton;
    private JButton clearAllRecordsButton;
    private JButton awardPrizeButton;
    private JLabel studentNumberLabel;
    private JLabel familyNameLabel;
    private JLabel givenNameSLabel;
    private JLabel degreeLabel;
    private JLabel artsMajorLabel;
    private JLabel artsMinorLabel;
    private JLabel medicinePrizesLabel;
    private JLabel topicCodeLabel;
    private JLabel gradeLabel;
    private JLabel markLabel;
    private JLabel prizeNameLabel;
    private JLabel templateLabel;
    private JTextField prizeNameTextField;
    private JLabel numberOfTopicsLabel;
    private JLabel showText;


    private void createUIComponents() {


    }


    public StudentDatabaseGUI() {
        setTitle("Student Database Program");
        setSize(1500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createUIComponents();

        setContentPane(mainPanel);
        setVisible(true);


        addStudentButton.addActionListener(new ActionListener() { //for the add Student botton
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentNumber = studentNumberTextField.getText();
                String familyName = FamilyNameTextField.getText();
                String givenN = gNametextField.getText();
                String degree = String.valueOf(degreeComboBox.getSelectedItem());
                String aMtext = aMtextField.getText();
                String aMinor = aMinorTextField.getText();
                String mP = mPTextField.getText();
                String tCode = tCodeTextField.getText();
                String mark = markTextField.getText();
                String grade = String.valueOf(gComboBox.getSelectedItem());
                String prizeName = prizeNameTextField.getText();
                String template = templateTextField.getText();
                String nOT = nOTTextField.getText();


                showText.setText(studentNumber + "  " + familyName + "  " + givenN + " " + degree + aMtext + aMinor + mP + tCode + mark + grade + prizeName + template + nOT);

            }
        });

    }

    public static void main(String[] args) {
        StudentDatabaseGUI myFr = new StudentDatabaseGUI();
    }

}
