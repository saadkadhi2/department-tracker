//Assignment: ASU CSE205 Spring 2021 #8
//Name: Saad Kadhi
//StudentID: 1218676056
//Lecture: TTH 9:00-10:15am
//Description: Method in this class is used for sorting department names.

import java.util.Comparator;

public class DeptNameComparator implements Comparator<Department> {
    //compare method takes two departments department names to return int for selection sort.
    public int compare(Department first, Department second) {

        int comparison;
        comparison = first.getDeptName().compareTo(second.getDeptName());
        return comparison;

    }

}
