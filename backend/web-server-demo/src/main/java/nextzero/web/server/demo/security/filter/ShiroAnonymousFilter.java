package nextzero.web.server.demo.security.filter;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.AnonymousFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShiroAnonymousFilter extends AnonymousFilter {

	@Override
	protected boolean preHandle(ServletRequest req, ServletResponse resp) throws Exception {
		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hresp = (HttpServletResponse) resp;

		String url = hreq.getPathInfo();
		if (StringUtils.isBlank(url)) {
			url = hreq.getServletPath();
		}
		if(!url.startsWith("/publics/")) {
			hresp.setHeader("Access-State", "unlogin");
		}
		return true;
	}

}
