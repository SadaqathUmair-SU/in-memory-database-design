import java.util.*;
public class Database {
  String databaseName;
  HashMap<String,Table> map = new HashMap();
  
  
  //Database Name
  public Database(String name){
	  this.databaseName = name;
  }
  
  
  //Method for creating a new Table
  public void createTable(String tableName, List<Column> columns){
	  
	  if(map.containsKey(tableName))return;
	  Table table = new Table(tableName, columns);
	  map.put(tableName,table);
	  
  }
  
  
//Method for dropping a Table
  public void dropTable(String tableName){
	  if(!map.containsKey(tableName))return;
	  map.remove(tableName);
  }
  
  
  //Method for inserting a row into the Table
  public void insertTableRows(String tableName, Map<Column, Object> columnValues){
	  if(!map.containsKey(tableName))return;
	  Table table = map.get(tableName);
	  table.insertRow(columnValues);
	  
	  
  }
  
  //Method for printing all the rows from the Table  
  public void printRecords(String tableName){
	  if(!map.containsKey(tableName)){
		  System.out.println("\n\t\n\tDropped");
		  return;
	  }
	  Table table = map.get(tableName);
	  table.printRows();
  }
  
  
  //Method for fetching the rows based on provided column value
  public void getTableValuesByColumnValues(String tableName, Column col, Object val){
	  if(!map.containsKey(tableName))return;
	  Table table = map.get(tableName);
	  table.getRecordsByColumn(col, val);
  }
}
