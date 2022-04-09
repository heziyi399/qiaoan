package com.qiaoan_science.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("qa_brige_information")
public class BrigeInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 桥梁id
     */
    private Integer id;

    /**
     * 桥梁位置
     */
    private String location;

    /**
     * 桥梁所属单位
     */
    private String company;

    /**
     * 桥梁三维建模文件
     */
    @TableField("threeD_file")
    private String threedFile;

    /**
     * 分析得出的可能隐患
     */
    private String possibleDanger;

    /**
     * 使用者可备注的整改桥梁建议
     */
    private String suggestion;

    /**
     * 最近一次检测的时间
     */
    private String recentDetect;

    /**
     * 桥梁所在城市
     */
    private String city;


}
