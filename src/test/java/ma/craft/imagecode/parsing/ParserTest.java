package ma.craft.imagecode.parsing;

import java.io.FileNotFoundException;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {
	public static final String SCHEMA_URL = "schema.json";
	public static final String DATA_FILE_URL = "data.json";
	public static final String INVALID_DATA_FILE_URL = "invalid_data.json";

	Parser parser;

	@Before
	public void init() {
		parser = new Parser();

	}

	@Test
	public void shouldReadDataFile() throws FileNotFoundException {
		Assert.assertNotNull(parser.readJsonFile(DATA_FILE_URL));
	}

	@Test
	public void shouldLoadSchema() throws JSONException, FileNotFoundException {
		Assert.assertNotNull(parser.readJsonFile(SCHEMA_URL));
	}

	@Test
	public void shouldValidJsonSchemas() throws FileNotFoundException {
		Schema schema = SchemaLoader.load(parser.readJsonFile(SCHEMA_URL));
		Assert.assertNotNull(schema);
		schema.validate(parser.readJsonFile(DATA_FILE_URL));
	}

	@Test(expected = ValidationException.class)
	public void shouldThrownInvalidSchema() throws FileNotFoundException {
		Schema schema = SchemaLoader.load(parser.readJsonFile(SCHEMA_URL));
		Assert.assertNotNull(schema);
		schema.validate(parser.readJsonFile(INVALID_DATA_FILE_URL));
	}

}
