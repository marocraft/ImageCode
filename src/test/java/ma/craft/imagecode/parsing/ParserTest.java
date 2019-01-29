package ma.craft.imagecode.parsing;

import java.io.FileNotFoundException;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ma.craft.imagecode.parsing.Parser;

public class ParserTest {
	public static final String SCHEMA_URL = "C:\\Users\\ANASS\\git\\ImageCodeProject\\ImageCode\\src\\test\\resources\\schema.json";
	public static final String DATA_FILE_URL = "C:\\Users\\ANASS\\git\\ImageCodeProject\\ImageCode\\src\\test\\resources\\data.json";
	public static final String INVALID_DATA_FILE_URL = "C:\\Users\\ANASS\\git\\ImageCodeProject\\ImageCode\\src\\test\\resources\\invalid_data.json";

	public final String invalidFileUri = "/invalid_data.json";

	Parser parser;

	@Before
	public void init() {
		parser = new Parser();

	}

	@Test
	public void shouldReadDataFile() throws JSONException, FileNotFoundException {
		Assert.assertNotNull(parser.readJsonFile(DATA_FILE_URL));
	}

	@Test
	public void shouldLoadSchema() throws JSONException, FileNotFoundException {
		Assert.assertNotNull(parser.readJsonFile(SCHEMA_URL));
	}

	@Test
	public void shouldValidJsonSchemas() throws ValidationException, JSONException, FileNotFoundException {
		Schema schema = SchemaLoader.load(parser.readJsonFile(SCHEMA_URL));
		Assert.assertNotNull(schema);
		schema.validate(parser.readJsonFile(DATA_FILE_URL));
	}

	@Test(expected = ValidationException.class)
	public void shouldThrownInvalidSchema() throws ValidationException, JSONException, FileNotFoundException {
		Schema schema = SchemaLoader.load(parser.readJsonFile(SCHEMA_URL));
		Assert.assertNotNull(schema);
		schema.validate(parser.readJsonFile(INVALID_DATA_FILE_URL));
	}

}
