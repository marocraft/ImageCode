package ma.craft.imagecode.generation;

import ma.craft.imagecode.domain.Child;
import ma.craft.imagecode.domain.Container;
import ma.craft.imagecode.parsing.Mapper;
import ma.craft.imagecode.parsing.Parser;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class Generator {

public static final String TEMPLATE_FOLDER="templates/";
public static final String TEMPLATE_EXTENSION=".template";
public static final String END_TEMPLATE="end.view.template";

    Parser parser = new Parser();
    Mapper mapper = new Mapper();
    TemplateLoader templateLoader = new TemplateLoader();

    public String generate(String dataFile, String schemaFile)throws IOException {

        parser.validateSchema(dataFile,schemaFile);
        JSONObject json = parser.readJsonFile(dataFile);
        Container container = mapper.getContainer(json);
        List<Child> children = mapper.getAllChildreen(json);


        String containerTemplate = templateLoader.loadContainerTemplate(container,TEMPLATE_FOLDER+container.getType()+TEMPLATE_EXTENSION);

        for (Child child:children) {
            String result = templateLoader.loadChildTemplate(child,TEMPLATE_FOLDER+child.getType()+TEMPLATE_EXTENSION);
            containerTemplate=containerTemplate+result;

        }

        String closedContainer = templateLoader.readTemplate(TEMPLATE_FOLDER+END_TEMPLATE);

        return containerTemplate+closedContainer;
    }

}
