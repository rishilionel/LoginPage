package userentry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Daoclass3 {
	private boolean endresult=false;
	public Daoclass3(String name) throws ClassNotFoundException, SQLException
	{
		// in place of study you have to mention your db name
		String url="jdbc:mysql://localhost:3307/study?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
		// your mysql username
		String uname="root";
		// ur mysql password
		String pw="?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pw);
		Statement st=con.createStatement();
		String condition = "Select * from login where name='" +name+"'";
		ResultSet rs = st.executeQuery(condition);
		if(rs.next())
		this.endresult=true;
		st.close();
		con.close();
	}
	public boolean checkavail()
	{
		return endresult;
	}
}
