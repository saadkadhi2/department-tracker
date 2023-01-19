//Assignment: ASU CSE205 Spring 2021 #8
//Name: Saad Kadhi
//StudentID: 1218676056
//Lecture: TTH 9:00-10:15am
//Description: Faculty class contains firstname, lastname, and academic level.


import java.io.Serializable;

public class Faculty implements Serializable
{
    //private instance variables
    private String firstName, lastName, academicLevel;

    //constructor
    public Faculty(String firstName, String lastName, String academicLevel)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.academicLevel = academicLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    //sets firstName to the specified string
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //sets lastName to the specified string
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //sets academicLevel to the specified string
    public void setAcademicLevel(String level) {
        academicLevel = level;
    }

    //return a string in the specified format
    public String toString() {
        return firstName + " " + lastName + ", " + academicLevel;
    }
}
