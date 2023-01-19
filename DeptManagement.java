//Assignment: ASU CSE205 Spring 2021 #8
//Name: Saad Kadhi
//StudentID: 1218676056
//Lecture: TTH 9-10:15am
//Description: DeptManagement is what is used to manage departments in an arraylist and use its data

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
//import all other necessary classes

public class DeptManagement implements Serializable
{
    ArrayList<Department> deptList;

    public DeptManagement() {
        deptList = new ArrayList<>();
    }

    //loops through arraylist to look for existing departments
    public int deptExists(String deptName, String universityName) {
        int exists = -1;
        for(int i = 0; i < deptList.size(); i++) {
            if(deptList.get(i).getUniversity().equals(universityName) && deptList.get(i).getDeptName().equals(deptName)) {
                exists = i;
            }
        }
        return exists;
    }

    //loops through faculties t osee if they exist.
    public int facultyExists(String firstName, String lastName, String academicLevel) {
        int exists = -1;
        for(int i = 0; i < deptList.size(); i++) {
            if(deptList.get(i).getFaculty().getFirstName().equals(firstName) && deptList.get(i).getFaculty().getLastName().equals(lastName) && deptList.get(i).getFaculty().getAcademicLevel().equals(academicLevel)) {
                exists = i;
            }
        }
        return exists;
    }

    //adds department to arraylist then returns boolean.
    public boolean addDepartment(String deptName, String university, int numOfMembers, String firstName, String lastName, String academicLevel) {
        boolean add = false;
        if(deptExists(deptName, university) == -1) {
            deptList.add(new Department(deptName, university, numOfMembers, firstName, lastName, academicLevel));
            add = true;
        }
        return add;
    }

    //***will remove all departments with the same name and university
    public boolean removeDepartment(String deptName, String universityName) {
        boolean remove = false;
        int exists = deptExists(deptName, universityName);
        if(!(exists == -1)) {
            deptList.remove(exists);
            remove = true;
        }
        return remove;
    }

    public void sortByDepartmentName() {
        Comparator<Department> xComparator = new DeptNameComparator();
        Sorts sorts = new Sorts();
        sorts.sort(deptList, xComparator);
    }

    public void sortByFacultyNumbers() {
        Comparator<Department> xComparator = new FacultyNumberComparator();
        Sorts sorts = new Sorts();
        sorts.sort(deptList, xComparator);
    }

    public void sortByDeptFaculty() {
        Comparator<Department> xComparator = new DeptFacultyComparator();
        Sorts sorts = new Sorts();
        sorts.sort(deptList, xComparator);
    }

    public String listDepartments() {
        String depList = "";
        if(deptList.size() >= 1) {
            for(int i = 0; i < deptList.size(); i++) {
                depList += deptList.get(i).toString();
            }
        } else {
            depList =  "\nNo Department\n\n";
        }
        return depList ;
    }

    public void closeDeptManagement() {
        for(int i = 0; i < deptList.size(); i++) {
            deptList.remove(i);
        }
    }
}