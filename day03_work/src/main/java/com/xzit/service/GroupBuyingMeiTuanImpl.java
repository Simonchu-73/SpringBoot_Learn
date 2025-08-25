package com.xzit.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class GroupBuyingMeiTuanImpl implements GroupBuying {
    @Override
    public void buy() {
        System.out.println("生产环境：美团优选买菜");
    }
}
