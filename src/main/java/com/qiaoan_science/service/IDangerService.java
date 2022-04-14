package com.qiaoan_science.service;

import com.qiaoan_science.pojo.BrigeInformation;
import com.qiaoan_science.pojo.Danger;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiaoan_science.vo.BrigeInforVo;
import com.qiaoan_science.vo.DangerInforVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzy
 * @since 2022-04-09
 */
public interface IDangerService extends IService<Danger> {

    List<Danger> getByCondition(DangerInforVo dangerInforVo);
}
