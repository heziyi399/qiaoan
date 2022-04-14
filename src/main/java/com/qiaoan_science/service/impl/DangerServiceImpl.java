package com.qiaoan_science.service.impl;

import com.qiaoan_science.pojo.BrigeInformation;
import com.qiaoan_science.pojo.Danger;
import com.qiaoan_science.mapper.DangerMapper;
import com.qiaoan_science.service.IDangerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiaoan_science.vo.DangerInforVo;
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
public class DangerServiceImpl extends ServiceImpl<DangerMapper, Danger> implements IDangerService {
@Autowired
    private DangerMapper mapper;

    @Override
    public List<Danger> getByCondition(DangerInforVo dangerInforVo) {
        return mapper.selectByCondition(dangerInforVo);
    }
}
