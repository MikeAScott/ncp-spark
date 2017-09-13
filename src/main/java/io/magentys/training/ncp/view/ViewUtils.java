package io.magentys.training.ncp.view;

import static spark.Spark.halt;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;

import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

public class ViewUtils {
    public static String render(Map<String, Object> model,String templatePath) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }
    
	public static void populateFromParams(Request request, Object bean) {
		try {
			MultiMap<String> params = new MultiMap<String>();
			UrlEncoded.decodeTo(request.body(), params, "UTF-8");
			BeanUtils.populate(bean, params);
		} catch (Exception e) {
			halt(501);
		}
	}
}
