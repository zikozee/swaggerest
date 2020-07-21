package com.zikozee.swaggerest.service;

import com.zikozee.swaggerest.model.Ballers;
import com.zikozee.swaggerest.model.BallersDTO;

import java.util.Set;

public interface BallService {
    Set<Ballers> allBalls();
    BallersDTO oneBall(int id);
    BallersDTO deleteBall(int id);
    BallersDTO saveOrUpdate(BallersDTO ballersDTO);
}
