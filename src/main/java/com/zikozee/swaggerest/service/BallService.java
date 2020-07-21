package com.zikozee.swaggerest.service;

import com.zikozee.swaggerest.model.BallersDTO;

import java.util.List;

public interface BallService {
    List<BallersDTO> allBalls();
    BallersDTO oneBall(long id);
    BallersDTO deleteBall(long id);
    BallersDTO saveOrUpdate(BallersDTO ballersDTO);
}
