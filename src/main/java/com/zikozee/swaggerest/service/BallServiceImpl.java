package com.zikozee.swaggerest.service;

import com.zikozee.swaggerest.Repository.BallRepository;
import com.zikozee.swaggerest.model.Ballers;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class BallServiceImpl implements BallService {

    private final BallRepository repository;

    public BallServiceImpl(BallRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Ballers> allBalls() {
        Set<Ballers> myBalls = new HashSet<>();
        repository.findAll().forEach(myBalls::add);
        return myBalls;
    }

    @Override
    public Ballers oneBall(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Ballers deleteBall(int id) {
        Ballers oneBaller = oneBall(id);
        repository.deleteById(id);
        return oneBaller;
    }

    @Override
    public Ballers saveOrUpdate(Ballers ballers) {
        return repository.save(ballers);
    }
}
