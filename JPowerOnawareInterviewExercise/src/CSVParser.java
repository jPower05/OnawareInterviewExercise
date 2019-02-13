import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser {
	public ArrayList<Student> csvParser(String filename) throws IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		// handling csv file
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			String line = br.readLine();
			while ((line = br.readLine()) != null && !line.isEmpty()) {
				String[] fields = line.split(",");
				String name = fields[0];
				String stringGrade = fields[1];
				double grade = Double.parseDouble(stringGrade);
				Student student = new Student(name, grade);
				students.add(student);
			}
			return students;

		} catch (IOException e) {
			System.out.println("error parsing");
			return null;
		}finally {
			br.close();
		}
	}
}
