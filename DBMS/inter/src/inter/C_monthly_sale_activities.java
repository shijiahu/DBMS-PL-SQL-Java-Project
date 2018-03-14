package inter;

import java.sql.*;
import java.util.Scanner;

import javax.swing.JTextField;

import oracle.jdbc.*;
import java.math.*;
import java.io.*;
import java.awt.*;
import oracle.jdbc.pool.OracleDataSource;

public class C_monthly_sale_activities {
	public static String monthly_sale_activities (String eid) throws SQLException {
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
	        CallableStatement cs = conn.prepareCall("begin proj2_v1.monthly_sale_activities2(?,?,?); end;");
	        //register the out parameter (the first parameter)
	        cs.registerOutParameter(2, OracleTypes.CURSOR);
	        cs.registerOutParameter(3, OracleTypes.NUMBER);
	        cs.setString(1, eid);
	        

	        // execute and retrieve the result set
	        cs.execute();
	        ResultSet rs = (ResultSet)cs.getObject(2);
	        int rss = cs.getInt(3);
	        // print the results
	        if(rss==0){
	        result = result +("eid"+"\t"+"name"+"\t"+"month"+"\t"+"year"+"\t"+"total sales"+"\t"+"total quantity"+"\t"+"total dollar"+"\n");
	        while (rs.next()) {
	        	result = result +(eid + "\t" + rs.getString(1) + "\t" +
	                    rs.getString(2) + "\t" + rs.getString(3) + "\t" +
	                    rs.getString(4) +
	                    "\t" + rs.getString(5) + "\t" +
	                    rs.getString(6)+"\n");
	        }
	        }
	        else {
	        	result = "no record is found\n";
	        }

	        //close the result set, statement, and the connection
	        cs.close();
	        conn.close();
	   }
	   catch (SQLException ex) { result = result + ("\n invalid eid \n");}
	   catch (Exception e) {result = result + ("\n*** other Exception caught ***\n");}
	    return result;
	  }
}
