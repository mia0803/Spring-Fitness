package com.model.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.dtogroups.CommentDTO;
import com.model.dtogroups.PostDTO;
import com.model.service.CommentService;
import com.model.service.PostService;

@Controller
@RequestMapping("/community")
public class MessageBoardBean {

	@Autowired
	PostService postDAO = null;

	@Autowired
	CommentService commentDAO = null;

	@RequestMapping("/messageBoard")
	public String cookie_messageBoard(HttpServletRequest request, Model m) throws Exception {

		// ======== developer customizable ========

		int buttons_on_page = 5;
		int posts_on_page = 5;

		// ========================================

		String searchContent = request.getParameter("search");

		String s_current_page = request.getParameter("current_page");
		int current_page = 1;
		if (s_current_page != null) {
			current_page = Integer.parseInt(s_current_page);
		}

		int start = (current_page - 1) * posts_on_page + 1;
		int end = current_page * posts_on_page;
		int total_posts = 0;

		if (searchContent != null) {
			total_posts = postDAO.getCountOfSearch(searchContent);
		} else {
			total_posts = postDAO.getCount();
		}

		int total_page = 1;
		if (total_posts > posts_on_page) {
			if (total_posts % posts_on_page == 0) {
				total_page = total_posts / posts_on_page;
			} else {
				total_page = total_posts / posts_on_page + 1;
			}
		}

		int totalBtnBox = 1;
		if (total_page > buttons_on_page) {
			if (total_page % buttons_on_page == 0) {
				totalBtnBox = total_page / buttons_on_page;
			} else {
				totalBtnBox = total_page / buttons_on_page + 1;
			}
		}

		int currentBtnBox = 1;
		if (current_page > buttons_on_page) {
			if (current_page % buttons_on_page == 0) {
				currentBtnBox = current_page / buttons_on_page;
			} else {
				currentBtnBox = current_page / buttons_on_page + 1;
			}
		}

		PostDTO dto = new PostDTO();
		dto.setStart_num(start);
		dto.setEnd_num(end);
		dto.setContent(searchContent);

		ArrayList<Object> posts = null;
		if (searchContent != null) {
			posts = postDAO.getPostsOfSearch(dto);
		} else {
			posts = postDAO.getAllPosts(dto);
		}

		ArrayList<Integer> post_comment_counts = new ArrayList<Integer>();
		List dateList = new ArrayList();

		for (Object post : posts) {
			int post_comment = commentDAO.getCommentCount(((PostDTO) post).getId());
			post_comment_counts.add(post_comment);

			Date postDate = ((PostDTO) post).getPost_date();
			String simpleDate = new SimpleDateFormat("MMM d").format(postDate);
			dateList.add(simpleDate);
		}

		m.addAttribute("searchContent", searchContent);
		m.addAttribute("buttons_on_page", buttons_on_page);
		m.addAttribute("posts_on_page", posts_on_page);
		m.addAttribute("current_page", current_page);
		m.addAttribute("total_page", total_page);
		m.addAttribute("totalBtnBox", totalBtnBox);
		m.addAttribute("currentBtnBox", currentBtnBox);
		m.addAttribute("posts", posts);
		m.addAttribute("dateList", dateList);
		m.addAttribute("post_comment_counts", post_comment_counts);

		return "/messageBoard/messageBoard";
	}

	@RequestMapping("editContent")
	public String cookie_editContent(HttpServletRequest request, Model m) throws Exception {

		String post_sid = request.getParameter("post_id");
		String returnPage = "/messageBoard/editContent";

		if (post_sid == null) {
			returnPage = "/messageBoard/messageBoard";
		}

		int post_id = Integer.parseInt(post_sid);

		postDAO.upView(post_id);

		PostDTO post = postDAO.getPost(post_id);

		List comments = commentDAO.getComment(post_id);

		List dateList = new ArrayList();

		for (Object comment : comments) {

			Date commentDate = ((CommentDTO) comment).getComment_date();
			String simpleDate = new SimpleDateFormat("MMM d, yyyy").format(commentDate);
			dateList.add(simpleDate);
		}

		m.addAttribute("post", post);
		m.addAttribute("comments", comments);
		m.addAttribute("dateList", dateList);

		return returnPage;
	}

	@RequestMapping("commentPro")
	public String session_commentPro(CommentDTO dto, HttpServletRequest request, Model m) throws Exception {

		String action = request.getParameter("action");

		if (action.equals("comment")) {
			commentDAO.addComment(dto);

		} else if (action.equals("reply")) {
			commentDAO.addReply(dto);
		}

		m.addAttribute("action", action);
		m.addAttribute("post_id", dto.getPost_id());

		return "/messageBoard/commentPro";
	}

	@RequestMapping("commentDeletePro")
	public String session_commentDeletePro(HttpServletRequest request, Model m) throws Exception {

		String comment_sid = request.getParameter("comment_id");
		String post_id = request.getParameter("post_id");

		if (comment_sid != null) {
			int comment_id = Integer.parseInt(comment_sid);
			commentDAO.delete(comment_id);
		}

		m.addAttribute("comment_sid", comment_sid);
		m.addAttribute("post_id", post_id);

		return "/messageBoard/commentDeletePro";
	}

	@RequestMapping("postDeletePro")
	public String session_postDeletePro(HttpServletRequest request, Model m) throws Exception {

		String post_sid = request.getParameter("post_id");

		if (post_sid != null) {
			int post_id = Integer.parseInt(post_sid);
			postDAO.deletePost(post_id);
		}

		m.addAttribute("post_sid", post_sid);

		return "/messageBoard/postDeletePro";
	}

	@RequestMapping("updatePostPro")
	public String session_updatePostPro(PostDTO dto, Model m) throws Exception {

		postDAO.updatePost(dto);

		m.addAttribute("dto", dto);

		return "/messageBoard/updatePostPro";
	}

	@RequestMapping("writePost")
	public String session_writePost() throws Exception {

		return "/messageBoard/writePost";
	}

	@RequestMapping("writePostPro")
	public String session_writePostPro(PostDTO dto) throws Exception {

		postDAO.addPost(dto);

		return "/messageBoard/writePostPro";
	}

}
