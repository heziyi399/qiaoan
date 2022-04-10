package com.qiaoan_science.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qiaoan_science.Base.ResponseEnum;
import com.qiaoan_science.Base.ResponseResult;
import com.qiaoan_science.pojo.User;
import com.qiaoan_science.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.Subject;

/**
 * @author hzy
 * @date 2022-04-10
 */
@RestController
public class LoginController {
    @Autowired
    private IUserService userService;
    @ApiOperation(value="登录，返回用户的数据")
    @GetMapping("/login")
    @ResponseBody
    public ResponseResult toLogin(@ApiParam(name="userName",value="用户名",required=true)@RequestParam(value = "userName",required = true) String userName,
                                  @ApiParam(name="password",value="密码",required=true)
                                  @RequestParam(value = "password",required = true)String password)
    {
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername,userName).eq(User::getPassword,password));


        //userConditionVo.setBirthDay(DateTimeUtil.dateTime(DateTimeUtil.STANDER_SHORT_FORMAT,nowtime));
        if (user != null)
        {

            return ResponseResult.success(user);}
        else
        {
            return ResponseResult.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR,ResponseEnum.USERNAME_OR_PASSWORD_ERROR.getDesc());
        }
    }

}
