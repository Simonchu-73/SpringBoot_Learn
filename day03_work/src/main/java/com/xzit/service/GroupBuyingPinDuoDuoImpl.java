package com.xzit.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class GroupBuyingPinDuoDuoImpl implements GroupBuying {
    @Override
    public void buy() {
        System.out.println("测试环境：拼多多买菜");
    }
}
