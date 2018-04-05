package com.hull.web;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:控制器基类
 * @Author:Sine Chen
 * @Date:Mar 18, 2015 11:01:06 AM
 * @Copyright: All Rights Reserved. Copyright(c) 2015
 */
public class BaseController {
	public static final String PG = "pg";
	public static final String VO = "vo";
	public static final String DATA = "data";
	public static final String MSG = "msg";
	public static final String DATA_LIST = "data_list";
	public static final String JSON_DATA = "json_data";
	public static final String VALIDATE_SUCCESS = "success";
	public static final String VALIDATE_FAIL = "fail";
	public static final String STATUS = "status";

	public ModelAndView view(String view) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(view);
		return mv;
	}

	public ModelAndView view(String view, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(view);
		mv.addAllObjects(model.asMap());
		return mv;
	}
}
