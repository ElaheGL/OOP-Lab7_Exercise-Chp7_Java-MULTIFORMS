package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form2 extends JFrame implements ActionListener {
    private JLabel Name,nameValue,Surname,surnameValue,Gender,genderValue,Nationality,nationalityValue,Profile,
            profileValue ,lectureValue,Lecture;
    private JButton returnBack;
    public Form2(){
        setTitle("Form2");
        setSize(300,300);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Name = new JLabel("Name :");
        nameValue = new JLabel();
        Surname = new JLabel("Surname :");
        surnameValue = new JLabel();
        Gender = new JLabel("Gender :");
        genderValue = new JLabel();
        Nationality = new JLabel(" Your Nationality :");
        nationalityValue = new JLabel();
        Profile= new JLabel("Profile :");
        profileValue = new JLabel();
        Lecture = new JLabel("Lectures :");
        lectureValue = new JLabel();

        add(Name);
        add(nameValue);
        add(Surname);
        add(surnameValue);
        add(Gender);
        add(genderValue);
        add(Profile);
        add(profileValue);
        add(Lecture);
        add(lectureValue);
        add(Nationality);
        add(nationalityValue);


    }

    public void setName(String name){
        this.nameValue.setText(name);
    }
     public void setSurname(String surname){
        this.surnameValue.setText(surname);
    }
    public void setNationality(String nationality){
        this.nationalityValue.setText(nationality);
    }
    public void setLecture(String lecture){
        this.lectureValue.setText(lecture);
    }
    public void setGender(String gender){
        this.genderValue.setText(gender);
    }
    public void setProfile(String profile){
        this.profileValue.setText(profile);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
