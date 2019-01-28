package ma.craft.imagecode.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Container {

public String name;
public String type;
public Float confidence;
public Integer x;
public Integer y;
public Integer width;
public Integer height;
public List<Child> children ;


}