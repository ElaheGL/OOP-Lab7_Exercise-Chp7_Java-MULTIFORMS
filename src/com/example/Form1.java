package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Form1 extends JFrame implements ActionListener {
    private JLabel labelName, labelSurname, labelGender, labelNationality, labelAboutYou, labelLectures;
    private JTextField jTextFieldName, jTextFieldSurname;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JTextArea jTextAreaAboutYou;
    private JComboBox<String> nationalityComboBox;
    private JCheckBox oopCheckBox, osCheckBox, spCheckBox;
    private JButton submitButton, clearButton;

    public Form1() {
        setTitle("Form - Enter Information");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for the form components
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Name
        labelName = new JLabel("Name:");
        formPanel.add(labelName, gbc);
        gbc.gridx++;
        jTextFieldName = new JTextField(20);
        formPanel.add(jTextFieldName, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        // Surname
        labelSurname = new JLabel("Surname:");
        formPanel.add(labelSurname, gbc);
        gbc.gridx++;
        jTextFieldSurname = new JTextField(20);
        formPanel.add(jTextFieldSurname, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        // Gender
        labelGender = new JLabel("Gender:");
        formPanel.add(labelGender, gbc);
        gbc.gridx++;
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        formPanel.add(genderPanel, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        // Nationality
        labelNationality = new JLabel("Nationality:");
        formPanel.add(labelNationality, gbc);
        gbc.gridx++;
        nationalityComboBox = new JComboBox<>(new String[]{"Nigeria", "Turkey", "Cyprus", "Iran", "Japan", "Canada"});
        formPanel.add(nationalityComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        // About You
        labelAboutYou = new JLabel("About You:");
        formPanel.add(labelAboutYou, gbc);
        gbc.gridx++;
        jTextAreaAboutYou = new JTextArea(5, 20);
        JScrollPane aboutYouScrollPane = new JScrollPane(jTextAreaAboutYou);
        formPanel.add(aboutYouScrollPane, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        // Lectures
        labelLectures = new JLabel("Lectures:");
        formPanel.add(labelLectures, gbc);
        gbc.gridx++;
        oopCheckBox = new JCheckBox("Object Oriented Programming");
        osCheckBox = new JCheckBox("Operating System");
        spCheckBox = new JCheckBox("System Programming");
        JPanel lecturesPanel = new JPanel();
        lecturesPanel.setLayout(new BoxLayout(lecturesPanel, BoxLayout.Y_AXIS));
        lecturesPanel.add(oopCheckBox);
        lecturesPanel.add(osCheckBox);
        lecturesPanel.add(spCheckBox);
        formPanel.add(lecturesPanel, gbc);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        // Add panels to the main frame
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            displayFormInformation();
        } else if (e.getSource() == clearButton) {
            clearForm();
        }
    }

    private void displayFormInformation() {
        StringBuilder information = new StringBuilder();
        information.append("Name: ").append(jTextFieldName.getText()).append("\n");
        information.append("Surname: ").append(jTextFieldSurname.getText()).append("\n");
        information.append("Gender: ").append(maleRadioButton.isSelected() ? "Male" : "Female").append("\n");
        information.append("Nationality: ").append(nationalityComboBox.getSelectedItem()).append("\n");
        information.append("About You: ").append(jTextAreaAboutYou.getText()).append("\n");
        information.append("Lectures: ");
        if (oopCheckBox.isSelected()) information.append("Object Oriented Programming, ");
        if (osCheckBox.isSelected()) information.append("Operating System, ");
        if (spCheckBox.isSelected()) information.append("System Programming, ");

        // Remove the trailing comma and display the information
        JOptionPane.showMessageDialog(this, information.toString().replaceAll(", $", ""));
    }
        private boolean validateFields () {
            if ((jTextFieldName.getText().isEmpty()) || (jTextFieldSurname.getText().isEmpty())
                    || (jTextAreaAboutYou.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "please fill all fields");
                return false;
            }
            return true;
        }
        private String getSelectedLectures(){
            StringBuilder selectedLectures = new StringBuilder();
            if(oopCheckBox.isSelected()){
                selectedLectures.append("Object Oriented programming");}
            if(spCheckBox.isSelected()){
                selectedLectures.append(" System Operation");}
            if(osCheckBox.isSelected()){
                selectedLectures.append(" Operation System");}
            return selectedLectures.toString();
        }
        private String selectedGender(){
            StringBuilder selectedGender = new StringBuilder();
            if(maleRadioButton.isSelected()){
                return maleRadioButton.getText();
            }else if (femaleRadioButton .isSelected()){
                return femaleRadioButton .getText();
            }
            else
                return null;
        }
        private String getprofilevalue(){
            return jTextAreaAboutYou.getText();
        }
        private void clearForm(){
            jTextAreaAboutYou.setText("");
            jTextFieldSurname.setText("");
            jTextFieldName.setText("");
            nationalityComboBox.setSelectedIndex(0);
            osCheckBox.setSelected(false);
            oopCheckBox.setSelected(false);
            spCheckBox.setSelected(false);
        }



}


