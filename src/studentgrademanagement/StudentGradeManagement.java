/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentgrademanagement;

/**
 *
 * @author Samkeliso
 */
import javax.swing.*;

public class StudentGradeManagement {

    // Method to search for a student's grade by name
    public static int searchStudentGrade(String[] names, int[] grades, String searchName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(searchName)) {
                return grades[i];
            }
            
        }
        return -1;  // If student is not found
    }

    // Method to search for an exact student name and return their index
    public static int searchStudentIndex(String[] names, String searchName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(searchName)) {
                return i;
            }
        }
        return -1;  // If student is not found
    }

    // Method to increase all students' grades by a certain percentage
    public static int[] increaseGrades(int[] grades, double percentage) {
        int[] updatedGrades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            updatedGrades[i] = (int) (grades[i] + grades[i] * (percentage / 100));
        }
        return updatedGrades;
    }

    // Method to delete a student by name
    public static boolean deleteStudent(String[] names, int[] grades, String deleteName) {
        int index = searchStudentIndex(names, deleteName);
        if (index != -1) {
            // Shift elements to "remove" the student
            for (int i = index; i < names.length - 1; i++) {
                names[i] = names[i + 1];
                grades[i] = grades[i + 1];
            }
            names[names.length - 1] = null;  // Nullify last entry
            grades[grades.length - 1] = 0;
            return true;  // Deletion successful
        }
        return false;  // Student not found
    }

    public static void main(String[] args) {
        // Ask user for the number of students
        String numStudentsStr = JOptionPane.showInputDialog("Enter the number of students:");
        int numStudents = Integer.parseInt(numStudentsStr);

        // Declare arrays to hold student names and grades
        String[] studentNames = new String[numStudents];
        int[] studentGrades = new int[numStudents];

        // Get user input for student names and grades
        for (int i = 0; i < numStudents; i++) {
            studentNames[i] = JOptionPane.showInputDialog("Enter name of student " + (i + 1) + ":");
            studentGrades[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter grade of " + studentNames[i] + ":"));
        }

        // Search for a student's grade by name
        String searchName = JOptionPane.showInputDialog("Enter a student's name to search for their grade:");
        int grade = searchStudentGrade(studentNames, studentGrades, searchName);

        if (grade != -1) {
            JOptionPane.showMessageDialog(null, searchName + "'s grade is: " + grade);
        } else {
            JOptionPane.showMessageDialog(null, "Student not found.");
        }

        // Increase all grades by a percentage
        double percentage = Double.parseDouble(JOptionPane.showInputDialog("Enter the percentage increase for grades:"));
        int[] updatedGrades = increaseGrades(studentGrades, percentage);

        // Display updated grades
        StringBuilder gradeMessage = new StringBuilder("Updated Grades:\n");
        for (int i = 0; i < studentNames.length; i++) {
            if (studentNames[i] != null) {
                gradeMessage.append(studentNames[i]).append(": ").append(updatedGrades[i]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, gradeMessage.toString());

        // Option to delete a student
        String deleteName = JOptionPane.showInputDialog("Enter a student's name to delete:");
        boolean deleted = deleteStudent(studentNames, studentGrades, deleteName);

        if (deleted) {
            JOptionPane.showMessageDialog(null, deleteName + " has been deleted.");
        } else {
            JOptionPane.showMessageDialog(null, "Student not found.");
        }
    }
}
