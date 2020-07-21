package com.zikozee.swaggerest.service;

import com.zikozee.swaggerest.Repository.BallRepository;
import com.zikozee.swaggerest.exception.BallersNotFoundException;
import com.zikozee.swaggerest.model.Ballers;
import com.zikozee.swaggerest.model.BallersDTO;
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
    public BallersDTO oneBall(int id) {
        Ballers ballers =repository.findById(id).orElse(null);
        if(ballers == null){
            throw new BallersNotFoundException("Record not found");
        }
        return utilityConverter(ballers);
    }

    @Override
    public BallersDTO deleteBall(int id) {
        BallersDTO oneBallerDTO = oneBall(id);
        repository.deleteById(id);
        return oneBallerDTO;
    }

    @Override
    public BallersDTO saveOrUpdate(BallersDTO ballersDTO) {
        Ballers ballers = Ballers.builder()
                .ball_1(ballersDTO.getBall_1())
                .ball_2(ballersDTO.getBall_2())
                .ball_3(ballersDTO.getBall_3())
                .ball_4(ballersDTO.getBall_4())
                .ball_5(ballersDTO.getBall_5())
                .ball_6(ballersDTO.getBall_6())
                .created_date(ballersDTO.getCreated_date()).build();
        return utilityConverter(repository.save(ballers));
    }

    private BallersDTO utilityConverter(Ballers ballers){

        return BallersDTO.builder()
                .ball_1(ballers.getBall_1())
                .ball_2(ballers.getBall_2())
                .ball_3(ballers.getBall_3())
                .ball_4(ballers.getBall_4())
                .ball_5(ballers.getBall_5())
                .ball_6(ballers.getBall_6())
                .created_date(ballers.getCreated_date()).build();
    }
}
