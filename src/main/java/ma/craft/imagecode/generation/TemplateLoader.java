package ma.craft.imagecode.generation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import ma.craft.imagecode.domain.Child;
import ma.craft.imagecode.domain.Container;

public class TemplateLoader {

	public String loadContainerTemplate(Container container, String path) throws IOException {
		String result = readTemplate(path);
		return result.replaceAll("#width", container.getWidth().toString())
				.replaceAll("#height", container.getHeight().toString()).replaceAll("#name", container.getName())
				.replaceAll("#x", container.getX().toString()).replaceAll("#y", container.getY().toString());
	}

	public String loadChildTemplate(Child child, String path) throws IOException {

		String result = readTemplate(path);
		return result.replaceAll("#width", child.getWidth().toString())
				.replaceAll("#height", child.getHeight().toString()).replaceAll("#name", child.getName())
				.replaceAll("#x", child.getX().toString()).replaceAll("#y", child.getY().toString());
	}

	public String  readTemplate(String url) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		classLoader.getResourceAsStream(url);
        return new String(Files.readAllBytes(new File(classLoader.getResource(url).getFile()).toPath()));



	}

}
