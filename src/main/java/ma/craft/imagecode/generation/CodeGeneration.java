package ma.craft.imagecode.generation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ma.craft.imagecode.domain.Window;
import ma.craft.imagecode.parsing.Parser;

public class CodeGeneration {

    public void CodeGenTextFile() throws IOException {
        Parser parser = new Parser();
        Window window = parser.parseFile();
        String lesImports = "import React, { Component } from 'react';\r\n" +
                "import { button, View } from 'react-native';\r\n" +
                "\r\n" +
                "class ImageCode extends Component {\r\n" +
                "render() {\r\n" +
                "return (\r\n" +
                "<View style={{";
        String lesImports2 = "}}>\r\n" +
                "        <button style={{\n";
        String lesImports3 = "}}>";
        String lesImports4 = "}}>\r\n" +
                "<button style={{}}>\r\n";
        BufferedWriter writer = new BufferedWriter(new FileWriter("code-react-native.txt", true));
        writer.append(lesImports);
        writer.append("\nWidth:" + window.getWidth() + ",\n");
        writer.append("Height:" + window.getHeight());
        writer.append("\n" + lesImports2);
        writer.append("\nWidth:" + window.getButton().getWidth() + ",\n");
        writer.append("Height:" + window.getButton().getHeight());
        writer.append("\n" + lesImports3);
        writer.append("\n" + window.getButton().getName() + "\n");
        writer.append(lesImports4);
        writer.close();
    }

}
