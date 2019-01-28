package ma.craft.imagecode.generation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CodeIndented {

	public static void readFile() {

		final String IN_FILE = "code-react-native.txt";
		final String OUT_FILE = "indented-code-react-native.txt";
		final int INDENT_SPACES = 4; // Number of spaces to indent

		StringBuilder output = new StringBuilder();
		int currentIndentLevel = 0;

		// Increase indent level on these keywords
		String[] keywordsIn = { "render()", "return", "<View", "Width" };
		// Decrease indent level on these keywords
		String[] keywordsOut = {};

		// Read the file, line by line

		try {
			BufferedReader reader = new BufferedReader(new FileReader(IN_FILE));

			String line = reader.readLine();

			while (line != null) {

				// Indent the line based on current level
				for (int i = 0; i < INDENT_SPACES * currentIndentLevel; i++) {
					output.append(" ");
				}
				output.append(line).append("\n");

				// Check if it contains a keyword
				for (int i = 0; i < keywordsIn.length; i++) {
					// Line begins with a keyword to increase the indent
					if (line.matches(keywordsIn[i] + "\\b.*")) {
						currentIndentLevel += 1; // Increase the indent level
					}
				}
				for (int i = 0; i < keywordsOut.length; i++) {
					// Line begins with a keyword to decrease the indent
					if (line.matches(keywordsOut[i] + "\\b.*")) {
						currentIndentLevel -= 1; // Decrease the indent level
					}
				}
				// Get next line
				line = reader.readLine();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try (PrintWriter out = new PrintWriter(OUT_FILE)) {
			out.println(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
