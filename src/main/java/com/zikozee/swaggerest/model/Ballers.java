package com.zikozee.swaggerest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "power_ball")
@Table(name = "power_ball")
@Data
public class Ballers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int ball_1;
    private int ball_2;
    private int ball_3;
    private int ball_4;
    private int ball_5;
    private int ball_6;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date created_date;

}
