package com.qiaoan_science.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hzy
 * @date 2022-04-11
 */
@ApiModel(value="bridge对象",description="桥梁")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class BrigeInforVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(name = "location", value = "桥梁位置", dataType = "String")
    /**
     * 桥梁位置
     */
    private String location;

    /**
     * 桥梁所属单位
     */
    @ApiModelProperty(name = "company", value = "桥梁所属单位", dataType = "String")
    private String company;


    /**
     * 分析得出的可能隐患
     */
    @ApiModelProperty(name = "company", value = "可能的隐患类型", dataType = "String")
    private String possibleDanger;



    /**
     * 检测时间开始值
     */
    @ApiModelProperty(name = "beginDate", value = "检测时间开始值", dataType = "Date")
    private Date beginDate;
    @ApiModelProperty(name = "beginDate", value = "检测时间结束", dataType = "Date")
    private Date endDate;
    /**
     * 桥梁所在城市
     */
    @ApiModelProperty(name = "city", value = "桥梁所在城市", dataType = "String")
    private String city;
}
