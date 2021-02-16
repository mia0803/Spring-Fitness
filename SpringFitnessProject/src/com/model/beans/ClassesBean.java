package com.model.beans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/class")
public class ClassesBean {

	@RequestMapping("/addClass")
	public String cookie_addClass() {

		return "/classes/addClass";
	}

}
