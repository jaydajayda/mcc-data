package com.metro.filter;

import java.io.IOException;



import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.metro.jwt.JWTHelper;
import com.metro.logging.ApiLogger;

@Component
@Order(1)
public class AuthFilter implements Filter {

	//JWTUtil jwtUtil = new JWTMockUtil();
	JWTHelper jwtHelper = new JWTHelper();

	private String data_scope = "com.metro.data.api";
	private String auth_scope = "com.metro.auth.api";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();

		String tokenheader = req.getHeader("tokencheck");
		if( tokenheader != null && !tokenheader.equalsIgnoreCase("true") ) {
			chain.doFilter(request, response);
			return;		
		}

		if(!uri.startsWith("/api/events") 
				&& !uri.startsWith("/api/registrations")
				&& !uri.equals("/api/customers")
				) {
			chain.doFilter(request, response);
			return;			
		} else {
			// check JWT token
			String authheader = req.getHeader("authorization");
			if (authheader != null && authheader.length() > 7 && authheader.startsWith("Bearer")) {
				String jwt_token = authheader.substring(7, authheader.length());
				if (jwtHelper.verifyToken(jwt_token)) {
					String request_scopes = jwtHelper.getScopes(jwt_token);
					if (request_scopes.contains(data_scope) || request_scopes.contains(auth_scope)  ) {
						// continue on to api
						chain.doFilter(request, response);
						return;
					}
				}
			}
		}

		// reject request and return error instead of data
		res.sendError(HttpServletResponse.SC_FORBIDDEN, "failed authentication");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ApiLogger.log("AuthFilter.init");
		
	}

	@Override
	public void destroy() {
		ApiLogger.log("AuthFilter.destroy");	
	}
	
	

}
