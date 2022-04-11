package com.qiaoan_science.service;

import com.qiaoan_science.pojo.BrigeInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiaoan_science.vo.BrigeInforVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzy
 * @since 2022-04-09
 */
public interface IBrigeInformationService extends IService<BrigeInformation> {

    List<BrigeInformation> getByCondition(BrigeInforVo brigeInforVo);
}
