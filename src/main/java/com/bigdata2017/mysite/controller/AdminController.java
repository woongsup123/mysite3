package com.bigdata2017.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata2017.security.Auth;

@Controller
@Auth(role=Auth.Role.ADMIN)
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping({"", "/main"})
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping("/guestbook")
	public String guestbook() {
		
		return "admin/guestbook";
	}
	@RequestMapping("/board")
	public String board() {
		
		return "admin/board";
	}
}
