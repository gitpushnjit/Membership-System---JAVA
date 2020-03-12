import java.sql.ResultSet;

public class MemberSystemQueryBuilder 
{	
	
	
	public String checkCred(String userName , String pwd)
	{	
		SocketClient client = new SocketClient();
		DataObjectChild dataChild = new DataObjectChild();
		dataChild.setMessage("SELECT `PWD` FROM `MemberSystemDatabase` WHERE `LOGINID` = '"+userName+"'");
		dataChild.setMethod("checkCred");
		dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);
		return dataChild.getMessage();
	}
	
	public String getRole(String userName)
		{
			SocketClient client = new SocketClient();
			DataObjectChild dataChild = new DataObjectChild();
			dataChild.setMessage("SELECT `MEMBERROLE` FROM `MemberSystemDatabase` WHERE `LOGINID` = '"+userName+"'");
			dataChild.setMethod("getRole");
			dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);
			return dataChild.getMessage();
		}
	
	public String[] getValueDB(String userName)

	{
			String[] empty = {""};
			SocketClient client = new SocketClient();
			DataObjectChild dataChild = new DataObjectChild();
			dataChild.setMessage("SELECT * FROM `MemberSystemDatabase` WHERE `LOGINID` = '"+userName+"'");
			dataChild.setMethod("getValueDB");
			dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);
			if(dataChild.getStr()==null){
				return empty;
			}
			else{
				return dataChild.getStr();
			}
	}
	
	public boolean addValueDB(String userName , String fName, String lName, String add, int cntctNo, String role, String pwd , String email)
	{
		SocketClient client = new SocketClient();
		DataObjectChild dataChild = new DataObjectChild();
		dataChild.setMessage("INSERT INTO MemberSystemDatabase " + 
                "VALUES ('"+userName+"' , '"+fName+"', '"+lName+"', '"+add+"', "+cntctNo+", '"+role+"', '"+pwd+"', '"+email+"')");
		dataChild.setMethod("addValueDB");
		dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);	
		return dataChild.getBool();
	}
	
	public boolean editValueDB(String userName , String fName, String lName, String add, int cntctNo, String role, String pwd , String email)
	{
		
			SocketClient client = new SocketClient();
			DataObjectChild dataChild = new DataObjectChild();
			dataChild.setMessage("UPDATE `MemberSystemDatabase` SET  `FIRSTNAME` = '"+fName+"', `LASTNAME` = '"+lName+"', `ADDRESS`='"+add+"', "
					+ "`CONTACTNUMBER`="+cntctNo+", `MEMBERROLE`='"+role+"', `PWD`='"+pwd+"', `email`='"+email+"' WHERE `LOGINID` = '"+userName+"'");
			dataChild.setMethod("editValueDB");
			dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);	
			return dataChild.getBool();
	}

	public boolean remValueDB(String userName)
	{
			SocketClient client = new SocketClient();
			DataObjectChild dataChild = new DataObjectChild();
			dataChild.setMessage("DELETE FROM MemberSystemDatabase WHERE `LOGINID` = '"+userName+"'");
			dataChild.setMethod("remValueDB");
			dataChild = (DataObjectChild) client.sendObjectToServer(dataChild);
			return dataChild.getBool();
	}
}