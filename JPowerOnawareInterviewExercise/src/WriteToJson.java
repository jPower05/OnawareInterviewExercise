import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

public class WriteToJson {
	public void writeToJson(ArrayList<Student> students, String newFilename) {
		if (students.isEmpty()) {
			return;
		}
		// converting ArrayList<Student> into JSON file
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(newFilename), students);
		} catch (IOException e) {
			System.out.println("Error writing to json file");
		}
	}
}
