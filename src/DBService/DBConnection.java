package DBService;

import Info.DBInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBConnection {
	
	private String url = DBInfo.url;
    private String id = DBInfo.user;
    private String password = DBInfo.password;
    
    Connection conn = null;  // db에 접속
    Statement stmt = null;  // sql 명령어 실행
    ResultSet rs = null;        // 결과셋

    public void connect() {
    	 try {
 	        Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 로딩
 	        conn = DriverManager.getConnection(url,id,password); // db에 접속
 	        stmt = conn.createStatement();
         } catch (Exception e) {
         	e.printStackTrace();
         } 
    }
    
    public void disconnect() {
    	if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
    
    public ArrayList<HashMap<String, Object>> selectAll(String sql) {
    	try {
	    	connect();
	    	rs = stmt.executeQuery(sql); 
	    	ResultSetMetaData md = rs.getMetaData();
	    	int columns = md.getColumnCount();
	    	
	    	ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	    	
	    	while (rs.next()) {
	    		HashMap<String, Object> row = new HashMap<>(columns);
	    		for (int i = 1; i <= columns; i++) {
	    			row.put(md.getColumnName(i), rs.getObject(i));
	    		}
	    		list.add(row);
	    	}
	    
	    	return list;
	    	
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		disconnect();
    	}
    	return null;
    }
    
    public HashMap<String, Object> selectOne(String sql) {
    	try {
	    	connect();
	    	rs = stmt.executeQuery(sql); 
	    	ResultSetMetaData md = rs.getMetaData();
	    	int columns = md.getColumnCount();
	    	
	    	HashMap<String, Object> row = new HashMap<>(columns);
	    	
	    	if (rs.next()) {
		    	for (int i = 1; i <= columns; i++) {
		    		row.put(md.getColumnName(i), rs.getObject(i));
		    	}
	    	}
	    	
	    	return row;
	    	
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		disconnect();
    	}
    	return null;
    }
    
    public int insert(String sql) {
    	int rst = 0;
    	try {
	    	connect();
	    	rst = stmt.executeUpdate(sql); 
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		disconnect();
    	}
    	return rst;
    }
    
    
}
