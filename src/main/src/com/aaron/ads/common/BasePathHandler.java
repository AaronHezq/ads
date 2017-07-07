package com.aaron.ads.common;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasePathHandler extends Handler {

	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		String contextPath=request.getContextPath();
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
		request.setAttribute("basepath", basePath);
		next.handle(target, request, response, isHandled);
	}

}
