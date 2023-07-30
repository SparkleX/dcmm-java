package example.card;

import org.apache.ibatis.jdbc.SQL;

public class FilterSqlProvider {
    public static String filter(Filter filter) {
        //return "select * from foo";
        
    	SQL sql = new SQL();
    	sql.SELECT("*");
    	sql.FROM("foo");
    	sql.WHERE("NodeId=#{params.id}");
    	String str = sql.toString();
    	return str;
    
    }
}
