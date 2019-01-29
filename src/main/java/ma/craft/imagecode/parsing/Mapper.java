package ma.craft.imagecode.parsing;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import ma.craft.imagecode.domain.Child;
import ma.craft.imagecode.domain.Container;

public class Mapper {

	public Container getContainer(JSONObject json) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), Container.class);
	}

	public List<Child> getAllChildreen(JSONObject json) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), Container.class).getChildren();

	}

}
