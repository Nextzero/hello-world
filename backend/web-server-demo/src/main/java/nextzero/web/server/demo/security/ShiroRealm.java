/*
 * Copyright (c) 2012 by XUANWU INFORMATION TECHNOLOGY CO. 
 *             All rights reserved                         
 */
package nextzero.web.server.demo.security;

import nextzero.web.server.demo.entity.domain.UserCredentials;
import nextzero.web.server.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class ShiroRealm extends AuthorizingRealm {
	public static final Logger LOG = LoggerFactory.getLogger(ShiroRealm.class);

	@Autowired
	private UserService userService;

	/**
	 * 当调用subject.login(...)时，将通过该方法进行登陆信息验证。
	 * 若验证失败，可通过抛出异常中止流程，
	 * 也可将数据库中的账号密码返回，由shiro进行匹配。
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		SecurityUtils.getSubject().logout();// 覆盖登录

		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		String username = upToken.getUsername();
		if (StringUtils.isBlank(username)) {
			throw new UnknownAccountException("UserName is blank:[" + username + "]");
		}

		UserCredentials user = userService.getUserCredentials(username);
		if (user == null) {
			throw new UnknownAccountException("Can't find user by name:" + username);
		}
		if (user.getStatus() != 0) {
			throw new DisabledAccountException("The user is locked by name:" + username);
		}

		String password = user.getPassword();
		SessionUtil.setCurUser(user);
		AuthenticationInfo info = new SimpleAuthenticationInfo(username, password.toCharArray(), getName());
		return info;
	}


	/**
	 *
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
			throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
		}
		UserCredentials user = SessionUtil.getCurUser();
		String username = null;
		if (null != user) {
			username = user.getUsername();
		}else{
			username = (String) getAvailablePrincipal(principals);
		}

		if(null == username){
			LOG.error("user is null");
			throw new AuthorizationException("user is null");
		}

		Set<String> permissions = new HashSet<String>();
		List<String> userUrlPermissions = userService.getUserUrlPermissions(username);
		permissions.addAll(userUrlPermissions);

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permissions);
		return info;
	}
}
