package ma.craft.imagecode;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.craft.imagecode.generation.CodeGenerationTextFile;
import ma.craft.imagecode.generation.CodeIndented;
import ma.craft.imagecode.generation.GenerateEmptyTextFile;
import ma.craft.imagecode.generation.Pushing1stCommentIneTextFile;

@SpringBootApplication
public class ImageCodeApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(ImageCodeApplication.class, args);

		// creation d un fichier text vide window

		GenerateEmptyTextFile.createTextFile();

		// Remlissage du fichier avec un commentaire au début
		Pushing1stCommentIneTextFile.pushCodeTextFile();

		// Remlissage du fichier avec du code react native
		CodeGenerationTextFile.generateTextFile();

		// indenter le fichier text
		CodeIndented.readFile();
	}

}
