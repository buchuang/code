package com.nyist.microserviceconsumermovie;


import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AddRequestHeaderFilter extends ZuulFilter {
	
	private static final Logger logger=LoggerFactory.getLogger(AddRequestHeaderFilter.class);
	
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
    	HttpServletRequest request = context.getRequest();
    	String host=request.getRemoteHost();
    	logger.info("请求的host:"+host);
		return null;
	}
}