package ma.craft.imagecode.generation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Pushing1stCommentIneTextFile {

	public static void pushCodeTextFile() throws IOException {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("code-react-native.txt", true)));
			out.println("//code réact native\\n");
			out.close();
		} catch (IOException e) {
			// exception handling left as an exercise for the reader
		}
	}
}
