package userentry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Daoclass2 {
	public Daoclass2(String name,String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
	String url="jdbc:mysql://localhost:3307/study?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
	String uname="root";
	// your mysql password
	String pw="?";
	// login - table name
	String query="insert into login value('"  +name+  "','"  +password+  "')";
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con=DriverManager.getConnection(url,uname,pw);
	Statement st=con.createStatement();
	st.executeUpdate(query);
	st.close();
	con.close();
	}
}
