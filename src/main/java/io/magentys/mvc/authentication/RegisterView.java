package io.magentys.mvc.authentication;

import java.util.HashMap;
import java.util.Map;

import io.magentys.mvc.View;
import io.magentys.mvc.ViewUtils;


public class RegisterView implements View {

	private static final String TEMPLATE_NAME = "register.ftl";
	Map<String, Object> map = new HashMap<>();

	public RegisterView(){
	}	
	
	public void setUsername(String username){
		map.put("username", username);
	}
	
	public void setEmail(String email) {
		map.put("email", email);
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
