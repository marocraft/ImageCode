package ma.craft.imagecode;

import ma.craft.imagecode.domain.Window;
import ma.craft.imagecode.parsing.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

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
        Window win = loader.parseFile();
        Assert.assertNotNull(win);
        Assert.assertEquals("100", win.getButton().getHeight());
    }

}
