package com.example.demo.aop;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAOPHelper {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void RequestMapping() {}
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void GetMapping() {}
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	public void PostMapping() {}
	
	
	@Before("RequestMapping()")
	public void beforeRequest(JoinPoint joinPoint) {
		System.out.println("[RequestMapping]" + joinPoint.getSignature().toShortString());
		
		Object [] paraValues = joinPoint.getArgs();
		
		StringBuilder values = new StringBuilder();
		values.append("[RequestMapping]" + joinPoint.getSignature().toShortString() + "\n");
		for (int i = 0; i < paraValues.length; i++) {
			values.append("methodName");
			for (int j = 0; j < paraValues.length; j++) {
				values.append(",attr"+j);
			}
			values.append("\n"+joinPoint.getSignature().toShortString() + ", ");
			for (int k = 0; k < paraValues.length; k++) {
				if (paraValues[k] instanceof HttpServletRequest) {
					values.append("HttpServletRequest, ");
				} else {
					values.append(paraValues[k].toString() + ", ");
				}
			}
			values.append("\n");
		}
		log.info(values.toString());
	}

	@Before("GetMapping()")
	public void beforeGet(JoinPoint joinPoint) {
		System.out.println("[GetMapping]" + joinPoint.getSignature().toShortString());

		Object [] paraValues = joinPoint.getArgs();
		
		StringBuilder values = new StringBuilder();
		values.append("[RequestMapping]" + joinPoint.getSignature().toShortString() + "\n");
		for (int i = 0; i < paraValues.length; i++) {
			values.append("methodName");
			for (int j = 0; j < paraValues.length; j++) {
				values.append(",attr"+j);
			}
			values.append("\n"+joinPoint.getSignature().toShortString() + ", ");
			for (int k = 0; k < paraValues.length; k++) {
				if (paraValues[k] instanceof HttpServletRequest) {
					values.append("HttpServletRequest, ");
				} else {
					values.append(paraValues[k].toString() + ", ");
				}
			}
			values.append("\n");
		}
		log.info(values.toString());
	}
	
	@Before("PostMapping()")
	public void beforePost(JoinPoint joinPoint) {
		System.out.println("[PostMapping]" + joinPoint.getSignature().toShortString());

		Object [] paraValues = joinPoint.getArgs();
		
		StringBuilder values = new StringBuilder();
		values.append("[RequestMapping]" + joinPoint.getSignature().toShortString() + "\n");
		for (int i = 0; i < paraValues.length; i++) {
			values.append("methodName");
			for (int j = 0; j < paraValues.length; j++) {
				values.append(",attr"+j);
			}
			values.append("\n"+joinPoint.getSignature().toShortString() + ", ");
			for (int k = 0; k < paraValues.length; k++) {
				if (paraValues[k] instanceof HttpServletRequest) {
					values.append("HttpServletRequest, ");
				} else {
					values.append(paraValues[k].toString() + ", ");
				}
			}
			values.append("\n");
		}
		log.info(values.toString());
	}
}
