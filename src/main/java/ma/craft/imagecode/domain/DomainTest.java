package ma.craft.imagecode.domain;

import org.junit.Test;

public class DomainTest {
	@Test
	public void display() {
	Button btn = new Button("button","width","height");
	Window win = new Window("window","width","height",btn);
	win.getButton();
	win.getHeight();
	win.getName();
	win.getWidth();
	btn.getHeight();
	btn.getWidth();
	btn.getName();
	Button btn1 = new Button();
	Window win2 = new Window();
	win.toString();
	btn.toString();
	}

}
