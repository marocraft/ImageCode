package ma.craft.imagecode.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Container {

	private String name;
	private String type;
	private Float confidence;
	private Integer x;
	private Integer y;
	private Integer width;
	private Integer height;
	private List<Child> children;

}