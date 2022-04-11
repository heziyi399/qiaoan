package com.qiaoan_science.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzy
 * @since 2022-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("qa_cract_res")
public class CractRes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 裂缝编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 桥梁名称
     */
    private String brigeName;

    /**
     * 桥梁位置
     */
    private String brigeLocation;

    /**
     * 裂缝检测宽度
     */
    private Double crackWidth;

    /**
     * 裂缝检测深度
     */
    private String crackDeepth;

    /**
     * 含检测结果的图片url
     */
    private String pic;

    /**
     * 检测时间
     */
    private Date detectDate;

    /**
     * 桥梁所属机构
     */
    private String company;

    /**
     * 病害等级
     */
    private String dangerGrade;


}
