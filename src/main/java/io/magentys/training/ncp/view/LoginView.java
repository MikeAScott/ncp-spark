package io.magentys.training.ncp.view;

import java.util.HashMap;
import java.util.Map;


public class LoginView implements View {

	private static final String TEMPLATE_NAME = "login.ftl";
	Map<String, Object> map = new HashMap<>();

	public LoginView(){
	}	
	
	public void setUsername(String username){
		map.put("username", username);
	}
	
	public void setError(String error){
		map.put("error", error);
	}
	
	public void setMessage(String message){
		map.put("message", message);
	}

	@Override
	public String render(String title) {
		map.put("pageTitle", title);
		return ViewUtils.render(map, TEMPLATE_NAME);
	}

}
