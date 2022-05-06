package test;

public class LoginAction {

	private String name;
	private String pwd;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String execute()
	{
		
		if(name.equals(name) && pwd.equals("123"))
			return "success";
		else
			return "error";
		
	}
	
}
