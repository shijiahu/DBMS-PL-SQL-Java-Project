package inter;

import java.sql.*;
import oracle.jdbc.*;
import java.math.*;
import java.io.*;
import java.awt.*;
import java.util.*;
import oracle.jdbc.pool.OracleDataSource;

public class C_show_purchases {
	public static String purchases () throws SQLException {
		String result = "";
	    try
	    {

	        //Connecting to Oracle server. Need to replace username and
	      	//password by your username and your password. For security
	      	//consideration, it's better to read them in from keyboard.
		String username = "cqi1";
		String password = "qc476404667";
	        OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
	        ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
	        Connection conn = ds.getConnection(username, password);

	        //Prepare to call stored procedure:
	        CallableStatement cs = conn.prepareCall("begin ? := proj2_v1.show_purchases(); end;");

	           //register the out parameter (the first parameter)
	        cs.registerOutParameter(1, OracleTypes.CURSOR);


	        // execute and retrieve the result set
	        cs.execute();
	        ResultSet rs = (ResultSet)cs.getObject(1);
	        result = result+"pur#"+"\t"+"eid"+"\t"+"pid"+"\t"+"cid"+"\t"+"qty"+"\t"+"ptime"+"\t\t"+"total_price"+"\n";
	        // print the results
	        while (rs.next()) {
	            result = result + (rs.getString(1) + "\t" +
	                rs.getString(2) + "\t" + rs.getString(3) + "\t" +
			rs.getString(4) + "\t" + rs.getString(5) + "\t" +
			rs.getString(6) + "\t" + rs.getDouble(7) +"\n");
	        }

	        //close the result set, statement, and the connection
	        cs.close();
	        conn.close();
	   }
	   catch (SQLException ex) { System.out.println ("\n*** SQLException caught ***\n" + 
	ex.getMessage());}
	   catch (Exception e) {System.out.println ("\n*** other Exception caught ***\n");}
	    return result;
	  }
}
