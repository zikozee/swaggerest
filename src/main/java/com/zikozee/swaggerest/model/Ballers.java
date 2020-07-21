package com.zikozee.swaggerest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "power_ball")
@Table(name = "power_ball")
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Ballers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ball_1;
    private int ball_2;
    private int ball_3;
    private int ball_4;
    private int ball_5;
    private int ball_6;

//    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date created_date;

}
