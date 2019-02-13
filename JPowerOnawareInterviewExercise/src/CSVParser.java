import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser {
	public ArrayList parser(String filename, ArrayList students) {
		System.out.println("hello");
		try {
			System.out.println("trying");
			BufferedReader br = new BufferedReader(new FileReader("students.csv"));
			System.out.println("reader");
			String line = br.readLine(); 
			while ((line = br.readLine()) != null && !line.isEmpty()) {
				System.out.println("good to go");
				String[] fields = line.split(",");
				System.out.println("split delims");
				String name = fields[0];
				System.out.println("parse name");
				String stringGrade = fields[1];
				System.out.println("parse Grade");
				double grade = Double.parseDouble(stringGrade);
				//Student student = new Student(grade, name);
				//students.add(student);
			}
			

		} catch ( IOException e) {
			System.out.println("error parsing");
			return null;
		}
		return students;
		
	}
}
