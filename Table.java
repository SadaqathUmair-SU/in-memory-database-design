import java.util.*;
public class Table {

	private String tableName;
	private List<Row> rows = new ArrayList<>();
	private Integer autoId;
	private Map<String, Column> columnMap = new HashMap<>();
	private List<String> columnNames = new ArrayList<>();
	
	
	//Method to create Table and Columns 
	protected Table(String tableName, List<Column> column){
		  this.tableName = tableName;
		  populate(column);
		 this.autoId = 1;
		 
		  
	}
	
	//Synchronized method to handle Multithreading 
	private synchronized Integer incrementAutoId(){
		return this.autoId++;
	}
	
	//Truncates the records
	protected void truncateRows(){
		this.rows.clear();
	}
	
	//Inserts the records into the Table
	protected void insertRow(Map<Column,Object> column){
		
		for(Column c : column.keySet()){
			if(!checkIfColumnExists(c.getColumnName()))return;
		}
		Integer rowId = incrementAutoId();
		Map<Column,Object> m = new HashMap<>(column);
		Row row = new Row(rowId, m);
		this.rows.add(row);
		
	}
	
	protected void printRows(){
		printRecords(this.rows);
	}
	
	
	//Prints the records
	private void printRecords(List<Row> rows){
		 System.out.print("\n\n\t");
	     
	        	for(String s : columnNames){
	            System.out.print("\t"+s+"\t");
	        	}
	  
		
		for(Row r : rows){
			System.out.print("\n\t"+r.getRowId()+".");
			for(Map.Entry<Column, Object> entry : r.getColumnData().entrySet()){
				System.out.print("\t"+entry.getValue()+"\t");
			}
		}
		
	}
	
	//Helper method just to structure the Table with all the columns
	private void populate(List<Column> col){
		
		for(Column c : col){
			
			columnNames.add(c.getColumnName());
		}
	}
	
	//To fetch the records based on given column value
	protected void getRecordsByColumn(Column col, Object val){
		List<Row> rows = new ArrayList<>();
		for(Row r : this.rows){
			
			Object colValue = r.getColumnData().get(col);
			
			if(colValue.equals(val)){
				
			rows.add(r);
			}
		}
		System.out.println();
		System.out.println();
		printRecords(rows);
		
	}
	
	private boolean checkIfColumnExists(String colName){
		
		if(columnNames.contains(colName))return true;
		else
			return false;
	}
	
}
