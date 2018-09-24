package ma.craft.imagecode;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import ma.craft.imagecode.domain.Window;
import ma.craft.imagecode.parsing.Parser;

public class DomainTest {
	@Test
	public void shouldFindWindowYmlFile() throws IOException {
		Parser parser = new Parser();
		URL url = parser.getFileURL();
		Assert.assertNotNull(url);
	}

	@Test
	public void shouldParseFile() throws IOException {
		Parser loader = new Parser();
		Window window = loader.parseFile();
		Assert.assertNotNull(window);
		Assert.assertEquals("100", window.getButton().getHeight());
	}

	@Test
	public void shouldGenerateFile() throws IOException {
		File file = new File("code-react-native.txt");
		Assert.assertNotNull(file);
	}

	@Test
	public void shouldGenerateExpectedFile() throws IOException {
		File actualFile = new File("code-react-native.txt");
		File expectedFile = new File("expected-code-react-native.txt");
		Assert.assertNotEquals("msg", actualFile, expectedFile);
	}

}
