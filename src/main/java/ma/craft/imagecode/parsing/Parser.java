package ma.craft.imagecode.parsing;

import java.io.File;
import java.io.IOException;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.craft.imagecode.domain.Container;

public class Parser {
	public final String schemaUri="/schema.json";
	public final static String dataUri="/data.json";
	public final String invalidFileUri="/invalid_window_data.json";



	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Container container = mapper.readValue(new JSONObject(new JSONTokener(Parser.class.getResourceAsStream(dataUri))).toString(), Container.class);
		System.out.println(container.toString());
		
	}
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
	public boolean validateSchema() {
		
		return false;
		
		
	}

}
