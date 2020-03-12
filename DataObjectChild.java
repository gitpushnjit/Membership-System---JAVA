
public class DataObjectChild extends DataObject{
	
	protected boolean bool;
	protected String method;
	protected String[] str = new String[7];
	
	public String[] getStr(){
		return str;
	}

	public void setStr(String[] str){
		this.str = str;
	}
	
	public void setBool(boolean bool)
	{
		this.bool = bool;
	}
	
	public boolean getBool()
	{
		return bool;
	}
	
	public void setMethod(String method)
	{
		this.method = method;
	}
	
	public String getMethod()
	{
		return method;
	}
}
