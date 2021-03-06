package io.magentys.mvc.authentication.view;

import java.util.HashMap;
import java.util.Map;

import io.magentys.mvc.View;
import io.magentys.mvc.authentication.model.User;
import io.magentys.mvc.utils.ViewUtils;

public class LoginView implements View {

	private static final String TEMPLATE_NAME = "login.ftl";
	Map<String, Object> map = new HashMap<>();

	public LoginView(){
	}	
	
	public LoginView(User user) {
		setUsername(user.getUsername());
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
