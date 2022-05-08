package com.min.edu.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.dtos.MemberDto;

@Repository
public class Login_DaoImpl implements Login_IDao{

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.min.login.";
	
	
	
	@Override
	public MemberDto loginChk(String id) {
		return session.selectOne(NS+"loginChk", id);
	}

	@Override
	public boolean signUp(MemberDto dto) {
		String enPw = passwordEncoder.encode(dto.getPw());
		dto.setPw(enPw);

		return session.insert(NS+"signUp", dto) > 0 ? true : false;
	}

}
