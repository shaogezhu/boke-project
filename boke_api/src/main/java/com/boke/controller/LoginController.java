package com.boke.controller;

import com.boke.service.LoginService;
import com.boke.utils.UserThreadLocal;
import com.boke.vo.ErrorCode;
import com.boke.vo.Result;
import com.boke.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liyipeng
 * @date 2021-08-15 12:07
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public Result login(@RequestBody LoginParam loginParam) {
        return loginService.login(loginParam);
    }

    @GetMapping("logout")
    public Result longout(@RequestHeader("Authorization") String token) {
        boolean loginout = loginService.loginout(token);
        if (loginout) {
            return Result.success("退出登录成功");
        } else {
            return Result.fail(ErrorCode.NO_LOGIN.getCode(), ErrorCode.NO_LOGIN.getMsg());
        }
    }

    @GetMapping("test")
    public Result test() {
        System.out.println(UserThreadLocal.get().toString());
        return Result.success("访问test成功");
    }

}
