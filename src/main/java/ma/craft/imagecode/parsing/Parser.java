package ma.craft.imagecode.parsing;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Parser {

	public JSONObject readJsonFile(String path) {
		ClassLoader classLoader = Parser.class.getClassLoader();
		return new JSONObject(new JSONTokener(classLoader.getResourceAsStream(path)));

	}

	public Schema loadSchema(String path) {
		return SchemaLoader.load(this.readJsonFile(path));

	}

	public void validateSchema(String dataFile, String schemaFile) {
		Schema schema = SchemaLoader.load(this.readJsonFile(schemaFile));
		schema.validate(this.readJsonFile(dataFile));
	}

}
