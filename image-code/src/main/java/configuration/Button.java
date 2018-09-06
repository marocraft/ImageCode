package configuration;

public class Button {
	private String name;
	private String width;
	private String height;
	
	public Button() {
		super();
	}

	public Button(String name, String width, String height) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
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
	
	
	
	

}
