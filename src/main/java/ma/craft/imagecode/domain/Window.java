package ma.craft.imagecode.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Window {
	private String name;
	private String width;
	private String height;
	private Button button;

	public Window() {
		super();
	}

}
