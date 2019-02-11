package ma.craft.imagecode.parsing;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ma.craft.imagecode.domain.Child;
import ma.craft.imagecode.domain.Container;

public class MapperTest {

	Mapper mapper;

	Parser parser;

	Container container;

	@Before
	public void init() {

		parser = new Parser();
		mapper = new Mapper();
		container = new Container();
		container.setName("window");
		container.setType("container");
		container.setWidth(45);
		container.setHeight(780);
		container.setX(12);
		container.setY(0);
		container.setConfidence((float) 0.97);

		Child checkbox = new Child();
		checkbox.setName("checkbox");
		checkbox.setType("checkbox");
		checkbox.setConfidence((float) 0.97);
		checkbox.setX(20);
		checkbox.setY(100);
		checkbox.setWidth(200);
		checkbox.setHeight(50);

		Child button = new Child();
		button.setName("button");
		button.setType("button");
		button.setConfidence((float) 0.87);
		button.setX(4);
		button.setY(10);
		button.setWidth(100);
		button.setHeight(100);
		List<Child> children = new ArrayList<>();
		children.add(checkbox);
		children.add(button);
		container.setChildren(children);

	}

	@Test
	public void shouldMapJsonObjectToCOntainerObject() throws IOException {

		// Given

		// When
		Container result = mapper.getContainer(parser.readJsonFile("data.json"));

		// Then

		assertEquals(container, result);
	}

	@Test
	public void shouldMapJsonObjectToChildrenList() throws IOException {

		// Given

		// When
		List<Child> children = mapper.getAllChildreen(parser.readJsonFile("data.json"));

		// Then
		assertEquals(container.getChildren().get(0), children.get(0));
	}

}
