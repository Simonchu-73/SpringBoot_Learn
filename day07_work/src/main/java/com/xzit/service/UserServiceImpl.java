package com.xzit.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzit.mapper.UsersMapper;
import com.xzit.model.Users;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UsersMapper, Users>  implements UserService {
}
