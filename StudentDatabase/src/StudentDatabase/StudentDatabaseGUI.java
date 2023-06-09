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

                    //System.out.println("this is in : degree : " + degree + " this is num : "+ studenNumb + " this is Fname: " + familyName + " this is Gname:  " + givenName);

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

                String[] inputs = new String[5];
                String studentNum = studentNumberTextField.getText();
                String topicCode = tCodeTextField.getText();
                String marks = markTextField.getText();
                String grade = String.valueOf(gComboBox.getSelectedItem());

                System.out.println("this is top: this is student{}" + studentNum + " {topiccode} :" + topicCode + " {mark : } " + marks + " {Grade : }" +  grade);

                // Check if all mandatory fields are present
                if (studentNum.isEmpty() || topicCode.isEmpty() || marks.isEmpty()) {
                    // Display an error message if any mandatory field is missing
                    showText.setText("Please provide Student ID, Topic Code, and Marks.");
                    return;
                }

                try {
                    // Prepare the inputs array to add topic to the student
                    if (!marks.isEmpty()) {
                        //inputs = new String[]{studentNum, topicCode, topicCode, grade, marks};
                        inputs[0] = "R";
                        inputs[1] = studentNum;
                        inputs[2] = topicCode;
                        inputs[3] = grade;
                        inputs[4] = marks;

                        //System.out.println("this is input : [0] :" + inputs[0] + " [1] :" + inputs[1]);
                    } else {
                        inputs[0] = "R";
                        inputs[1] = studentNum;
                        inputs[2] = topicCode;
                        inputs[3] = grade;
                    }

                    // Add the topic to the student
                    studentList.addTopicToStudent(inputs);

                    // Show a success message
                    showText.setText("Topic result added for Student ID: " + studentNum);
                } catch (Exception ex) {
                    // The student number does not exist in the list or an error occurred
                    showText.setText("Failed to add topic result. Please check the Student ID.");
                }

            }
        });


        findTopicResultButton.addActionListener(new ActionListener() { // find topic Result
            @Override
            public void actionPerformed(ActionEvent e) {
                 String studentNum = studentNumberTextField.getText();
                 String topicCode = tCodeTextField.getText();

                 try{
                     String[] topicResult = studentList.returnStudentTopicInformation(Integer.parseInt(studentNum), topicCode);

                     if (topicResult != null){
                         // Topic result found, update the fields
                         String topicName   = topicResult[0];
                         String grade       = topicResult[1];
                         String mark        = topicResult[2];
                         System.out.println("[0] : " +topicResult[0] + "[1] : " + topicResult[1] + " [2] : " + topicResult[2]);

                         tCodeTextField.setText(topicName);
                         markTextField.setText(mark);

                         if(grade.equals("HD")){
                             gComboBox.setSelectedIndex(0);
                         } else if (grade.equals("DN")) {
                             gComboBox.setSelectedIndex(1);
                         } else if (grade.equals("CR")) {
                             gComboBox.setSelectedIndex(2);
                         } else if (grade.equals("PS")) {
                             gComboBox.setSelectedIndex(3);
                         } else if (grade.equals("FL")) {
                             gComboBox.setSelectedIndex(4);
                         }

                         // Show a success message
                         showText.setText("Topic result found for Student ID: " + studentNum + " and Topic Code: " + topicCode);

                     }else{
                         // No matching topic result found, clear the fields
                         markTextField.setText("");
                         gComboBox.setSelectedIndex(0); // Assuming the index 0 represents an empty selection
                         prizeNameTextField.setText("");

                         // Show a message indicating no matching result
                         showText.setText("No matching topic result found for Student ID: " + studentNum + " and Topic Code: " + topicCode);
                     }
                 }catch (Exception ex){
                     // An error occurred while finding the topic result
                     showText.setText("Failed to find topic result. Please check the Student ID and Topic Code.");
                 }

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
                String prizeName = prizeNameTextField.getText();
                String template = templateTextField.getText();
                String numOfTopic = nOTTextField.getText();


            }
        });

    }


    public static void main(String[] args) {

        StudentDatabaseGUI myFr = new StudentDatabaseGUI();
    }

}
