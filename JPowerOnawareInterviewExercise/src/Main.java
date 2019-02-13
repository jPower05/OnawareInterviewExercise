import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


//main class 
public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// take in a file
		ArrayList<Student> students = readFile("utils/students.csv");

		// sort ArrayList by name (using StudentName Comparator)
		Collections.sort(students, Student.StuNameComparator);
		WriteToCSV csvWriter = new WriteToCSV();
		csvWriter.writeToCSV(students, "utils/students_name.csv");
		
		
		// sort ArrayList by grade (using StudentGrade Comparator)
		Collections.sort(students, Student.StuGradeComparator);
		WriteToJson jsonWriter = new WriteToJson();
		jsonWriter.writeToJson(students, "utils/students_grade.json");
		
	}

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
