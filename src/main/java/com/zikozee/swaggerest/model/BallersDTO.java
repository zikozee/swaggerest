package com.zikozee.swaggerest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BallersDTO {

    @ApiModelProperty(value = "This is the first input", required = true)
    private int ball_1;
    private int ball_2;
    private int ball_3;
    private int ball_4;
    private int ball_5;
    @ApiModelProperty(value = "This is the last input", required = true )
    private int ball_6;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date created_date;

}
