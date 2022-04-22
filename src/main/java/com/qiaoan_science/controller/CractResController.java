package com.qiaoan_science.controller;


import com.github.pagehelper.PageInfo;
import com.qiaoan_science.Base.ResponseResult;
import com.qiaoan_science.pojo.BrigeInformation;
import com.qiaoan_science.pojo.CractRes;
import com.qiaoan_science.pojo.Danger;
import com.qiaoan_science.service.impl.CractResServiceImpl;
import com.qiaoan_science.vo.BrigeInforVo;
import com.qiaoan_science.vo.CractVo;
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
@Api(tags = {"裂缝数据接口"})
@RestController
@RequestMapping("/cract")
public class CractResController {
    @Autowired
    private CractResServiceImpl cractService;
@GetMapping("/list")
    public ResponseResult<PageInfo> geturl(    @ApiParam(name="pageNum",value="开头页",required=true)@RequestParam("pageNum")int pageNum,
                                               @ApiParam(name="pageSize",value="页的大小",required=true)@RequestParam("content")int pageSize)
{
    List<CractRes> cracts = cractService.list();

    PageInfo pageInfo = new PageInfo(cracts);
    pageInfo.setList(cracts);
    pageInfo.setPageSize(pageSize);
    pageInfo.setPageNum(pageNum);

    return ResponseResult.success(pageInfo);
}

    @ApiOperation(value="条件查询数据")
    @PostMapping("/list/cractbycondition")
    public ResponseResult selectBrigeInfor(CractVo cractVo)
    {
        BrigeInformation information = new BrigeInformation();
        List<CractRes>briges = cractService.getByCondition(cractVo);
        PageInfo pageInfo = new PageInfo(briges);
        pageInfo.setList(briges);
        pageInfo.setPageSize(10);
        pageInfo.setPageNum(1);

        return ResponseResult.success(pageInfo);
    }
}
