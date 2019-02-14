package org.jpower.file_input_output;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

/*
 * Author James Power
 * Date: 14/2/19
 * Class WriteToJson:
 * 
 * Objective: Takes in an ArrayList of Students and a filename
 * Using Object Mapper from the Json Jackson library
 * write the mapped students ArrayList to a json file formatted correctly
 * students ArrayList
 * 
 */

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
