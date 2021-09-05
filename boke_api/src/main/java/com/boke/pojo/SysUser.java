package com.boke.pojo;

import lombok.Data;

/**
 * @author liyipeng
 * @date 2021-08-15 0:55
 * 用户信息表对应的pojo
 */
@Data
public class SysUser {

    private Long id;

    private String account;

    private Integer admin;

    private String avatar;

    private Long createDate;

    private Integer deleted;

    private String email;

    private Long lastLogin;

    private String mobilePhoneNumber;

    private String nickname;

    private String password;

    private String salt;

    private String status;
}
