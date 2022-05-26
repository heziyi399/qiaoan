package com.qiaoan_science.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import com.qiaoan_science.Base.ResponseResult;
import com.qiaoan_science.pojo.City;
import com.qiaoan_science.pojo.CractRes;
import com.qiaoan_science.service.impl.CityServiceImpl;
import com.qiaoan_science.service.impl.CractResServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hzy
 * @since 2022-05-26
 */
@Api(tags = {"城市信息接口"})
@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityServiceImpl cityService;
    @ApiOperation(value="城市列表，获得所有城市和对应的桥梁数量+危险桥梁数量")
    @GetMapping("/list")
    public ResponseResult<PageInfo> geturl(@ApiParam(name="pageNum",value="开头页",required=true)@RequestParam("pageNum")int pageNum,
                                           @ApiParam(name="pageSize",value="页的大小",required=true)@RequestParam("pageSize")int pageSize)
    {
        List<City> cracts = cityService.list();

        PageInfo pageInfo = new PageInfo(cracts);
        pageInfo.setList(cracts);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(pageNum);

        return ResponseResult.success(pageInfo);
    }
    @ApiOperation(value="搜索某个城市对应的桥梁数量+危险桥梁数量")
    @GetMapping("/list/{city}")
    public ResponseResult<PageInfo> geturl(@ApiParam(name="pageNum",value="开头页",required=true)@RequestParam("pageNum")int pageNum,
                                           @ApiParam(name="pageSize",value="页的大小",required=true)@RequestParam("pageSize")int pageSize,
                                           @PathVariable("city")String city)
    {
        List<City> citys = cityService.list(new LambdaQueryWrapper<City>().eq(City::getName,city));

        PageInfo pageInfo = new PageInfo(citys);
        pageInfo.setList(citys);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(pageNum);

        return ResponseResult.success(pageInfo);
    }
}
