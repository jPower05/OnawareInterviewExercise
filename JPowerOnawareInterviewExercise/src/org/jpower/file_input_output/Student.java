package org.jpower.file_input_output;
import java.util.Comparator;

/*
 * Author James Power
 * Date: 14/2/19
 * Class Student:
 * 
 * Objective: Student class which are populated by the incoming data
 * 
 * Comparators used in order to sort by name and grade through
 * Collections.sort
 * 
 */

public class Student {
	private double grade;
	private String name;
	
	public Student() {
		
	}
	
	public Student(String name, double grade) {
		this.grade = grade;
		this.name = name;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", name=" + name + "]";
	}
	
	public static Comparator<Student> StuNameComparator = new Comparator<Student>() {

		public int compare(Student s1, Student s2) {
		   String StudentName1 = s1.name;
		   String StudentName2 = s2.name;

		   //ascending order
		   return StudentName1.compareTo(StudentName2);

	    }};
	  
	public static Comparator<Student> StuGradeComparator = new Comparator<Student>() {

		public int compare(Student s1, Student s2) {

			return Double.compare(s1.grade, s2.grade);
	   }};
	
	
	
}



