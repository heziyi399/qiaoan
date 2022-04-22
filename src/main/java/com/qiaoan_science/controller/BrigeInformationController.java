package com.qiaoan_science.controller;


import com.github.pagehelper.PageInfo;
import com.qiaoan_science.Base.ResponseResult;
import com.qiaoan_science.pojo.BrigeInformation;
import com.qiaoan_science.service.IBrigeInformationService;
import com.qiaoan_science.service.impl.BrigeInformationServiceImpl;
import com.qiaoan_science.vo.BrigeInforVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
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
@Api(tags = {"桥梁信息接口"})
@RestController
@RequestMapping("/brige_information")
public class BrigeInformationController {
    @Autowired
    private BrigeInformationServiceImpl informationsService;
    @GetMapping("/list")
    @ApiOperation(value="分页获取全部数据")
    public ResponseResult<PageInfo> brigeInforlists(
            @ApiParam(name="pageNum",value="开头页",required=true)@RequestParam("pageNum")int pageNum,
            @ApiParam(name="pageSize",value="页的大小",required=true)@RequestParam("content")int pageSize

    )
    {
List<BrigeInformation> briges = informationsService.list();

        PageInfo pageInfo = new PageInfo(briges);
        pageInfo.setList(briges);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(pageNum);

        return ResponseResult.success(pageInfo);
    }
    @ApiOperation(value="条件查询数据")
    @PostMapping("/list/brigebycondition")
    public ResponseResult selectBrigeInfor(BrigeInforVo brigeInforVo)
    {
        BrigeInformation information = new BrigeInformation();
    List<BrigeInformation>briges = informationsService.getByCondition(brigeInforVo);
        PageInfo pageInfo = new PageInfo(briges);
        pageInfo.setList(briges);
        pageInfo.setPageSize(10);
        pageInfo.setPageNum(1);

        return ResponseResult.success(pageInfo);
    }
    @ApiOperation(value="新增一条数据")
    @PostMapping("/add/brigebycondition")
    public ResponseResult insertBrigeInfor(BrigeInformation brigeInforVo)
    {
//        BrigeInformation information = new BrigeInformation();
//        BeanUtils.copyProperties(brigeInforVo,information);
       if( informationsService.save(brigeInforVo))
       {
           return ResponseResult.success("ok");
       }
       else {
           return ResponseResult.error("fail");
       }

    }
}
