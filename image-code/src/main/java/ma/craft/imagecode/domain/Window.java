package ma.craft.imagecode.domain;

import com.google.common.base.MoreObjects;

public class Window {
	private String name;
	private String width;
	private String height;
	private Button button;
	public Window() {
		super();
	}
	public Window(String name, String width, String height, Button button) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
		this.button = button;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public Button getButton() {
		return button;
	}
	public void setButton(Button button) {
		this.button = button;
	}
	
	@Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", name + "\n").add("width", width + "\n").add("height", height + "\n").add("button", button + "\n")
                .toString();
    }

}
