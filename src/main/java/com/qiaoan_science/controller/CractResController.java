package com.qiaoan_science.controller;


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
@RestController
@RequestMapping("/cract_res")
public class CractResController {
@GetMapping("/get")
    public String geturl()
{
    return "mm";
}
}
