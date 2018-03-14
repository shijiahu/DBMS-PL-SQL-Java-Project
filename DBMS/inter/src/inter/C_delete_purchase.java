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

public class C_delete_purchase {
	public static String delete_purchase (String purnumber) throws SQLException {
		String result ="";
	    try
	    {

	        //Connecting to Oracle server. 
	    	String username = "shu27";
	    	String password = "5566345bB";
	        OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
	        ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
	        Connection conn = ds.getConnection(username,password);

	        //Prepare to call stored procedure:
	        CallableStatement cs = conn.prepareCall("begin proj2_v1.delete_purchase(?); end;");
	        int pnumber = Integer.parseInt(purnumber);
	        cs.setInt(1, pnumber);

	        // execute and retrieve the result set
	        cs.execute();
	       

	        //close the result set, statement, and the connection
	        cs.close();
	        conn.close();
	        result = result + "finished\n";
	   }
	   catch (SQLException ex) { result = result + ("\n invalid purchase number \n" );}
	   catch (Exception e) {result = result + ("\n*** other Exception caught ***\n");}
	    return result;
	  }
}
