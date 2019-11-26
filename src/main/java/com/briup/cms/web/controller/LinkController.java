package com.briup.cms.web.controller;

import com.briup.cms.bean.Link;
import com.briup.cms.service.ILinkService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/link")
@Api(description = "连接管理")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/add")
    @ApiOperation("添加链接")
    public Message addLink(Link link) {
        linkService.saveOrUpdateLink(link);
        return MessageUtil.success();
    }

    @GetMapping("/deleteById")
    @ApiOperation("删除链接id")
    @ApiImplicitParam(name = "id" ,value = "链接id" ,paramType = "query" , dataType = "int" ,required = true)
    public Message deleteByIdLink(int id) {
        linkService.deleteLinkById(id);

        return MessageUtil.success();
    }

    @GetMapping("/queryById")
    @ApiOperation("查询链接")
    @ApiImplicitParam(name = "id" ,value = "链接id" ,paramType = "query" , dataType = "int" ,required = true)
    public Message<Link> queryById(int id) {
        Link link = linkService.queryLinkById(id);

        return MessageUtil.success(link);
    }

    @PostMapping("/update")
    @ApiOperation("更新链接")
    public Message update(Link link) {
        linkService.saveOrUpdateLink(link);

        return MessageUtil.success();
    }

    @GetMapping("findAll")
    @ApiOperation("查询所有")
    public Message<List<Link>> findAll() {
        List<Link> links = linkService.findLink();

        return MessageUtil.success(links);
    }


}
