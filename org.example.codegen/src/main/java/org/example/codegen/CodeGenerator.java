package org.example.codegen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CodeGenerator {

	final private String genFolder = "gen";
	final private String genPackage = "org/example/codegen/generated";
	final private String genClass = "GeneratedClass";

	public static void main(final String[] args) {
		new CodeGenerator();
	}

	public CodeGenerator() {
		createGenPackageFolder();
		generateClassSrc();
	}

	private void createGenPackageFolder() {
		final String projectDir = System.getProperty("user.dir");
		final String genDir = projectDir + "/" + genFolder + "/" + genPackage;
		try {
			Files.createDirectories(Paths.get(genDir));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	private void generateClassSrc() {
		final String classContent = "" //
				+ "package org.example.codegen.generated;\n" //
				+ "\n" //
				+ "public class GeneratedClass {\n" //
				+ "	public static void main(final String[] args) {\n" //
				+ "		System.out.println(\"Hello, I'm a generated class!\");\n" //
				+ "	}\n" //
				+ "}";
		final Path classFile = Paths
				.get(System.getProperty("user.dir") + "/" + genFolder + "/" + genPackage + "/" + genClass + ".java");
		try {
			Files.write(classFile, classContent.getBytes());
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

}
