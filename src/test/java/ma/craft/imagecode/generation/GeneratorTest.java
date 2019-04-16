package ma.craft.imagecode.generation;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GeneratorTest {

    public static final String SCHEMA_URL = "schema.json";
    public static final String DATA_FILE_URL = "data.json";

    @Test
    public  void shouldGenerateCodeFromJsonFiles() throws IOException {

        //Given
        Generator generator = new Generator();

        //When
        String result = generator.generate(DATA_FILE_URL,SCHEMA_URL);

        //Then
        assertNotNull(result);
    }

}