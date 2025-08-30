package com.xzit.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzit.mapper.AccountMapper;
import com.xzit.model.Account;
import org.springframework.stereotype.Service;

@Service
@DS("slave")
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
}
