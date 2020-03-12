import java.io.*;
import java.net.*;

public class SocketClient {

	public static DataObjectChild sendObjectToServer(DataObjectChild object) {

		try {
			Socket socketToServer = new Socket("afsaccess2.njit.edu",2313);

			ObjectOutputStream myOutputStream = new ObjectOutputStream(socketToServer.getOutputStream());

			ObjectInputStream myInputStream = new ObjectInputStream(socketToServer.getInputStream());
			
			DataObjectChild dataChild = (DataObjectChild) object;
			
			myOutputStream.writeObject(dataChild);

			object = (DataObjectChild) myInputStream.readObject();

			myOutputStream.close();

			myInputStream.close();

			socketToServer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	/*
	public static void main(String args[])
	{
		DataObjectChild doc = new DataObjectChild();
		doc.setMethod("Hi");
		doc = sendObjectToServer(doc);
		System.out.println(doc.getMessage());
				
	}	*/

}
