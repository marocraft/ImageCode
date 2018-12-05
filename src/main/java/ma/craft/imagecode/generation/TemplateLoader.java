package ma.craft.imagecode.generation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.craft.imagecode.domain.Child;
import ma.craft.imagecode.domain.Container;
import ma.craft.imagecode.domain.Template;

public class TemplateLoader {
/*
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\Users\\ANASS\\git\\ImageCodeProject\\ImageCode\\src\\main\\resources\\templates\\view.template";
		String content = new String(Files.readAllBytes(Paths.get("C:\\\\Users\\\\ANASS\\\\git\\\\ImageCodeProject\\\\ImageCode\\\\src\\\\main\\\\resources\\\\templates\\\\view.template")));
		
		System.out.println(readTemplateFile(filePath).toString());
		System.out.println(content.replaceAll("#width", "test").replaceAll("#name", "test").replaceAll("#height","test"));
	}

	 Read file content into string with - Files.lines(Path path, Charset cs)

	private static String readTemplateFile(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString().replaceAll("#width", "test").replaceAll("#name", "test").replaceAll("#height","test");*/
//	}

	public void loadContainer(Container container) {

		ClassLoader classLoader = TemplateLoader.class.getClassLoader();
		classLoader.getResource("templates/view.template").getFile()
				.replaceAll("#width", container.getWidth().toString())
				.replaceAll("#height", container.getHeight().toString())
				.replaceAll("#name", container.getName().toString())
				.replaceAll("#x", container.getX().toString())
				.replaceAll("#y", container.getY().toString());
	}

	public void loadChildren(Container container) {
		List<Child> children = container.getChildren();
		for (Child child : children) {
			child.getConfidence();
			
			}
	}
	public  File readFile(String url) {
        ClassLoader classLoader = TemplateLoader.class.getClassLoader();
        File file = new File(classLoader.getResource(url).getFile());
        return file;
        
    }

    public  Template parse(File file) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        return mapper.readValue(file, Template.class);
    }
}
