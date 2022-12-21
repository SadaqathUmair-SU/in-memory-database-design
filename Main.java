import java.util.*;
public class Application {
	
   private static final String tableName = "Student";
	
   public static void main(String[] args){

	Column name = new Column("name", DataTypes.STRING);
	Column age = new Column("age", DataTypes.INT);
	Database db = new Database("DB");
	List<Column> cols = new ArrayList<>();
	cols.add(name);
	cols.add(age);
	db.createTable(tableName, cols);
        Map<Column, Object> map = new HashMap<>();
        map.put(name, "Swraf");
        map.put(age, "23");
        db.insertTableRows(tableName, map);
        map.clear();
        map.put(name, "Daring");
        map.put(age, "45");
        db.insertTableRows(tableName, map);    
        db.printRecords(tableName);
        db.getTableValuesByColumnValues(tableName, age, "45");
        db.getTableValuesByColumnValues(tableName, name, "Swraf");
        db.dropTable(tableName);
        db.printRecords(tableName);
	
   }
	
}
