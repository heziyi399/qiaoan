package com.qiaoan_science.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/cract_res")
public class CractResController {
@GetMapping("/get")
    public String geturl()
{
    return "mm";
}
}
