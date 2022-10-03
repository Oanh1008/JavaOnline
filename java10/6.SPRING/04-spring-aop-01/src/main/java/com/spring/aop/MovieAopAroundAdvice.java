package com.spring.aop;

import org.aopalliance.intercept.MethodInvocation;

//step2: create advice
public class MovieAopAroundAdvice implements org.aopalliance.intercept.MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invoked) throws Throwable {
		try {
			// advice before
			LOG("****  before >>  ....."+invoked.getMethod().getName());
			Object rs= invoked.proceed();
			// advice after
			LOG("****  after >>  ....."+rs);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	private static void LOG(String text) {
		System.out.println(text);
	}

	

	

}
