package com.min.edu.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dtos.MemberDto;
import com.min.edu.model.Login_IService;

@Controller
public class LoginController {

	@Autowired
	Login_IService service;

	// 로그인 페이지로 가는 매핑
	@RequestMapping(value = "/loginPage.do", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
	@RequestParam(value = "logout", required = false) String logout, Model model) {

	if (error != null) {
	model.addAttribute("msg", "로그인 에러");
	}

	if (logout != null) {
	model.addAttribute("msg", "로그아웃 성공");
	}
	return "login";
	}



	//로그인 완료 후 메인 페이지로 가는 매핑
	@RequestMapping(value = "/result.do", method = RequestMethod.POST)
	public String maingo(Authentication user, Model model) {
	UserDetails userdto = (UserDetails) user.getPrincipal();
	model.addAttribute("user", userdto.toString());

	return "main";
	}


	//회원가입으로 가는 매핑
	@RequestMapping(value = "/singUpgo.do", method = RequestMethod.GET)
	public String SignUpgo() {
		return "SignUp";
	}


	// 회원가입 성공 매핑
	@RequestMapping(value = "/singUpSc.do", method = RequestMethod.POST)
	public String maingo(MemberDto dto, Model model) {
		System.out.println("회원가입 정보"+dto.toString());
		service.signUp(dto);
		return "login";
	}

}