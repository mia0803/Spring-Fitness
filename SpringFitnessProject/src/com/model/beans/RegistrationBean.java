package com.model.beans;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.dtogroups.MemberDTO;
import com.model.dtogroups.PaymentDTO;
import com.model.dtogroups.TransactionDTO;
import com.model.service.ClubService;
import com.model.service.MemberService;
import com.model.service.PaymentService;
import com.model.service.TransactionService;

@Controller
@RequestMapping("/registration")
public class RegistrationBean {

	@Autowired
	ClubService clubDAO = null;

	@Autowired
	MemberService memberDAO = null;

	@Autowired
	TransactionService transactionDAO = null;

	@Autowired
	PaymentService paymentDAO = null;

	@RequestMapping("/registration1")
	public String registration1(HttpServletRequest request, HttpSession session, Model m) throws Exception {

		String changeMembership = request.getParameter("changeMembership");

		if (changeMembership != null) {
			session.setAttribute("changeMembership", changeMembership);
		}

		List clubs = clubDAO.getAllClubs();

		m.addAttribute("clubs", clubs);

		return "/registration/registration1";
	}

	@RequestMapping("/registration2")
	public String registration2(HttpServletRequest request, Model m) {

		String club = request.getParameter("club");
		String location = request.getParameter("location");
		m.addAttribute("club", club);
		m.addAttribute("location", location);

		return "/registration/registration2";
	}

	@RequestMapping("/registration3")
	public String registration3(HttpServletRequest request, HttpServletResponse response, Model m, HttpSession session)
			throws IOException {

		String club = request.getParameter("club");
		String location = request.getParameter("location");
		String membership = request.getParameter("membership");
		String payment = null;

		if (membership.equals("one")) {
			payment = request.getParameter("monthly-payment1");
		} else {
			payment = request.getParameter("monthly-payment2");
		}

		String returnPage = "/registration/registration3";

		session.setAttribute("club", club);
		session.setAttribute("location", location);
		session.setAttribute("membership", membership);
		session.setAttribute("payment", payment);

		String changeMembership = (String) session.getAttribute("changeMembership");
		if (changeMembership != null) {
			returnPage = "/registration/registrationPro";
		}

		return returnPage;
	}

	@RequestMapping("/registration4")
	public String cookie_registration4(HttpSession session, HttpServletRequest request, MemberDTO dto, Model m)
			throws Exception {
		// New member adding process, payment info page parameters

		Calendar cal = Calendar.getInstance();
		String month = new SimpleDateFormat("MMMM").format(cal.getTime());
		String year = new SimpleDateFormat("YYYY").format(cal.getTime());
		m.addAttribute("month", month);
		m.addAttribute("year", year);

		String sessionEmail = (String) session.getAttribute("sessionEmail");
		String newEmail = dto.getEmail();

		String membership = null;
		String club = null;
		String location = null;
		int finalPayment = 0;
		int membershipPayment = 0;
		String fname = null;
		String lname = null;

		if (sessionEmail == null && newEmail != null) { // New member with regular process
			// Received 5 parameters fname, lname, email, pw, phone
			// Session club, location, membership, payment, notPaid, sessionEmail

			String temp = (String) session.getAttribute("payment");
			membershipPayment = Integer.parseInt(temp.substring(1, 4));
			finalPayment = membershipPayment + 100;
			m.addAttribute("membershipPayment", membershipPayment);
			session.setAttribute("finalPayment", finalPayment);

			session.setAttribute("newEmail", newEmail);

			m.addAttribute("fname", dto.getFname());
			m.addAttribute("lname", dto.getLname());

			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			MemberDTO dto1 = memberDAO.emailValidation(email);
			MemberDTO dto2 = memberDAO.phoneValidation(phone);

			if (dto1 == null && dto2 == null) {
				// Add new member
				dto.setMembership((String) session.getAttribute("membership"));
				dto.setPayment((String) session.getAttribute("payment"));
				dto.setLocation((String) session.getAttribute("location"));
				dto.setClub((String) session.getAttribute("club"));
				memberDAO.addMember(dto);
			} else {
				m.addAttribute("duplicate", "yes");
			}

		} else if (sessionEmail != null && newEmail == null) { // Pay later member
			MemberDTO mdto = memberDAO.getMember(sessionEmail);
			membership = mdto.getMembership();
			location = mdto.getLocation();
			club = mdto.getClub();
			String temp = mdto.getPayment();
			membershipPayment = Integer.parseInt(temp.substring(1, 4));
			finalPayment = membershipPayment + 100;
			fname = mdto.getFname();
			lname = mdto.getLname();

			session.setAttribute("membership", membership);
			m.addAttribute("location", location);
			m.addAttribute("club", club);
			m.addAttribute("membershipPayment", membershipPayment);
			session.setAttribute("finalPayment", finalPayment);
			m.addAttribute("fname", fname);
			m.addAttribute("lname", lname);

		}

		return "/registration/registration4";
	}

	@RequestMapping("/registrationPro")
	public String registrationPro(HttpServletRequest request, HttpSession session, Model m, PaymentDTO dto)
			throws Exception {
		// Add Payment info, Transaction

		String changeMembership = (String) session.getAttribute("changeMembership");
		String sessionEmail = (String) session.getAttribute("sessionEmail");
		String newEmail = (String) session.getAttribute("newEamil");
		String membership = (String) session.getAttribute("membership");
		int finalPayment = (int) session.getAttribute("finalPayment");

		Calendar cal = Calendar.getInstance();
		String month = new SimpleDateFormat("MMMM").format(cal.getTime());

		TransactionDTO tdto = new TransactionDTO();

		if (sessionEmail == null && changeMembership == null) { // New member payment

			MemberDTO mdto = memberDAO.getMember(newEmail);
			int memId = mdto.getId();

			// Add Payment info
			dto.setMember_id(memId);
			paymentDAO.addInfo(dto);

			// Add Transaction
			int paymentId = paymentDAO.getId(memId);
			tdto.setMember_id(memId);
			tdto.setPayment_info_id(paymentId);
			tdto.setMembership(membership);
			tdto.setAmount("$" + finalPayment + ".00");
			tdto.setTitle(month + " payment");
			tdto.setInitiation_fee(1);
			transactionDAO.addTransaction(tdto);

		} else if (sessionEmail != null && changeMembership == null) { // Pay later member

			MemberDTO existMdto = memberDAO.getMember(sessionEmail);
			int existMemId = existMdto.getId();

			// Add Payment info
			dto.setMember_id(existMemId);
			paymentDAO.addInfo(dto);

			// Add Transaction
			int paymentId = paymentDAO.getId(existMemId);
			tdto.setMember_id(existMemId);
			tdto.setPayment_info_id(paymentId);
			tdto.setMembership(membership);
			tdto.setAmount("$" + finalPayment + ".00");
			tdto.setTitle(month + " payment");
			tdto.setInitiation_fee(1);
			transactionDAO.addTransaction(tdto);

		} else if (sessionEmail != null && changeMembership != null) { // Membership change

			MemberDTO existMdto = memberDAO.getMember(sessionEmail);
			int existMemId = existMdto.getId();
			String payment = (String) session.getAttribute("payment");
			String location = (String) session.getAttribute("location");
			String club = (String) session.getAttribute("club");

			// Change membership in members table
			existMdto.setMembership(membership);
			existMdto.setClub(club);
			existMdto.setLocation(location);
			existMdto.setPayment(payment);
			memberDAO.updateMemberMembership(existMdto);

			// Add new transaction
			int paymentId = paymentDAO.getId(existMemId);
			tdto.setMember_id(existMemId);
			tdto.setPayment_info_id(paymentId);
			tdto.setMembership(membership);
			tdto.setAmount("$" + finalPayment + ".00");
			tdto.setTitle(month + " payment");
			tdto.setInitiation_fee(0);
			transactionDAO.addTransaction(tdto);

		}

		m.addAttribute("changeMembership", "1");
		session.removeAttribute("changeMembership");
		session.removeAttribute("finalPayment");
		session.removeAttribute("membership");
		session.removeAttribute("payment");
		session.removeAttribute("location");
		session.removeAttribute("club");
		session.removeAttribute("notPaid");

		String pagePath = (String) session.getAttribute("pagePath");
		m.addAttribute("pagePath", pagePath);
		session.removeAttribute("pagePath");

		return "/registration/registrationPro";
	}

	@RequestMapping("/emailValidation")
	public String emailValidation(HttpServletRequest request, Model m) throws Exception {

		String email = request.getParameter("email");
		MemberDTO dto = memberDAO.emailValidation(email);

		String comment = null;
		String check = "false";

		if (dto != null) { // Email exists
			comment = "! Invalid email. Please use other one.";
		} else { // Email is available
			comment = "The email is available to use.";
			check = "true";
		}

		m.addAttribute("comment", comment);
		m.addAttribute("check", check);

		return "/registration/emailValidation";
	}

}
