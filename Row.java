import java.util.*;
public class Row {
    
	public int rowId;
	public Map<Column, Object> column;
	
	
	public Row(int rowId, Map<Column,Object> column){
		this.rowId = rowId;
		this.column = column;
	}
	
	public int getRowId(){
		return this.rowId;
	}
	
	public Map<Column, Object> getColumnData(){
		return this.column;
	}
	
}
