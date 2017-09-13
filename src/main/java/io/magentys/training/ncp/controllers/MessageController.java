package io.magentys.training.ncp.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;

import io.magentys.training.ncp.model.Message;
import io.magentys.training.ncp.model.User;
import io.magentys.training.ncp.service.impl.MiniTwitService;

import static io.magentys.training.ncp.controllers.SessionUtils.*;

import spark.Request;
import spark.Response;


public class MessageController {
	
	private MiniTwitService service;
	
	public MessageController(MiniTwitService service) {
		this.service = service;
	}

	public Object postMessage(Request request, Response response)
			throws IllegalAccessException, InvocationTargetException {
		User user = getAuthenticatedUser(request);
		MultiMap<String> params = new MultiMap<String>();
		UrlEncoded.decodeTo(request.body(), params, "UTF-8");
		Message m = new Message();
		m.setUser(user);
		m.setPubDate(new Date());
		BeanUtils.populate(m, params);
		service.addMessage(m);
		response.redirect("/");
		return null;
	}

	
}
