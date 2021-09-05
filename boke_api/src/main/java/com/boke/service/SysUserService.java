package com.boke.service;

import com.boke.pojo.SysUser;
import com.boke.vo.Result;
import com.boke.vo.UserVo;

/**
 * @author liyipeng
 * @date 2021-08-15 1:31
 */
public interface SysUserService {

    SysUser findSysUserById(Long authorId);

    SysUser findUser(String account, String pwd);

    Result getUserInfoByToken(String token);

    SysUser findUserByAccount(String account);

    void save(SysUser sysUser);

    UserVo findUserVoById(Long authorId);
}
