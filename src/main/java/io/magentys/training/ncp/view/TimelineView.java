package io.magentys.training.ncp.view;

import io.magentys.mvc.View;
import io.magentys.mvc.ViewUtils;
import io.magentys.mvc.authentication.User;
import io.magentys.training.ncp.model.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimelineView implements View{

	private static final String TEMPLATE_NAME = "timeline.ftl";
	
	Map<String, Object> map = new HashMap<>();
	
	public TimelineView(User user, List<Message> messages){
		map.put("user", user);
		map.put("messages", messages);
	}	
	
	public TimelineView(User user, List<Message> messages, User profileUser, boolean followed){
		this(user,messages);
		map.put("profileUser", profileUser);
		map.put("followed", followed);
	}	

	public String render(String title){
		map.put("pageTitle", title);
		return ViewUtils.render(map, TEMPLATE_NAME);
	}

}
