package com.packtpub.restapp.reportingservice;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class Homecontroller {
	@ResponseBody
	@RequestMapping("")
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "PBKK D");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}
}