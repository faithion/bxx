package com.bxx.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil extends HttpServlet {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public CookieUtil(HttpServletRequest request,HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public String getCookie(String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies==null){
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	public void addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60 * 60 * 24);// 1天的cookie
		response.addCookie(cookie);
	}

	public void deleteCookie(String name) {
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);// cookie时常设为0
		response.addCookie(cookie);
	}
}
