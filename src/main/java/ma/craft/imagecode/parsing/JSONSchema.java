package ma.craft.imagecode.parsing;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONSchema {
	public final String schemaUri="/window_schema.json";
	public final String dataUri="/window_data.json";
	public final String invalidFileUri="/invalid_window_data.json";



	public static void main(String[] args) {
		
		
	}
	public JSONObject readSchemaFile() {
		JSONObject jsonSchema = new JSONObject(new JSONTokener(JSONSchema.class.getResourceAsStream(schemaUri)));
		return jsonSchema;
		
	}
	public JSONObject readDataFile() {
		JSONObject jsonObject = new JSONObject(new JSONTokener(JSONSchema.class.getResourceAsStream(dataUri)));
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
