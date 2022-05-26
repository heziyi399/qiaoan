package com.qiaoan_science.controller;


import com.github.pagehelper.PageInfo;
import com.qiaoan_science.Base.ResponseResult;
import com.qiaoan_science.pojo.BrigeInformation;
import com.qiaoan_science.pojo.Danger;
import com.qiaoan_science.service.impl.DangerServiceImpl;
import com.qiaoan_science.vo.BrigeInforVo;
import com.qiaoan_science.vo.DangerInforVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hzy
 * @since 2022-04-09
 */
@Api(tags = {"桥梁裂缝之外其他危险信息接口"})
@RestController
@RequestMapping("/danger")
public class DangerController {
    @Autowired
    private DangerServiceImpl service;
@GetMapping("/list")
@ApiOperation(value="分页获取全部数据")
public ResponseResult<PageInfo> brigeInforlists(
        @ApiParam(name="pageNum",value="开头页",required=true)@RequestParam("pageNum")int pageNum,
        @ApiParam(name="pageSize",value="页的大小",required=true)@RequestParam("pageSize")int pageSize

){
    List<Danger> dangers = service.list();

    PageInfo pageInfo = new PageInfo(dangers);
    pageInfo.setList(dangers);
    pageInfo.setPageSize(pageSize);
    pageInfo.setPageNum(pageNum);

    return ResponseResult.success(pageInfo);
}
    @ApiOperation(value="条件查询数据")
    @PostMapping("/list/dangerbycondition")
    public ResponseResult selectBrigeInfor(DangerInforVo dangerInforVo)
    {
        BrigeInformation information = new BrigeInformation();
        List<Danger>briges = service.getByCondition(dangerInforVo);
        PageInfo pageInfo = new PageInfo(briges);
        pageInfo.setList(briges);
        pageInfo.setPageSize(10);
        pageInfo.setPageNum(1);

        return ResponseResult.success(pageInfo);
    }
}
