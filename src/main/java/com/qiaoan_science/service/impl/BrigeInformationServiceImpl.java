package com.qiaoan_science.service.impl;

import com.qiaoan_science.pojo.BrigeInformation;
import com.qiaoan_science.mapper.BrigeInformationMapper;
import com.qiaoan_science.service.IBrigeInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiaoan_science.vo.BrigeInforVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzy
 * @since 2022-04-09
 */
@Service
public class BrigeInformationServiceImpl extends ServiceImpl<BrigeInformationMapper, BrigeInformation> implements IBrigeInformationService {
@Autowired
private BrigeInformationMapper informationMapper;
    @Override
    public List<BrigeInformation> getByCondition(BrigeInforVo brigeInforVo) {
        return informationMapper.selectByCondition(brigeInforVo);
    }
}
