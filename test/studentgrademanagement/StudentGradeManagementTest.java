/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package studentgrademanagement;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentGradeManagementTest {

    private String[] studentNames;
    private int[] studentGrades;

    @Before
    public void setUp() {
        // Initialize with some sample data
        studentNames = new String[] {"Alice", "Bob", "Charlie"};
        studentGrades = new int[] {85, 90, 78};
    }

    @Test
    public void testSearchStudentGrade() {
        // Test finding an existing student
        int grade = StudentGradeManagement.searchStudentGrade(studentNames, studentGrades, "Bob");
        assertEquals(90, grade);

        // Test searching for a non-existent student
        grade = StudentGradeManagement.searchStudentGrade(studentNames, studentGrades, "David");
        assertEquals(-1, grade);
    }

    @Test
    public void testSearchStudentIndex() {
        // Test finding the index of an existing student
        int index = StudentGradeManagement.searchStudentIndex(studentNames, "Charlie");
        assertEquals(2, index);

        // Test searching for a non-existent student
        index = StudentGradeManagement.searchStudentIndex(studentNames, "David");
        assertEquals(-1, index);
    }

    @Test
    public void testIncreaseGrades() {
        // Increase all grades by 10%
        int[] updatedGrades = StudentGradeManagement.increaseGrades(studentGrades, 10.0);

        // Verify that the grades have increased correctly
        assertEquals(93, updatedGrades[0]);  // 85 + 10% = 93
        assertEquals(99, updatedGrades[1]);  // 90 + 10% = 99
        assertEquals(85, updatedGrades[2]);  // 78 + 10% = 85
    }

    @Test
    public void testDeleteStudent() {
        // Delete an existing student
        boolean deleted = StudentGradeManagement.deleteStudent(studentNames, studentGrades, "Bob");
        assertTrue(deleted);
        assertEquals("Charlie", studentNames[1]);  // "Bob" should be removed, "Charlie" shifts up
        assertEquals(78, studentGrades[1]);        // "Bob's" grade is removed

        // Attempt to delete a non-existent student
        deleted = StudentGradeManagement.deleteStudent(studentNames, studentGrades, "David");
        assertFalse(deleted);
    }
}
