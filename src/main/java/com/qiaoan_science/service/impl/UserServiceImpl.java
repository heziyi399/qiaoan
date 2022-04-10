package com.qiaoan_science.service.impl;

import com.qiaoan_science.pojo.User;
import com.qiaoan_science.mapper.UserMapper;
import com.qiaoan_science.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzy
 * @since 2022-04-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
