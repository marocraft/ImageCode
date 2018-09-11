package ma.craft.imagecode.parsing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import com.google.common.io.ByteStreams;

import ma.craft.imagecode.domain.Window;

public class Parsing {
	
	public URL getFileURL() throws IOException {
		URL url = getClass().getResource("window.yml");
		url.openStream().close();
		return url;
	}
	public Window loadFile() throws IOException {
		URL url = getFileURL();
		InputStream iputstream = url.openConnection().getInputStream();
		return new Yaml().loadAs(new ByteArrayInputStream(ByteStreams.toByteArray(iputstream)), Window.class);
	}
	

	@Test
	public void ParsingTest() throws IOException {
		Parsing loader = new Parsing();
		Window win = loader.loadFile();
		System.out.println(win.getButton().getHeight());
	}
	public static void main(String[] args) throws IOException {
		Parsing loader = new Parsing();
		Window win = loader.loadFile();
		System.out.println(win.getButton().getHeight());

	}
	

}
