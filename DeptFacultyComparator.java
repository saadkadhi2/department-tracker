//Assignment: ASU CSE205 Spring 2021 #8
//Name: Saad Kadhi
//StudentID: 1218676056
//Lecture: TTH 9:00-10:15am
//Description: We use the method in this class for comparison when sorting last and first names for departments.

import java.util.Comparator;

public class DeptFacultyComparator implements Comparator<Department>
{
    //First we compare the currentFaculty's last name, if they are same, we then compare
    //their first names. The departments should be listed in the alphabetical order of the
    //currentFaculty's last and first names
    public int compare(Department first, Department second)
    {
        int comparison;
        comparison = first.getFaculty().getLastName().compareTo(second.getFaculty().getLastName());
        if(comparison == 0) {
            comparison = first.getFaculty().getFirstName().compareTo(second.getFaculty().getFirstName());
            return comparison;
        } else {
            return comparison;
        }

    }
}
