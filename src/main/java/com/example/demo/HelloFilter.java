package com.example.demo;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
public class HelloFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		ContentCachingRequestWrapper conReq = new ContentCachingRequestWrapper(req);
		ContentCachingResponseWrapper conRes = new ContentCachingResponseWrapper(res);
		
		int i = 2;
		if(i!=1) {
			Map m =(Map) req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
			System.out.println("yooo");
			System.out.println(m.get("hello"));
			conRes.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		}
		chain.doFilter(req, res);
		conRes.copyBodyToResponse();
	}

}
