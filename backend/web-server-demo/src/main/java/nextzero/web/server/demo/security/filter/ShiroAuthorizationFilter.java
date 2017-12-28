package nextzero.web.server.demo.security.filter;

import nextzero.web.server.demo.security.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShiroAuthorizationFilter extends AuthorizationFilter {
	private static Logger LOG = LoggerFactory.getLogger(ShiroAuthorizationFilter.class);

	@Override
	protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
		Subject subject = SecurityUtils.getSubject();

		boolean isPermitted = false;
		boolean isAuthenticated = subject.isAuthenticated();
		boolean isSessionTimeout = SessionUtil.isSessionTimeout();

		if (isAuthenticated && !isSessionTimeout) {
			//提取访问当前URL
			String url = httpServletRequest.getPathInfo();
			if (StringUtils.isBlank(url)) {
				url = httpServletRequest.getServletPath();
			}
			if (StringUtils.isBlank(url)) {
				LOG.error("url is black");
				return false;
			}

			//判断当前用户是否有权限访问url
			isPermitted = subject.isPermitted(url);
			if (!isPermitted) {
				httpServletRequest
						.getRequestDispatcher("/reject/unauthorization")
						.forward(httpServletRequest,httpServletResponse);
			}else{
				//刷新会话时间
				SessionUtil.refreshSessionTime();
			}
		} else {
			httpServletRequest
					.getRequestDispatcher("/reject/unlogin")
					.forward(httpServletRequest,httpServletResponse);
		}
		return isPermitted;
	}

}
