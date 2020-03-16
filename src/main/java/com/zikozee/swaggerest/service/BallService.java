package com.zikozee.swaggerest.service;

import com.zikozee.swaggerest.model.Ballers;

import java.util.Set;

public interface BallService {
    Set<Ballers> allBalls();
    Ballers oneBall(int id);
    Ballers deleteBall(int id);
    Ballers saveOrUpdate(Ballers ballers);
}
