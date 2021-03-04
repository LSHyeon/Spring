package com.spring.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		//1. 스프링 컨테이너 구동
		GenericXmlApplicationContext container
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. 스프링 컨테이너 사용
		System.out.println("----- 컨테이너 구동 후 -----");
		UserSerivce userSerivce = (UserSerivce)container.getBean("userService");
		
		// 데이터 조회 (1개)
		UserVO vo = new UserVO();
		vo.setId("user1");
		vo.setPassword("user1");
		
		UserVO user = new UserVO();
		user = userSerivce.getUser(vo);
		System.out.println("vo : " + user);
		
		//3. 스프링 컨테이너 종료
		container.close();		
	}

}
































