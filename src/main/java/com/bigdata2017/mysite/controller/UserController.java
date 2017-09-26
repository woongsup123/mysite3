package com.bigdata2017.mysite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigdata2017.mysite.service.UserService;
import com.bigdata2017.mysite.vo.UserVo;
import com.bigdata2017.security.Auth;
import com.bigdata2017.security.AuthUser;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(@ModelAttribute UserVo userVo) {
		return "user/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo userVo,
						BindingResult result) {
		
		if(result.hasErrors()) {
			/*List<ObjectError> list = result.getAllErrors();
			
			for (ObjectError error : list) {
				System.out.println("Object Error" + error);
			}*/
			return "user/join";
		}
		
		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}

	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "user/joinsuccess";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("ttttttttttttttttttttttttttttt");
		return "user/login";
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session,
			@RequestParam(value = "email", required = true, defaultValue = "") String email,
			@RequestParam(value = "password", required = true, defaultValue = "") String password) {
		UserVo userVo = userService.getUser(email, password);
		if (userVo == null) {
			return "user/login_fail";
		}

		// session 처리
		session.setAttribute("authUser", userVo);
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout( HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}*/
	
	@Auth(role=Auth.Role.USER)
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@AuthUser UserVo authUser, Model model) {
		UserVo userVo = userService.getUser(authUser.getNo());
		model.addAttribute("userVo", userVo);
		return "user/modify";
	}
	
	@Auth(role=Auth.Role.USER)
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(@AuthUser UserVo authUser, @ModelAttribute UserVo userVo) {
		userVo.setNo(authUser.getNo());
		userService.modifyUser(userVo);
		
		//authUser 변경(화면변경)
		authUser.setName(userVo.getName());
		
		return "redirect:/user/modify?update=success";
	}
	
}
