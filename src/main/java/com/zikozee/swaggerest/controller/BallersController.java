package com.zikozee.swaggerest.controller;

import com.zikozee.swaggerest.model.Ballers;
import com.zikozee.swaggerest.service.BallService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class BallersController {

    private final BallService service;

    public BallersController(BallService service) {
        this.service = service;
    }

    @GetMapping("/ballers")
    public Set<Ballers> getBallers(){
        return service.allBalls();
    }

    @GetMapping("/ballers/{id}")
    public Ballers getOneBall(@PathVariable int id){
        return service.oneBall(id);
    }

    @DeleteMapping("/ballers/{id}")
    public Ballers deleteOneBall(@PathVariable int id){
        return service.deleteBall(id);
    }

    @PostMapping("/ballers")
    public Ballers saveOrUpdate(Ballers ballers){
        ballers.setId(0);
        return service.saveOrUpdate(ballers);
    }
}
