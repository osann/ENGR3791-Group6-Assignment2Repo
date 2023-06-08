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
                //ArrayList<String> studNumber = new ArrayList<>();

                String[] inputs = new String[6];

                String studentNumber = studentNumberTextField.getText();
                String familyName = FamilyNameTextField.getText();
                String givenN = gNametextField.getText();
                String degreeCombox = String.valueOf(degreeComboBox.getSelectedItem());
                String prizeNameText = prizeNameTextField.getText();
                String aMtext = aMtextField.getText();
                String aMinorText = aMinorTextField.getText();
                String newDegree = "";

                inputs[0] = newDegree;
                inputs[1] = studentNumber;
                inputs[2] = familyName;
                inputs[3] = givenN;

                if (degreeCombox.equals("Arts")){

                    newDegree = "A";
                    
                    inputs[4] = aMtext;
                    inputs[5] = aMinorText;
                    studentList.createStudent(inputs);



                } else if (degreeCombox.equals("Medicine")) {
                    newDegree = "M";
                    inputs[4] = prizeNameText;
                    studentList.createStudent(inputs);

                } else if (degreeCombox.equals("Science")) {
                    newDegree = "S";
                    studentList.createStudent(inputs);
                }
                System.out.println(inputs +"  "+ newDegree);


                showText.setText(newDegree);

            }
        });


        findStudentButton.addActionListener(new ActionListener() { // for Find student
            @Override
            public void actionPerformed(ActionEvent e) {

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
