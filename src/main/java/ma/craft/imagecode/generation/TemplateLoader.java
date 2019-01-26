package ma.craft.imagecode.generation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import ma.craft.imagecode.domain.Child;
import ma.craft.imagecode.domain.Container;
import ma.craft.imagecode.domain.Template;

public class TemplateLoader {

	public void loadContainer(Container container) {

		ClassLoader classLoader = TemplateLoader.class.getClassLoader();
		classLoader.getResource("templates/view.template").getFile()
				.replaceAll("#width", container.getWidth().toString())
				.replaceAll("#height", container.getHeight().toString())
				.replaceAll("#name", container.getName())
				.replaceAll("#x", container.getX().toString())
				.replaceAll("#y", container.getY().toString());
	}

	public void loadChildren(Container container) {
		List<Child> children = container.getChildren();
		for (Child child : children) {
			child.getConfidence();

		}
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
