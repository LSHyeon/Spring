package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;

@Repository
public class UserDAOString {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	public UserDAOString() {
		System.out.println(">> UserDAOString() 객체 생성");
	}
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> String - getUser() 실행");
		String sql = USER_GET;
		Object[] args = { vo.getId(), vo.getPassword() };
		
		return jdbcTemplate.queryForObject(sql, args, new UserRowMapper());
	}
}









