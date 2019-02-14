package org.jpower.file_input_output;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Author James Power
 * Date: 14/2/19
 * Class WriteToCSV:
 * 
 * Objective: Takes in an ArrayList of Students and a filename
 * Using fileWriter and hardcoded CSV format to create a CSV file from the 
 * students ArrayList
 * 
 */

public class WriteToCSV {
	public void writeToCSV(ArrayList<Student> students, String newFilename) {
		if (students.isEmpty()) {
			return;
		}
		FileWriter writer;
		try {
			writer = new FileWriter(newFilename);
			for (Student i : students) {
				writer.append(Double.toString(i.getGrade()));
				writer.append(',');
				writer.append(i.getName());
				writer.append('\n');
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing csv file");
		}

	}
}
