package ma.craft.imagecode.generation;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import ma.craft.imagecode.domain.Child;
import ma.craft.imagecode.domain.Container;

public class TemplateLoaderTest {

	public static final String CONTAINER_TEMPLATE_URL = "templates/view.template";
	public static final String CHILD_TEMPLATE_URL = "templates/button.template";

	TemplateLoader templateLoader;

	Container container;

	Child child;

	@Before
	public void init() {
		templateLoader = new TemplateLoader();

		container = new Container();
		container.setName("view");
		container.setType("container");
		container.setConfidence((float) 0.98);
		container.setHeight(100);
		container.setWidth(500);
		container.setX(12);
		container.setY(1);

		child = new Child();
		child.setName("view");
		child.setType("container");
		child.setConfidence((float) 0.98);
		child.setHeight(100);
		child.setWidth(500);
		child.setX(12);
		child.setY(1);

	}

	@Test
	public void shouldReadTemplateFile() {
		templateLoader.readTemplate(CONTAINER_TEMPLATE_URL);

	}

	@Test
	public void shoulLoadContainerTemplate() {

		// Given

		// When
		String result = templateLoader.loadContainer(container, CONTAINER_TEMPLATE_URL);

		// Then
		assertNotNull(result);

	}

	@Test
	public void shoulLoadChildTemplate() {

		String result = templateLoader.loadChildTemplate(child, CHILD_TEMPLATE_URL);

		assertNotNull(result);
	}

}
