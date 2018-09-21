package ma.craft.imagecode;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.craft.imagecode.domain.Window;
import ma.craft.imagecode.generation.CodeGeneration;
import ma.craft.imagecode.generation.CodeIndented;
import ma.craft.imagecode.generation.Generate;
import ma.craft.imagecode.generation.PushingCodeTextFile;
import ma.craft.imagecode.parsing.Parser;

@SpringBootApplication 
public class ImageCodeApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(ImageCodeApplication.class, args);

		Parser loader = new Parser();
		Window win = loader.parseFile();
		System.out.print(win);
		
		//creation d un fichier text vide 
		Generate gen = new Generate();
		gen.generateTextFile();
		
		//Remlissage du fichier avec un commentaire au début  
		PushingCodeTextFile push = new PushingCodeTextFile();
		push.pushCodeTextFile();
		
		//Remlissage du fichier avec du code react native
		CodeGeneration codegen = new CodeGeneration();
		codegen.CodeGenTextFile();
		
		//indenter le fichier text
		CodeIndented codeind = new CodeIndented();
		codeind.readFile();
	}
	
	
}
