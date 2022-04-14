package com.qiaoan_science.mapper;

import com.qiaoan_science.pojo.Danger;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiaoan_science.vo.DangerInforVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hzy
 * @since 2022-04-09
 */
@Mapper
public interface DangerMapper extends BaseMapper<Danger> {

    List<Danger> selectByCondition(DangerInforVo dangerInforVo);
}
