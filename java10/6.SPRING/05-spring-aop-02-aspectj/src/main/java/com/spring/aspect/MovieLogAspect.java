package com.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MovieLogAspect {
	private java.util.logging.Logger logger=java.util.logging.Logger.getLogger(getClass().getName());
	// class with with @Aspect consists Advice and PointCut
	
	// execution(* *(..))
		// execution(* com.spring.service.*.*(..))
		// execution(private * com.spring.service.*.*(..))
		// execution(* com.spring.service.MovieService.*(..))
		// execution(* com.spring.service.MovieService.addMovie(..))
		// execution(* com.spring.service.MovieService.update*(..))"
		// execution(* com.spring.service.MovieService.*Movie(..))
		
	//@Before("execution(* com.spring.service.MovieService.*(..))")
	@Pointcut("execution(* com.spring.service.*.*(..))")
	public void movieServicePointcut() {};
	@Before("movieServicePointcut()") // type class function param
	public void forMovieService(JoinPoint joinPoint) {
		String methodName=joinPoint.getSignature().getName();
		logger.info(">>> Add Log before MovieService methods "+methodName);
	}
	@Before("movieServicePointcut()")
	public void forAnalyseService(JoinPoint joinPoint) {
		String methodName=joinPoint.getSignature().getName();
		logger.info(">>> Add Log for Analysing  "+methodName);
	}
	private static void LOG(String text) {
		System.out.println(text);
		
	}
	
}
