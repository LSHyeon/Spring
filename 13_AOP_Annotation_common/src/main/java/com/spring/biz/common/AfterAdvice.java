package com.spring.biz.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

//@Aspect, @Pointcut, @After 적용
//allPointcut

@Service
@Aspect
public class AfterAdvice {
	
	@After("PointcutCommon.allPointcut()")
	public void afterLog(JoinPoint jp) {
		  System.out.println("[후처리-AfterAdvice.afterLog]"
		            +"비즈니스 로직 수행 후 로그(언제나,무조건)");
	}
}









