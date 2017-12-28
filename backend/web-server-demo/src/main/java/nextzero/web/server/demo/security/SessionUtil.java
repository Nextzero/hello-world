package nextzero.web.server.demo.security;

import nextzero.web.server.demo.entity.domain.UserCredentials;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;


public class SessionUtil {
	public static final int SESSION_TIMEOUT = 20 * 60;// session失效时间，单位秒
    public static final String KEY_USER = "KEY_USER";
    public static final String KEY_REQUEST_TIME = "KEY_REQUEST_TIME";

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	// 设置当前登录用户
	public static void setCurUser(UserCredentials user) {
		if (user != null) {
			refreshSessionTime();
			user.setPassword("*");
		}
		SecurityUtils.getSubject().getSession(true).setAttribute(KEY_USER, user);
	}

	// 获取当前登录用户
	public static UserCredentials getCurUser() {
		return (UserCredentials) SecurityUtils.getSubject().getSession(true).getAttribute(KEY_USER);
	}

	// 判断是否登录
	public static boolean isLogin() {
		UserCredentials user = getCurUser();
		return user != null && user.getId() != null && user.getId() != 0;
	}

	// 新Session请求时间
	public static void refreshSessionTime() {
		SecurityUtils.getSubject().getSession(true).setAttribute(KEY_REQUEST_TIME, System.currentTimeMillis());
	}

	// session是否已经过期
	public static boolean isSessionTimeout() {
		Long requestTimer = (Long) SecurityUtils.getSubject().getSession(true).getAttribute(KEY_REQUEST_TIME);
		if (requestTimer == null) {
			return true;
		}
		return requestTimer < System.currentTimeMillis() - SESSION_TIMEOUT * 1000;
	}
}
