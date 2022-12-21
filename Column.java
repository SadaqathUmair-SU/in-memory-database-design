import java.util.*;
public class Column {

	public DataTypes type;
	public String name;
	
	
	public Column(String name, DataTypes type){
		this.type = type;
		this.name = name;
	}
	
	public String getColumnName(){
		return this.name;
	}
	
}
