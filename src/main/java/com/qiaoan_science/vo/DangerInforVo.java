package com.qiaoan_science.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="病害信息对象",description="病害")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class DangerInforVo {
    private static final long serialVersionUID = 1L;



    /**
     * 病害姓名
     */
    @ApiModelProperty(name = "name", value = "病害名，前端可以提供一些可以选择的种类", dataType = "string")
    private String name;

    @ApiModelProperty(name = "beginDate", value = "检测时间开始值", dataType = "Date")
    private Date beginDate;
    @ApiModelProperty(name = "endDate", value = "检测时间结束值", dataType = "Date")
    private Date endDate;
    /**
     * 危险等级
     */
    @ApiModelProperty(name = "dangerGrade", value = "病害等级", dataType = "string")
    private String dangerGrade;

    /**
     * 此病害发生在什么桥梁上面
     */
    @ApiModelProperty(name = "brigeName", value = "病害对应的桥梁名称", dataType = "string")
    private String brigeName;

}
