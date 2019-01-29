package ma.craft.imagecode.parsing;

import java.io.FileNotFoundException;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Parser {

	public JSONObject readJsonFile(String path) throws FileNotFoundException {
		ClassLoader classLoader = Parser.class.getClassLoader();
		return new JSONObject(new JSONTokener(classLoader.getResourceAsStream(path)));

	}

	public Schema loadSchema(String path) throws FileNotFoundException {
		return SchemaLoader.load(this.readJsonFile(path));

	}

	public void validateSchema(String dataFile, String schemaFile) throws FileNotFoundException {
		Schema schema = SchemaLoader.load(this.readJsonFile(schemaFile));
		schema.validate(this.readJsonFile(dataFile));
	}

}
