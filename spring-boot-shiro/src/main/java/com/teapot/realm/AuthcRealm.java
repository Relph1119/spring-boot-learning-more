package com.teapot.realm;

import com.teapot.pojo.User;
import com.teapot.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthcRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 认证方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        System.out.println("开始认证：" + userName);
        User user = new User();
        user.setUsername(userName);
        // 根据账号认证
        List<User> list = userService.query(user);
        if (list.isEmpty()) {
            // 账号不存在或者异常
            return null;
        }
        user = list.get(0);
        return new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                new SimpleByteSource(
                        user.getSalt()),
                "authcRealm");
    }

    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        System.out.println("授权账号是：" + user.getUsername());
        // 授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("role1");
        return info;
    }
}
