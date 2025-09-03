package com.xzit.generator.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzit.generator.entity.Channel;
import com.xzit.generator.service.IChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RestController
@RequestMapping("/generator/channel")
@Api(tags = "栏目信息管理")
public class ChannelController {
    @Resource
    private IChannelService channelService;

    @PostMapping
    @ApiOperation("新增栏目")
    public Object insert(@RequestBody Channel channel) {
        return channelService.save(channel);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("按照Id删除栏目")
    public Object delete(@PathVariable Integer id) {
        return channelService.removeById(id);
    }
    @PutMapping
    @ApiOperation("修改栏目信息")
    public Object update(@RequestBody Channel channel) {
        return channelService.updateById(channel);
    }
    @GetMapping
    @ApiOperation("查询所有栏目信息")
    public Object selectList() {
        return channelService.list();
    }
    @GetMapping("/{id}")
    @ApiOperation("按照Id查找栏目信息")
    public Object selectById(@PathVariable Integer id) {
        LambdaQueryWrapper<Channel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Channel::getCid, id);
        return channelService.list(wrapper);
    }
    @GetMapping("/{start}/{size}")
    @ApiOperation("分页操作")
    public Object selectByPage(@PathVariable Integer start, @PathVariable Integer size) {
        Page<Channel> page = new Page<>(start, size);
        channelService.page(page);
        return page;
    }

}
