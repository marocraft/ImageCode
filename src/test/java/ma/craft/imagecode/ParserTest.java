package ma.craft.imagecode;


import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;
import org.junit.Test;

import ma.craft.imagecode.parsing.Parser;

public class ParserTest {
	public final String schemaUri="/schema.json";
	public final String invalidFileUri="/invalid_data.json";
	@Test
	public void shouldReadSchemaFile()  {
		Parser jsonSchema= new Parser();
		Assert.assertNotNull(jsonSchema.readSchemaFile());
	}
	
	@Test
	public void shouldReadDataFile()  {
		Parser jsonSchema= new Parser();
		Assert.assertNotNull(jsonSchema.readDataFile());
	}
	
	@Test
	public void shouldLoadSchema()  {
		Parser jsonSchema= new Parser();
		Assert.assertNotNull(jsonSchema.loadSchema());
	}
	@Test
	public void shouldValidJsonSchemas() throws ValidationException {
		Parser jsonSchema= new Parser();
		Schema schema = SchemaLoader.load(jsonSchema.readSchemaFile());
		Assert.assertNotNull(schema);
		schema.validate(jsonSchema.readDataFile());
	}

	@Test(/*expected = ValidationException.class*/)
	public void shouldThrownInvalidSchema() throws ValidationException {
		JSONObject jsonSchema = new JSONObject(new JSONTokener(ParserTest.class.getResourceAsStream(schemaUri)));
		JSONObject jsonSubject = new JSONObject(new JSONTokener(ParserTest.class.getResourceAsStream(invalidFileUri)));
		Schema schema = SchemaLoader.load(jsonSchema);
		Assert.assertNotNull(schema);
		Assert.assertNotNull(jsonSchema);

		schema.validate(jsonSubject);
	}
	
}
