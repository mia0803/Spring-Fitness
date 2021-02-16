package com.model.beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage")
public class HomepageBean {

	@RequestMapping("/leadPage")
	public String leadPage(HttpSession session) { // To lead to original page

		String path = (String) session.getAttribute("pagePath");
		if (path == null) {
			path = "/homepage/main";
		}
		session.removeAttribute("pagePath");
		return path;
	}

	@RequestMapping("/main")
	public String cookie_main(HttpServletRequest request, Model m, HttpSession session) {

		return "/homepage/main";
	}

	@RequestMapping("/classPage")
	public String cookie_classPage() {

		return "/homepage/classPage";
	}

	@RequestMapping("/pilates")
	public String cookie_pilates() {

		return "/homepage/pilates";
	}

	@RequestMapping("/ptPage")
	public String cookie_ptPage() {

		return "/homepage/ptPage";
	}

}
