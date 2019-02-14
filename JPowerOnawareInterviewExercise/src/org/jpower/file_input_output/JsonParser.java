package org.jpower.file_input_output;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/*
 * Author James Power
 * Date: 14/2/19
 * Class JsonParser:
 * 
 * Objective: Reads in Json file using bufferedReader and stores as a string.
 * Parses string using the Json Jackson library
 * Parsed data stored as ArrayList of Students(custom java object)
 * returns ArrayList of Students
 * 
 */

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
		// parsing json string into ArrayList<Student> with Jackson Object mapper
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
