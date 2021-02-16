package com.model.beans;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/memberPage")
public class MemberPageBean {

	@RequestMapping("/memberBoard")
	public String session_memberBoard(HttpSession session) {

		return "/userPage/memberPage/memberBoard";
	}

}
