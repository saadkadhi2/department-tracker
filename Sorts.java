//Assignment: ASU CSE205 Spring 2021 #8
//Name: Saad Kadhi
//StudentID: 1218676056
//Lecture: TTH 9:00-10:15am
//Description: Sorts class used to sort the list for Department object variables using a simple selection sort.

import java.util.Comparator;
import java.util.ArrayList;

public class Sorts
{
    public static void sort(ArrayList<Department> deptList, Comparator<Department> xComparator) {

        for ( int j=0; j < deptList.size()-1; j++ )
        {
            //using compare method and selection sort to go through arraylist to change order.
            int min = j;
            for ( int k=j+1; k < deptList.size(); k++ )
                if (xComparator.compare(deptList.get(k),deptList.get(min)) < 0 )
                    min = k;

            Department temp = deptList.get(j);
            deptList.set(j, deptList.get(min));
            deptList.set(min, temp);
        }




    } //end sort


} //end class Sorts
