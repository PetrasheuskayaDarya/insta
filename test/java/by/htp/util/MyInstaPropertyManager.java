package by.htp.util;

import java.util.ResourceBundle;

public class MyInstaPropertyManager {
	
private static final ResourceBundle rb;
	
	static {
		rb = ResourceBundle.getBundle("test_config");
	}
	
	public static String getUrl(){
		return rb.getString("insta.url");
	}
	
	public static String getLogin(){
		return rb.getString("insta.login");
	}
	
	public static String getPass(){
		return rb.getString("insta.pass");
	}

	
	
}


