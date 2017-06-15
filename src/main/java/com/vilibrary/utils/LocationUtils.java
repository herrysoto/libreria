package com.vilibrary.utils;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocationUtils extends BaseAction {
	public final void setLocation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Locale loc = new Locale("es", "PE");
		session.setAttribute("org.apache.struts.action.LOCALE", loc);
		MessageResources.message = getResources(request);
	}
	
}
