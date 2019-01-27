package ma.craft.imagecode;

import java.io.FileNotFoundException;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import ma.craft.imagecode.parsing.Parser;

public class ParserTest {
	public static final String SCHEMA_URL = "C:\\Users\\ANASS\\git\\ImageCodeProject\\ImageCode\\src\\test\\resources\\schema.json";
	public static final String DATA_FILE_URL = "C:\\Users\\ANASS\\git\\ImageCodeProject\\ImageCode\\src\\test\\resources\\data.json";
	public static final String INVALID_DATA_FILE_URL = "C:\\Users\\ANASS\\git\\ImageCodeProject\\ImageCode\\src\\test\\resources\\invalid_data.json";

	public final String invalidFileUri = "/invalid_data.json";

	@Test
	public void shouldReadDataFile() throws JSONException, FileNotFoundException {
		Parser jsonData = new Parser();
		Assert.assertNotNull(jsonData.readJsonFile(DATA_FILE_URL));
	}

	@Test
	public void shouldLoadSchema() throws JSONException, FileNotFoundException {
		Parser jsonSchema = new Parser();
		Assert.assertNotNull(jsonSchema.readJsonFile(SCHEMA_URL));
	}

	@Test
	public void shouldValidJsonSchemas() throws ValidationException, JSONException, FileNotFoundException {
		Parser jsonSchema = new Parser();
		Schema schema = SchemaLoader.load(jsonSchema.readJsonFile(SCHEMA_URL));
		Assert.assertNotNull(schema);
		schema.validate(jsonSchema.readJsonFile(DATA_FILE_URL));
	}

	@Test(expected = ValidationException.class)
	public void shouldThrownInvalidSchema() throws ValidationException, JSONException, FileNotFoundException {
		Parser jsonSchema = new Parser();
		Schema schema = SchemaLoader.load(jsonSchema.readJsonFile(SCHEMA_URL));
		Assert.assertNotNull(schema);
		schema.validate(jsonSchema.readJsonFile(INVALID_DATA_FILE_URL));
	}

}
