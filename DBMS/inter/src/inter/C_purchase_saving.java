package inter;

import java.sql.*;
import java.util.Scanner;

import javax.swing.JTextField;

import oracle.jdbc.*;
import java.math.*;
import java.io.*;
import java.awt.*;
import oracle.jdbc.pool.OracleDataSource;


public class C_purchase_saving {
	public static String purchase_saving (String pur_number) throws SQLException {
		String result = "";
	    try
	    {	     
		String username = "cqi1";
		String password = "qc476404667";
	        OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
	        ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
	        Connection conn = ds.getConnection(username,password);

	        //Prepare to call stored procedure:
	        CallableStatement cs = conn.prepareCall("begin ? := proj2_v1.purchase_saving(?); end;");
	        //register the out parameter (the first parameter)
	        cs.registerOutParameter(1, OracleTypes.NUMBER);

	        int pur = Integer.parseInt(pur_number);
	        cs.setInt(2, pur);

	        // execute and retrieve the result set
	        cs.execute();
		    result = result + "purchase saving"+"\n";
	        float rs = cs.getFloat(1);
	        // print the results
	            result = result +String.valueOf(rs) + "\n";

	        //close the result set, statement, and the connection
	        cs.close();
	        conn.close();
	   }
	   catch (SQLException ex) { result = result + "\n Pur# value is invalid\n";}
	   catch (Exception e) {System.out.println ("\n*** other Exception caught ***\n");}
	    return result;
	  }

}
