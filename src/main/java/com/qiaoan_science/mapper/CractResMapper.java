package com.qiaoan_science.mapper;

import com.qiaoan_science.pojo.CractRes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiaoan_science.vo.CractVo;
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
public interface CractResMapper extends BaseMapper<CractRes> {

    List<CractRes> getByCondition(CractVo cractVo);
}
