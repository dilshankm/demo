package com.example.demo;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

public class HelloFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		ContentCachingRequestWrapper conReq = new ContentCachingRequestWrapper(req);
		ContentCachingResponseWrapper conRes = new ContentCachingResponseWrapper(res);
		chain.doFilter(req, res);
		int i = 2;
		if(i!=1) {
			conRes.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		}
		conRes.copyBodyToResponse();
	}

}
