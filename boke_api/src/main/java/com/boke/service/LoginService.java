package com.boke.service;

import com.boke.pojo.SysUser;
import com.boke.vo.Result;
import com.boke.vo.params.LoginParam;

/**
 * @author liyipeng
 * @date 2021-08-15 12:16
 */
public interface LoginService {
    Result login(LoginParam loginParam);

    boolean loginout(String token);

    Result register(LoginParam loginParam);

    SysUser checkToken(String token);

}
