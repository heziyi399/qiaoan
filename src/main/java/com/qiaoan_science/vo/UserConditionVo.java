package com.qiaoan_science.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value="user对象",description="用户对象user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class UserConditionVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

}
