package org.jpower.file_input_output;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


/*
 * Author James Power
 * Date: 14/2/19
 * Class Main:
 * Objective: Takes in a file and parses it. Supports Json and CSV file formats.
 * Parsed data stored as ArrayList of Students(custom java object)
 * 
 * Sorts students ArrayList by name and by grade
 * 
 * Outputs the sorted data to two files students_name.csv 
 * and students_grade.json
 */
public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		// take in a file
		try {
			students = readFile("utils/students.json");
		}catch (FileNotFoundException e){
			System.out.println("File supplied cannot be located");
			return;
		}

		if(!students.isEmpty()) {
			// sort ArrayList by name (using StudentName Comparator)
			Collections.sort(students, Student.StuNameComparator);
			WriteToCSV csvWriter = new WriteToCSV();
			csvWriter.writeToCSV(students, "utils/students_name.csv");
			
			
			// sort ArrayList by grade (using StudentGrade Comparator)
			Collections.sort(students, Student.StuGradeComparator);
			WriteToJson jsonWriter = new WriteToJson();
			jsonWriter.writeToJson(students, "utils/students_grade.json");
		}
		else {
			System.out.println("Can't sort empty data set");
		}
		
	}

	//Takes in a filename and verifies it's name.
	//Determines whether file is .json or .csv and runs the relevant parser
	//returns an ArrayList of Students
	public static ArrayList<Student> readFile(String filename) throws FileNotFoundException, IOException {
		if (filename == "") {
			System.out.println("Empty file name");
			return null;
		}
		if ((!filename.contains(".csv"))&&(!filename.contains(".json"))) {
			System.out.println("Unsupported file type supplied");
			return null;
		}

		if (filename.contains(".csv")) {
			CSVParser cp = new CSVParser();
			return cp.csvParser(filename);
		}
		if (filename.contains(".json")) {
			JsonParser jp = new JsonParser();
			return jp.jsonParser(filename);
		}
		else {
			return null;
		}
			
	}

}
