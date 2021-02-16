package com.model.beans;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
public class AopAdvice {

	// cookie update
	@Around("execution(public * com.model.beans..*cookie*(..))")
	public Object Cookie(ProceedingJoinPoint jp) throws Throwable {
		// get request in aspect class
		RequestAttributes rattr = RequestContextHolder.currentRequestAttributes();
		ServletRequestAttributes srattr = (ServletRequestAttributes) rattr; // has request, response
		HttpServletRequest request = srattr.getRequest();

		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("cEmail")) {
					c.setMaxAge(60 * 60 * 24);
				}
				if (c.getName().equals("cPw")) {
					c.setMaxAge(60 * 60 * 24);
				}
				if (c.getName().equals("cRemember")) {
					c.setMaxAge(60 * 60 * 24);
				}
			}
		}
		System.out.println("cookie updated");
		return jp.proceed();
	}

	// cookie update and session check
	@Around("execution(public * com.model.beans..*session*(..))")
	public Object Session(ProceedingJoinPoint jp) throws Throwable {

		RequestAttributes rattr = RequestContextHolder.currentRequestAttributes();
		ServletRequestAttributes srattr = (ServletRequestAttributes) rattr; // Has request, response
		HttpServletRequest request = srattr.getRequest();

		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("cEmail")) {
					c.setMaxAge(60 * 60 * 24);
				}
				if (c.getName().equals("cPw")) {
					c.setMaxAge(60 * 60 * 24);
				}
				if (c.getName().equals("cRemember")) {
					c.setMaxAge(60 * 60 * 24);
				}
			}
		}

		HttpSession session = request.getSession();
		Object view = "/login/error";
		if (session.getAttribute("sessionEmail") != null) { // User is allowed to go
			view = jp.proceed();
		} else { // User is not allowed to go
			// Remember original path setting as session
			String pagePath = (String) jp.proceed();
			session.setAttribute("pagePath", pagePath);
		}
		System.out.println("session and cookie updated");
		return view;
	}

}
