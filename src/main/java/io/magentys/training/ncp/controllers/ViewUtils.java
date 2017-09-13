package io.magentys.training.ncp.controllers;

import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class ViewUtils {
    public static String render(Map<String, Object> model,String templatePath) {
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }

}
