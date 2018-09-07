package ma.craft.imagecode.domain;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


import org.yaml.snakeyaml.Yaml;

import com.google.common.io.ByteStreams;

class Test {
	
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
	
	
	public static void main(String[] args) throws IOException {
		Test loader = new Test();
		Window win = loader.loadFile();
		if(win.getName().equals("window"));{
			System.out.println("<view><view>");
		}
	}
	}


