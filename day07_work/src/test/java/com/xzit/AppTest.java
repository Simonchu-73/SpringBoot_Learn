package com.xzit;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xzit.enums.StatusEnum;
import com.xzit.model.Account;
import com.xzit.model.Users;
import com.xzit.service.AccountService;
import com.xzit.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;
import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {
    @Resource
    private UserService userService;
    @Resource
    private AccountService accountService;


    @Test
    public void testQuestionA1() {
        Users users = new Users();
        users.setName("张三").setPassword("123456").setStatus(StatusEnum.NO_ACTIVE);
        boolean save = userService.save(users);
        System.out.println(save);

    }

    @Test
    public void testQuestionA1_1() {
        Users users = new Users();
        users.setId(1961717152042012673L);
        users.setPassword("666999");
        boolean b = userService.updateById(users);
        System.out.println(b);
    }

    @Test
    public void testQuestionA2() {
        List<Users> list = userService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void testQuestionA2_1() {
        Users users = new Users();
        users.setId(1961717152042012673L);
        users.setPassword("555666");
        boolean b = users.updateById();

        System.out.println(b);
    }
    @Test

    public void testQuestionB() {
        Account account = accountService.getById(1961728651733090306L);
        account.setBalance(account.getBalance() + 100);
        boolean b = accountService.updateById(account);
    }

}
