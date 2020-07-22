package com.zikozee.swaggerest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BallersDTO implements Serializable {
    public static final long serialVersionUID = 42L;

    @ApiModelProperty(value = "This is the first input", required = true)
    private int ball_1;
    @ApiModelProperty(value = "This is the second input", required = true)
    private int ball_2;
    @ApiModelProperty(value = "This is the third input", required = true)
    private int ball_3;
    @ApiModelProperty(value = "This is the forth input", required = true)
    private int ball_4;
    @ApiModelProperty(value = "This is the fifth input", required = true)
    private int ball_5;
    @ApiModelProperty(value = "This is the last input", required = true )
    private int ball_6;

    @ApiModelProperty(value = "This is the date input, date(yyyy-MM-dd)", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String created_date;

}
