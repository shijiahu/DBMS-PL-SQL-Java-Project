package inter;

import java.sql.*;
import java.util.Scanner;

import javax.swing.JTextField;

import oracle.jdbc.*;
import java.math.*;
import java.io.*;
import java.awt.*;
import oracle.jdbc.pool.OracleDataSource;

public class C_add_customer {
	public static String add_customer (String cid,String name,String telephone) throws SQLException {
		String result = "";
	    try
	    {

	    	String username = "cqi1";
			String password = "qc476404667";
	        OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
	        ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
	        Connection conn = ds.getConnection(username,password);

	        //Prepare to call stored procedure:
	        CallableStatement cs = conn.prepareCall("begin proj2_v1.add_customer(?,?,?); end;");

	        cs.setString(1, cid);
	        cs.setString(2, name);
	        cs.setString(3, telephone);

	        // execute and retrieve the result set
	        cs.execute();
	       

	        //close the result set, statement, and the connection
	        cs.close();
	        conn.close();
	        result = result + "add customer successfully\n";
	   }
	   catch (SQLException ex) { result = result + ("\n*** invalid customer information ***\n" );}
	   catch (Exception e) {result = result + ("\n*** other Exception caught ***\n");}
	    return result;
	  }
}
