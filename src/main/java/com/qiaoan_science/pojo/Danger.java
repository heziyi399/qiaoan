package com.qiaoan_science.pojo;

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
@TableName("qa_danger")
public class Danger implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 具体的病害种类id
     */
    private Integer id;

    /**
     * 病害姓名
     */
    private String name;

    /**
     * 病害检测时间
     */
    private Date happenTime;

    /**
     * 危险等级
     */
    private String dangerGrade;

    /**
     * 此病害发生在什么桥梁上面
     */
    private Integer brigeId;

    private String dangerUrl;


}
