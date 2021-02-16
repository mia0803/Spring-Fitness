package com.model.beans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminPage")
public class AdminPageBean {

	@RequestMapping("/adminBoard")
	public String session_adminBoard() {

		return "/userPage/adminPage/adminBoard";
	}

}
