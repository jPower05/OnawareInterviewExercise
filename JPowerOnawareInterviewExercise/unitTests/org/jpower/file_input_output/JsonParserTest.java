package org.jpower.file_input_output;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Author James Power
 * Date 14/2/19
 * Class JsonParserTest
 */


class JsonParserTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	/*
	 * Tests using a test file ("utils/students.json") that json parsing done correctly
	 * by checking the size of the returned ArrayList
	 */
	@Test
	void testJsonParsing() throws IOException {
		JsonParser jp = new JsonParser();
		String filename = "utils/students.json";
		ArrayList<Student> students = new ArrayList<Student>();
		students = jp.jsonParser(filename);
		assertEquals(students.size(),4 );	
	}
}
