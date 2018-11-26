package ma.craft.imagecode.parsing;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.craft.imagecode.domain.Child;
import ma.craft.imagecode.domain.Container;

public class Mapper {
	public static void main(String[] args) {
		
		/*JSONSchema js= new JSONSchema()	;
		Service ser = new Service();
		Container cnt = ser.getContainer(js.readDataFile());
		for (Child child : cnt.getChildren()) {
			System.out.println(child.toString());
			
		}
		*/
	}

	public Container getContainer(JSONObject json) {
		ObjectMapper mapper = new ObjectMapper();
		Container container = null;
		try {
			container = mapper.readValue(json.toString(), Container.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return container;
	}

	public List<Child> getAllChildreen(JSONObject json) {
		ObjectMapper mapper = new ObjectMapper();
		Container container = null;
		try {
			container = mapper.readValue(json.toString(), Container.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return container.getChildren();
	}

}
