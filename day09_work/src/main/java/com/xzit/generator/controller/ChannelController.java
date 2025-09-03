package com.xzit.generator.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzit.generator.entity.Channel;
import com.xzit.generator.service.IChannelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author SimonChu
 * @since 2025-09-03
 */
@Controller
@RequestMapping("/generator/channel")
public class ChannelController {
    @Resource
    private IChannelService service;

    @GetMapping("/save")
    public String save() {
        return "/save";
    }

    @PostMapping("/save_commit")
    public String save_commit(Channel channel) {
        service.save(channel);
        return "redirect:/generator/channel/list";//跳回列表页的处理
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Channel channel = service.getById(id);
        model.addAttribute("channel", channel);
        return "/update";

    }

    @PostMapping("/update_commit")
    public String update_commit(Channel channel) {
        service.updateById(channel);

        return "redirect:/generator/channel/list";//跳回列表页
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        System.out.println(service.removeById(id));
        return "redirect:/generator/channel/list";//跳回列表页
    }

    @GetMapping("/list")
    public String list(@RequestParam(required = false, defaultValue = "1", value = "current") Integer current,
                       Model model) {
        Page<Channel> page = new Page<>(current, 5);
        service.page(page);
        model.addAttribute("path", "/generator/channel/list?current=");
        // page.getT
        // page.getRecords()
        model.addAttribute("page", page);
        return "/list";

    }
}
