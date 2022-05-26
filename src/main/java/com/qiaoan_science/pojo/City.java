package com.qiaoan_science.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzy
 * @since 2022-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("qa_city")
@ApiModel(description = "中国的城市信息")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 城市id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    /**
     * 城市的桥梁总数
     */
    private Integer bridgeNum;

    /**
     * 城市有风险的桥梁总数
     */
    private Integer brigeDangerNum;


}
