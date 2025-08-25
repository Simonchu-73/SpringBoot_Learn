package com.xzit.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class GroupBuyingChengXinImpl implements GroupBuying {
    @Override
    public void buy() {
        System.out.println("开发环境：橙心优选买菜");
    }
}
