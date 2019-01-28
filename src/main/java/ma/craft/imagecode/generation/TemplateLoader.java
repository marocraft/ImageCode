package ma.craft.imagecode.generation;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ma.craft.imagecode.domain.Child;
import ma.craft.imagecode.domain.Container;
import ma.craft.imagecode.domain.Template;

public class TemplateLoader {

	public String loadContainer(Container container, String path) {

		ClassLoader classLoader = TemplateLoader.class.getClassLoader();

		classLoader.getResource(path).getFile().replaceAll("#width", container.getWidth().toString())
				.replaceAll("#height", container.getHeight().toString()).replaceAll("#name", container.getName())
				.replaceAll("#x", container.getX().toString()).replaceAll("#y", container.getY().toString());
		return classLoader.toString();
	}

	public String loadChilTemplate(Child child, String path) {
		ClassLoader classLoader = TemplateLoader.class.getClassLoader();
		classLoader.getResource(path).getFile().replaceAll("#width", child.getWidth().toString())
				.replaceAll("#height", child.getHeight().toString()).replaceAll("#name", child.getName())
				.replaceAll("#x", child.getX().toString()).replaceAll("#y", child.getY().toString());
		return classLoader.toString();
	}

	public File readFile(String url) {
		ClassLoader classLoader = TemplateLoader.class.getClassLoader();
		return new File(classLoader.getResource(url).getFile());

	}

	public Template parse(File file) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(file, Template.class);
	}
}
