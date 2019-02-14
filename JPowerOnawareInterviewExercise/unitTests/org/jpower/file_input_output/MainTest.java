package org.jpower.file_input_output;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Author James Power
 * Date 14/2/19
 * Class MainTest
 */


class MainTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	
	 //Tests using a test file ("utils/students.csv") for unsupported file types
	 
	@Test
	void invalidFilenameTest() throws FileNotFoundException, IOException {
		String filename = "utils/students.csd";
		ArrayList<Student> students = Main.readFile(filename);
		Assert.assertNull(students);
	}
	
	//Tests using a test file ("") for empty file name
	@Test
	void emptyFilenameTest() throws FileNotFoundException, IOException {
		String filename = "";
		ArrayList<Student> students = Main.readFile(filename);
		Assert.assertNull(students);
	}
	
	
	//Tests grade sorting done correctly by suppling test ArrayList and manually checking
	//student locations after sorting
	@Test
	void testSortingByGrade() {
		ArrayList<Student> students = new ArrayList<Student>();
		Student tom = new Student("Tom", 90.2);
		students.add(tom);
		Student alice = new Student("Alice", 50.3);
		students.add(alice);
		Student mary = new Student("Mary", 20.3);
		students.add(mary);
		
		Collections.sort(students, Student.StuGradeComparator);
		
		assertEquals(students.get(1).getGrade(), 50.3);
	}
	

	//Tests name sorting done correctly by suppling test ArrayList and manually checking
	//student locations after sorting
	@Test
	void testSortingByName() {
		ArrayList<Student> students = new ArrayList<Student>();
		Student tom = new Student("Tom", 90.2);
		students.add(tom);
		Student alice = new Student("Alice", 50.3);
		students.add(alice);
		Student mary = new Student("Mary", 20.3);
		students.add(mary);
		
		Collections.sort(students, Student.StuNameComparator);
		
		assertEquals(students.get(2).getName(), "Tom");
	}
}
