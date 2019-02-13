import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

//main class 
public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// take in a file
		ArrayList<Student> students = readFile("utils/students.csv");
		

		for (Student i : students) {
			System.out.println(i.toString());
		}
		
		System.out.println("SORTING BY NAME");

		// sort ArrayList by name (using StudentName Comparator)
		Collections.sort(students, Student.StuNameComparator);
		
		for (Student i : students) {
			System.out.println(i.toString());
		}
		
		System.out.println("SORTING BY GRADE");

		// sort ArrayList by grade (using StudentGrade Comparator)
		Collections.sort(students, Student.StuGradeComparator);
		
		for (Student i : students) {
			System.out.println(i.toString());
		}

		// output that ArrayList to a file (csv)

		// sort the ArrayList by grade (using Student Grade Comparator

		// output that ArrayList to a file (json)
	}

	public static ArrayList readFile(String filename) throws FileNotFoundException, IOException {
		if (filename == "") {
			System.out.println("Empty file name");
			return null;
		}

		if (filename.contains(".csv")) {
			ArrayList<Student> students = new ArrayList<Student>();
			// handling csv file
			try {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line = br.readLine();
				while ((line = br.readLine()) != null && !line.isEmpty()) {
					String[] fields = line.split(",");
					String name = fields[0];
					String stringGrade = fields[1];
					double grade = Double.parseDouble(stringGrade);
					Student student = new Student(name, grade);
					students.add(student);
				}
				br.close();

			} catch (IOException e) {
				System.out.println("error parsing");
				return null;
			}

			return students;
		}
		if (filename.contains(".json")) {
			//reading in json file into string
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new FileReader(filename));
			try {
				String line = br.readLine();
				while (line != null) {
					sb.append(line);
					sb.append("\n");
					line = br.readLine();
				}
			} catch (IOException e) {
				System.out.println("error parsing");
				return null;
			} finally {
				br.close();
			}
			//parsing json string into ArrayList<Student>
			String json = sb.toString();
			System.out.println(json);
			ObjectMapper objectMapper = new ObjectMapper();
			ArrayList<Student> studentsJson;
			try {
				studentsJson = objectMapper.readValue(json, new TypeReference<ArrayList<Student>>() {
				});
				return studentsJson;
			} catch (JsonParseException e) {
				System.out.println("Json file formatted incorectly");
				return null;
			}
			
		}
		return null;
	}

}
