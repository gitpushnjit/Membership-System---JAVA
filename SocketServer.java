import java.io.*;
import java.net.*;

public class SocketServer {
	public static void main(String[] arg) {

		DataObjectChild dataChild = null;
		try {
				ServerSocket myServerSocket = new ServerSocket(2312);
				while(true)
					{
						Socket incoming = myServerSocket.accept();
						MemberSystemMethods ms = new MemberSystemMethods();
						ObjectOutputStream myOutputStream = new ObjectOutputStream(incoming.getOutputStream());

						ObjectInputStream myInputStream = new ObjectInputStream(incoming.getInputStream());
						dataChild = (DataObjectChild) myInputStream.readObject();
						 
							String message = "";
							switch (dataChild.getMethod()) {
							
							case "checkCred": 
							{
								message = ms.checkCred(dataChild.getMessage());
								break;
							}
								
							case "getRole": {
								message = ms.getRole(dataChild.getMessage());
								break;
							}
								
							case "getValueDB": {
								dataChild.setStr(ms.getValueDB(dataChild.getMessage()));
							}
								
							case "addValueDB": {
								dataChild.setBool(ms.addValueDB(dataChild.getMessage()));
								break;
							}
							case "editValueDB": {
								dataChild.setBool(ms.editValueDB(dataChild.getMessage()));
								break;
							}
							case "remValueDB": {
								dataChild.setBool(ms.remValueDB(dataChild.getMessage()));
								break;
							}
							}
							
							//System.out.println("Almost");
							dataChild.setMessage(message);
							myOutputStream.writeObject(dataChild);
									
			}

			/*
			 * System.out.println("Message received : " +
			 * myObject.getMessage());
			 * 
			 * myObject.setMessage("Got it!");
			 * 
			 * System.out.println("Message sent : " + myObject.getMessage());
			 */

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
