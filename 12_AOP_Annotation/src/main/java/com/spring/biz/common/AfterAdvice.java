package com.spring.biz.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Aspect, @Pointcut, @After 적용
//allPointcut

@Service
@Aspect
public class AfterAdvice {
	
	//포인트컷 작성 : 명칭은 메소드명 사용
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {}
		 
	@Pointcut("execution(* com.spring.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	@After("allPointcut()")
	public void afterLog(JoinPoint jp) {
		  System.out.println("[후처리-AfterAdvice.afterLog]"
		            +"비즈니스 로직 수행 후 로그(언제나,무조건)");
	}
}









