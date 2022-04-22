package com.qiaoan_science.service.impl;

import com.qiaoan_science.pojo.CractRes;
import com.qiaoan_science.mapper.CractResMapper;
import com.qiaoan_science.service.ICractResService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiaoan_science.vo.CractVo;
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
public class CractResServiceImpl extends ServiceImpl<CractResMapper, CractRes> implements ICractResService {
@Autowired
private CractResMapper mapper;
    @Override
    public List<CractRes> getByCondition(CractVo cractVo) {
        return mapper.getByCondition(cractVo);
    }
}
