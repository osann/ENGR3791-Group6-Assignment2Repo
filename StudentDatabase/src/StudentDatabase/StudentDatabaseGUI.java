package StudentDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class StudentDatabaseGUI extends JFrame{

    //function in the GUI
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

    private String studentNumber;
    static StudentFactory studentList = new StudentFactory("Example Academy");



    // for save the data from list
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

                String[] inputs = new String[6];

                String studentNumber = studentNumberTextField.getText();
                String familyName = FamilyNameTextField.getText();
                String givenN = gNametextField.getText();
                String degreeCombox = String.valueOf(degreeComboBox.getSelectedItem());
                String prizeNameText = prizeNameTextField.getText();
                String aMtext = aMtextField.getText();
                String aMinorText = aMinorTextField.getText();
                String newDegree = "";


                boolean isDuplciate = false;
                try { // if the uunmber exist
                    Student existingStudent = studentList.returnStudent(Integer.parseInt(studentNumber));
                    isDuplciate = true;
                } catch (Exception ex) { // is not
                    if (degreeCombox.equals("Arts")){
                        newDegree = "A";
                        inputs[4] = aMtext;
                        inputs[5] = aMinorText;
                    } else if (degreeCombox.equals("Medicine")) {
                        newDegree = "M";
                        inputs[4] = prizeNameText;
                    } else if (degreeCombox.equals("Science")) {
                        newDegree = "S";
                    }

                    inputs[0] = newDegree;
                    inputs[1] = studentNumber;
                    inputs[2] = familyName;
                    inputs[3] = givenN;
                    studentList.createStudent(inputs);

                }
                if (isDuplciate) {
                    showText.setText("Student number already exists: " + studentNumber);
                    return; // Stop further execution
                }

            }

        });


        findStudentButton.addActionListener(new ActionListener() { // for Find student
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentNum = studentNumberTextField.getText();
                //System.out.println("this is find top : " + studentNum);

                try {
                    // Retrieve the student information from the studentList
                    String[] studentInfo = studentList.returnStudentInformation(Integer.parseInt(studentNum));

                    // Update the fields with the retrieved student information
                    String studenNumb = studentInfo[0];
                    String familyName = studentInfo[1];
                    String givenName = studentInfo[2];
                    String degree = studentInfo[3];

                    System.out.println("this is in : degree : " + degree + " this is num : "+ studenNumb + " this is Fname: " + familyName + " this is Gname:  " + givenName);

                    // Map the degree value to the corresponding display value

                    if (degree.equals("art")){
                        degreeComboBox.setSelectedIndex(0);
                    }else if (degree.equals("medicine")){
                        degreeComboBox.setSelectedIndex(1);
                    }else if (degree.equals("science")){
                        degreeComboBox.setSelectedIndex(2);
                    }else {
                        degreeComboBox.setSelectedIndex(0);
                    }


                    // Set the values to the appropriate fields
                    studentNumberTextField.setText(studenNumb);
                    FamilyNameTextField.setText(familyName);
                    gNametextField.setText(givenName);

                    // Show a success message
                    showText.setText("Student details found for ID: " + studentNum);

                } catch (Exception ex) {
                    // The student number does not exist in the list
                    FamilyNameTextField.setText("");
                    gNametextField.setText("");

                    // Show an error message
                    showText.setText("Student not found for ID: " + studentNum);
                }

            }
        });


        addTopicResultButton.addActionListener(new ActionListener() { //for add topic Result
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        findTopicResultButton.addActionListener(new ActionListener() { // find topic Result
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        printAllRecordsButton.addActionListener(new ActionListener() { // print all records
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        clearAllRecordsButton.addActionListener(new ActionListener() { //Clear all Records
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        awardPrizeButton.addActionListener(new ActionListener() { // award Prize
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
//        ActionListener listener = new ActionListener() { // for the all button
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String studentNumber = studentNumberTextField.getText();
//                String familyName = FamilyNameTextField.getText();
//                String givenN = gNametextField.getText();
//                String degree = String.valueOf(degreeComboBox.getSelectedItem());
//                String aMtext = aMtextField.getText();
//                String aMinor = aMinorTextField.getText();
//                String mP = mPTextField.getText();
//                String tCode = tCodeTextField.getText();
//                String mark = markTextField.getText();
//                String grade = String.valueOf(gComboBox.getSelectedItem());
//                String prizeName = prizeNameTextField.getText();
//                String template = templateTextField.getText();
//                String nOT = nOTTextField.getText();
//
//
//                showText.setText(studentNumber + "  " + familyName + "  " + givenN + " " + degree + aMtext + aMinor + mP + tCode + mark + grade + prizeName + template + nOT);
//            }
//        };
//        addStudentButton.addActionListener(listener);
//        findStudentButton.addActionListener(listener);
//        addTopicResultButton.addActionListener(listener);
//        findTopicResultButton.addActionListener(listener);
//        printAllRecordsButton.addActionListener(listener);
//        clearAllRecordsButton.addActionListener(listener);
//        awardPrizeButton.addActionListener(listener);
    }

    public void StudentFactory(){

    }

    public static void main(String[] args) {

        StudentDatabaseGUI myFr = new StudentDatabaseGUI();
    }

}
