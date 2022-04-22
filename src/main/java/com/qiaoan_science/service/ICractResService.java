package com.qiaoan_science.service;

import com.qiaoan_science.pojo.BrigeInformation;
import com.qiaoan_science.pojo.CractRes;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiaoan_science.vo.CractVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzy
 * @since 2022-04-09
 */
public interface ICractResService extends IService<CractRes> {

    List<CractRes> getByCondition(CractVo cractVo);
}
