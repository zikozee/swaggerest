package com.zikozee.swaggerest.service;

import com.zikozee.swaggerest.Repository.BallRepository;
import com.zikozee.swaggerest.exception.BallersNotFoundException;
import com.zikozee.swaggerest.exception.DateException;
import com.zikozee.swaggerest.model.Ballers;
import com.zikozee.swaggerest.model.BallersDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class BallServiceImpl implements BallService {

    private final BallRepository repository;

    @Override
    public List<BallersDTO> allBalls() {
        Set<Ballers> myBalls = new HashSet<>();
        repository.findAll().forEach(myBalls::add);
        return utilityConverterList(myBalls);
    }

    @Override
    public BallersDTO oneBall(long id) {
        Ballers ballers =repository.findById(id).orElse(null);
        if(ballers == null){
            throw new BallersNotFoundException("Record not found");
        }
        log.info( "see my date ooo??>>>>>>>>>>>"+ ballers.getCreated_date());
        return utilityConverter(ballers);
    }

    @Override
    public BallersDTO deleteBall(long id) {
        BallersDTO oneBallerDTO = oneBall(id);
        repository.deleteById(id);
        return oneBallerDTO;
    }

    @Override
    public BallersDTO saveOrUpdate(BallersDTO ballersDTO) throws ParseException {
        if(!ballersDTO.getCreated_date().matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")){
            throw new DateException("date format is wrong");
        }

        Ballers ballers = Ballers.builder()
                .ball_1(ballersDTO.getBall_1())
                .ball_2(ballersDTO.getBall_2())
                .ball_3(ballersDTO.getBall_3())
                .ball_4(ballersDTO.getBall_4())
                .ball_5(ballersDTO.getBall_5())
                .ball_6(ballersDTO.getBall_6())
                .created_date(stringDateJavaDate(ballersDTO.getCreated_date())).build();
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
                .created_date(javaDateToStringDate(ballers.getCreated_date())).build();
    }

    private List<BallersDTO> utilityConverterList(Set<Ballers> ballersSet){
        List<BallersDTO> ballersDTOS =  new ArrayList<>();
            for(Ballers ballers: ballersSet){
                ballersDTOS.add(BallersDTO.builder()
                        .ball_1(ballers.getBall_1())
                        .ball_2(ballers.getBall_2())
                        .ball_3(ballers.getBall_3())
                        .ball_4(ballers.getBall_4())
                        .ball_5(ballers.getBall_5())
                        .ball_6(ballers.getBall_6())
                        .created_date(javaDateToStringDate(ballers.getCreated_date())).build());
            }
       return ballersDTOS;
    }

    private String javaDateToStringDate(Date date){
        String pattern = "yyyy/MM/dd";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    private Date stringDateJavaDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(date);
    }

}
