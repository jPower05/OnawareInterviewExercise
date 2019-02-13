import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonParser {
	public ArrayList<Student> jsonParser(String filename) throws IOException {
		// reading in json file into string
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
		// parsing json string into ArrayList<Student>
		String json = sb.toString();
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Student> studentsJson;
		try {
			studentsJson = objectMapper.readValue(json, new TypeReference<ArrayList<Student>>() {
			});
			return studentsJson;
		} catch (IOException e) {
			System.out.println("Json file formatted incorectly");
			return null;
		}
	}
}
