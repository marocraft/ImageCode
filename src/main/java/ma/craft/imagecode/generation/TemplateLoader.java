package ma.craft.imagecode.generation;

import java.io.File;

import ma.craft.imagecode.domain.Child;
import ma.craft.imagecode.domain.Container;

public class TemplateLoader {

	public String loadContainer(Container container, String path) {
		String result = readTemplate(path).toString();
		return result.replaceAll("#width", container.getWidth().toString())
				.replaceAll("#height", container.getHeight().toString()).replaceAll("#name", container.getName())
				.replaceAll("#x", container.getX().toString()).replaceAll("#y", container.getY().toString());
	}

	public String loadChildTemplate(Child child, String path) {

		String result = readTemplate(path).toString();
		return result.replaceAll("#width", child.getWidth().toString())
				.replaceAll("#height", child.getHeight().toString()).replaceAll("#name", child.getName())
				.replaceAll("#x", child.getX().toString()).replaceAll("#y", child.getY().toString());
	}

	public File readTemplate(String url) {
		ClassLoader classLoader = TemplateLoader.class.getClassLoader();
		return new File(classLoader.getResource(url).getFile());

	}

}
