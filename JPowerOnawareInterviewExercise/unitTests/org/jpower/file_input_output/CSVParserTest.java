package org.jpower.file_input_output;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Author James Power
 * Date 14/2/19
 * Class CSVParserTest
 */

class CSVParserTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	/*
	 * Tests using a test file ("utils/students.csv") that parsing done correctly
	 * by checking the size of the returned ArrayList
	 */
	@Test
	void testCSVParsing() throws IOException {
		CSVParser cp = new CSVParser();
		String filename = "utils/students.csv";
		ArrayList<Student> students = new ArrayList<Student>();
		students = cp.csvParser(filename);
		assertEquals(students.size(),4 );	
	}

}
