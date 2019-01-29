package ma.craft.imagecode.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Child {

	private String name;
	private String type;
	private Float confidence;
	private Integer x;
	private Integer y;
	private Integer width;
	private Integer height;

}