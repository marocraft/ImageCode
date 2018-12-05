package ma.craft.imagecode.parsing;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Value;

public class Parser {
	@Value("${file.data.url}")
	String dataUri;
	@Value("${file.schema.url}")
	String schemaUri;
	@Value("${file.invalid.url}")
	String invalidFileUri;


	public JSONObject readSchemaFile() {
		JSONObject jsonSchema = new JSONObject(new JSONTokener(Parser.class.getResourceAsStream(schemaUri)));
		return jsonSchema;

	}

	public JSONObject readDataFile() {
		JSONObject jsonObject = new JSONObject(new JSONTokener(Parser.class.getResourceAsStream(dataUri)));
		return jsonObject;

	}

	public Schema loadSchema() {
		Schema schema = SchemaLoader.load(this.readSchemaFile());
		return schema;

	}

}
