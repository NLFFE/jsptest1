package com.edu.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie1")
public class CookieTest1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cnt = 0;
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		Cookie[] list = req.getCookies();
		for(Cookie item : list) {
			if(item.getName().equals("count")) {
				cnt = Integer.parseInt(item.getValue());
			}
		}
		cnt++;
		Cookie c = new Cookie("count",cnt+"");
		c.setMaxAge(60 * 60 *3);
		resp.addCookie(c);
		
		out.print("¹æ¹®È½¼ö"+cnt);
		out.close();
	}
}
