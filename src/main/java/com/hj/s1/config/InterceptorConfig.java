package com.hj.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hj.s1.interceptor.LoginChkInterceptor;
import com.hj.s1.interceptor.WriterChkInterceptor;

@Component
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	private LoginChkInterceptor loginChkInterceptor;
	@Autowired
	private WriterChkInterceptor writerChkInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginChkInterceptor)
		.addPathPatterns("/qna/*")
		.excludePathPatterns("/qna/qnaList")
		.excludePathPatterns("/qna/qnaSelect");	
		
		registry.addInterceptor(writerChkInterceptor)
		.addPathPatterns("/qna/qnaUpdate")
		.addPathPatterns("/qna/qnaDelete");
	}
	
}
