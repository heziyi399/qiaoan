package com.qiaoan_science.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qiaoan_science.Base.ResponseEnum;
import com.qiaoan_science.Base.ResponseResult;
import com.qiaoan_science.pojo.User;
import com.qiaoan_science.service.IUserService;
import com.qiaoan_science.service.impl.UserServiceImpl;
import com.qiaoan_science.vo.UserConditionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.Date;

/**
 * @author hzy
 * @date 2022-04-10
 */
@Api(tags = {"登录接口"})
@RestController
public class LoginController {
    @Autowired
    private UserServiceImpl userService;
    @ApiOperation(value="登录，输入用户名和密码")
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
    @PostMapping("/adduser")
    @ApiOperation(value="注册新用户")
    @ResponseBody
    public ResponseResult insert(@RequestBody UserConditionVo user)
    {
User dataUser = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername,user.getUsername()));
if(dataUser != null)
{
    return ResponseResult.error("用户名已存在！");
}
        User user1 = new User();
  user1.setUsername(user.getUsername());
  user1.setPassword(user.getPassword());
  user1.setRole("manager");

        if( userService.save(user1))
        {
            return ResponseResult.success("ok");
        }
        else{
            return ResponseResult.error("fail");
        }
    }

}
