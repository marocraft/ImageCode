package ma.craft.imagecode.generation;

import ma.craft.imagecode.domain.Child;
import ma.craft.imagecode.domain.Container;
import ma.craft.imagecode.parsing.Mapper;
import ma.craft.imagecode.parsing.Parser;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TemplateLoaderTest {

    public static final String END_TEMPLATE="end.view.templates";

    Parser parser;
    Container container;
    Child button;
    Child checkbox;
    Mapper mapper;
    TemplateLoader templateLoader;

    @Before
    public void init() {

        parser = new Parser();
        mapper = new Mapper();
        templateLoader = new TemplateLoader();
        container = new Container();
        container.setName("window");
        container.setType("container");
        container.setWidth(45);
        container.setHeight(780);
        container.setX(12);
        container.setY(0);
        container.setConfidence((float) 0.97);
         checkbox = new Child("checkbox", "checkbox", (float) 0.97, 20, 100, 200, 50);
         button = new Child("button", "button", (float) 0.87, 4, 10, 100, 100);
        List<Child> children = new ArrayList<>();
        children.add(checkbox);
        children.add(button);
        container.setChildren(children);

    }

    @Test
    public void loadContainerTemplate() throws IOException {

        //when
        String loadContainer = templateLoader.loadContainerTemplate(container,"templates/container.template");
        //Then
        assertNotNull(loadContainer);
    }

    @Test
    public void loadChildTemplate() throws IOException {
        //when
        String childTemplate = templateLoader.loadChildTemplate(button,"templates/button.template");
        //Then
        assertNotNull(childTemplate);

    }

    @Test
    public void readTemplate() throws IOException {
        assertNotNull(templateLoader.readTemplate("templates/button.template"));
    }
}