package ma.craft.imagecode.generation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PushingCodeTextFile {

    public void pushCodeTextFile() throws IOException {
        String str = "//code réact native\n";
        BufferedWriter writer = new BufferedWriter(new FileWriter("code-react-native.txt", true));
        writer.append(str);
        writer.close();
    }


}
