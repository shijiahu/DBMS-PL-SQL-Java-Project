package inter;
import java.util.Scanner;

import oracle.jdbc.*;
import java.math.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.awt.*;
import oracle.jdbc.pool.OracleDataSource;

public class C_add_purchase {
	public static String add_purchase (String eid,String cid,String pid,int qty) throws SQLException {
		String result = "";
	    try
	    {
	        //Connecting to Oracle server. 
	    	String username = "shu27";
	    	String password = "5566345bB";
	        OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
	        ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
	        Connection conn = ds.getConnection(username,password);

	        //Prepare to call stored procedure:
	        CallableStatement cs = conn.prepareCall("begin proj_v1.add_purchase(?,?,?,?,?,?); end;");
	        cs.registerOutParameter(5, OracleTypes.VARCHAR);
	        cs.registerOutParameter(6, OracleTypes.NUMBER);
	        cs.setString(1, eid);
	        cs.setString(2, pid);
	        cs.setString(3, cid);
	        cs.setInt(4, qty);

	        // execute and retrieve the result set
	       
	        cs.execute();
	       String rs = cs.getString(5);
	       int rss = cs.getInt(6);
	       result = result + rs +"\n";
	       result = result + String.valueOf(rss) +"\n";

	        //close the result set, statement, and the connection
	        cs.close();
	        conn.close();
	   }
	   catch (SQLException ex) { result = result +("\n invalid addition \n" );}
	   catch (Exception e) {result = result + ("\n*** other Exception caught ***\n");}
	    return result;
	  }
}
