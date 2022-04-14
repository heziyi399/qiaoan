package com.qiaoan_science.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hzy
 * @date 2022-04-14
 */
@ApiModel(value="裂缝信息",description="裂缝")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class CractVo {
    /**
     * 桥梁名称
     */
    @ApiModelProperty(name = "brigeName", value = "裂缝对应的桥梁名称", dataType = "string")
    private String brigeName;

    /**
     * 桥梁位置
     */
    @ApiModelProperty(name = "brigeLocation", value = "裂缝发生的位置", dataType = "string")
    private String brigeLocation;


    @ApiModelProperty(name = "beginDate", value = "检测时间开始值", dataType = "Date")
    private Date beginDate;
    @ApiModelProperty(name = "endDate", value = "检测时间结束值", dataType = "Date")
    private Date endDate;

    /**
     * 桥梁所属机构
     */
    @ApiModelProperty(name = "company", value = "裂缝所属单位", dataType = "string")
    private String company;

    /**
     * 病害等级
     */
    @ApiModelProperty(name = "dangerGrade", value = "裂缝等级", dataType = "string")
    private String dangerGrade;
    @ApiModelProperty(name = "crackFrom", value = "裂缝检测来源", dataType = "string")
    private String crackFrom;//检测来源
}
