import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberSystemMethods 
{
	

		public static final String user = "pnr6";
		public static final String password = "MQCUHa4tz";
		public static final String url = "jdbc:mysql://sql2.njit.edu/pnr6";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		public void setDBConn()
		{
			try
			{
				connection = null;
				statement = null;
				resultSet = null;
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
			}
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		public void closeDBConn()
		{
			try 
			{
				if( resultSet != null )
					resultSet.close();
				if( statement != null )
					statement.close();
				if( connection != null )
					connection.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		public String checkCred(String query)
		{
			setDBConn();
			try
			{
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				//String query = "SELECT `PWD` FROM `MemberSystemDatabase` WHERE `LOGINID` = '"+userName+"'";
				resultSet = statement.executeQuery(query);
				resultSet.next();
				/*if(pwd.equals(resultSet.getString(1)))
					return true;*/
				return resultSet.getString(1);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
 			closeDBConn();
 			return "Error";
		}
		
 		public String[] getValueDB(String query)

		{
 			setDBConn();
 			String[] str = new String[7];
			try
			{
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				//String query = "SELECT * FROM `MemberSystemDatabase` WHERE `LOGINID` = '"+userName+"'";
				resultSet = statement.executeQuery(query);
				resultSet.next();
				str[0] = resultSet.getString(1); 
				str[1] = resultSet.getString(2);
				str[2] = resultSet.getString(3);
				str[3] = resultSet.getString(4);
				str[4] = resultSet.getString(5);
				str[5] = resultSet.getString(6);
				str[6] = resultSet.getString(8);	
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
 			
 			closeDBConn();
 			return str;
		}

 		public String getRole(String query)
 		{
 			setDBConn();
			try
			{
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				//String query = "SELECT `MEMBERROLE` FROM `MemberSystemDatabase` WHERE `LOGINID` = '"+userName+"'";
				resultSet = statement.executeQuery(query);
				resultSet.next();
				
				return resultSet.getString(1);
					
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
 			closeDBConn();
 			return "Error";
 		}
 		
		public boolean addValueDB(String query)
		{
			setDBConn();
			boolean bool = false;
			try
			{
				statement = connection.createStatement(); 
				statement.executeUpdate(query);
				bool = true;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			closeDBConn();
			return bool;
		}
		
		public boolean editValueDB(String query)
		{
			setDBConn();
			boolean bool = false;
			try
			{
				statement = connection.createStatement();
				statement.executeUpdate(query);
				bool = true;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			closeDBConn();
			return bool;
		}

		public boolean remValueDB(String query)
		{
			setDBConn();
			boolean bool = false;
			try
			{
				statement = connection.createStatement(); 
				statement.executeUpdate(query);
				bool = true;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			closeDBConn();
			return bool;
		}
}
