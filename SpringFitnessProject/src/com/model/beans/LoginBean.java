package com.model.beans;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.dtogroups.MemberDTO;
import com.model.dtogroups.TransactionDTO;
import com.model.service.MemberService;
import com.model.service.TransactionService;

@Controller
@RequestMapping("/login")
public class LoginBean {

	@Autowired
	MemberService memberDAO = null;

	@Autowired
	TransactionService transactionDAO = null;

	@RequestMapping("/error")
	public String error() {

		return "/login/error";
	}

	@RequestMapping("/loginForm")
	public String cookie_loginForm(HttpServletRequest request, Model m) {

		String page = request.getParameter("page");
		m.addAttribute("page", page);

		return "/login/loginForm";
	}

	@RequestMapping("/loginPro")
	public String cookie_loginPro(MemberDTO dto, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model m) throws Exception {

		// Required parameters in loginPro page
		String sessionEmail = null;
		String user = null;
		int deactive = 0;
		String remember = null;

		MemberDTO memDTO = memberDAO.checkLogin(dto); // Null or memory location

		if (memDTO != null) { // User exist
			sessionEmail = memDTO.getEmail();
			session.setAttribute("sessionEmail", sessionEmail);

			if (memDTO.getAdmin() == 1) {
				user = "admin";
			} else if (memDTO.getTeacher() == 1) {
				user = "teacher";
			} else {
				user = "member";
			}
			session.setAttribute("user", user);

			TransactionDTO paid = transactionDAO.checkPayment(memDTO.getId()); // Null or memory location
			if (paid == null) { // Not paid
				session.setAttribute("notPaid", "yes");
			}

			deactive = memDTO.getDeactivate(); // Null or 0 or 1, usually 0
			if (deactive == 1) {
				memberDAO.activateMember(memDTO.getId());
			}
			m.addAttribute("deactive", deactive);

			// Check remember factor
			remember = request.getParameter("remember");
			if (remember != null) {
				// Create cookies
				Cookie cid = new Cookie("cEmail", sessionEmail);
				Cookie cpw = new Cookie("cPw", memDTO.getPw());
				Cookie cremember = new Cookie("cRemember", remember);

				cid.setMaxAge(60 * 60 * 24);
				cpw.setMaxAge(60 * 60 * 24);
				cremember.setMaxAge(60 * 60 * 24);

				response.addCookie(cid);
				response.addCookie(cpw);
				response.addCookie(cremember);
			} else {
				// Remove cookies
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie c : cookies) {
						String name = c.getName();
						if (name.equals("cEmail")) {
							c.setMaxAge(0);
						}
						if (name.equals("cPw")) {
							c.setMaxAge(0);
						}
						if (name.equals("cRemember")) {
							c.setMaxAge(0);
						}
					}
				}
			}

		} else { // No user data
			m.addAttribute("sessionEmail", sessionEmail);
		}

		return "/login/loginPro";
	}

	@RequestMapping("/logoutPro")
	public String logoutPro(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

		session.invalidate();

		// Remove cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				if (name.equals("cEmail")) {
					c.setMaxAge(0);
				}
				if (name.equals("cPw")) {
					c.setMaxAge(0);
				}
				if (name.equals("cRemember")) {
					c.setMaxAge(0);
				}
			}
		}
		return "/login/logoutPro";
	}

	@RequestMapping("/findUsername.em")
	public String findUsername() {

		return "/login/findUsername";
	}

	@RequestMapping("/findUsernamePro")
	public String findUsernamePro(MemberDTO dto, Model m) throws Exception {

		String email = memberDAO.getEmail(dto);

		m.addAttribute("email", email);

		return "/login/findUsernamePro";
	}

	@RequestMapping("/findPassword.em")
	public String findPassword() {

		return "/login/findPassword";
	}

	@RequestMapping("/findPasswordPro")
	public String findPasswordPro(MemberDTO dto, Model m) throws Exception {

		String user = memberDAO.getPw(dto);
		if (user != null) {
			m.addAttribute("user", user);
			m.addAttribute("email", dto.getEmail());
		}

		return "/login/findPasswordPro";
	}

	@RequestMapping("/setPasswordPro")
	public String setPasswordPro(MemberDTO dto, Model m) throws Exception {
		System.out.println(dto.getEmail());
		System.out.println(dto.getPw());
		memberDAO.updatePw(dto);

		return "/login/setPasswordPro";
	}

}
