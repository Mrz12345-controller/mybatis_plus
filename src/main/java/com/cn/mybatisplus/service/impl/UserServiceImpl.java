package com.cn.mybatisplus.service.impl;

import com.cn.mybatisplus.pojo.User;
import com.cn.mybatisplus.mapper.UserMapper;
import com.cn.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zmy
 * @since 2020-08-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
