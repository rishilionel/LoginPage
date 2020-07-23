package userentry;

import java.sql.*;
public class Daoclass1 
{
	private boolean endresult=false;
	public Daoclass1(String name,String password) throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3307/study?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
		String uname="root";
		//your mysql password
		String pw="?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pw);
		Statement st=con.createStatement();
//		To avoid simple hack
		if(name.compareTo("' or true or '")==0)
		{
			
		}
		else
		{
			String condition = "Select * from login where name='" +name+ "' and password='" +password+ "'";
			ResultSet rs = st.executeQuery(condition);
			if(rs.next())
			this.endresult=true;
		}
		st.close();
		con.close();
	}
	public boolean end()
	{
		return this.endresult;
	}
}
