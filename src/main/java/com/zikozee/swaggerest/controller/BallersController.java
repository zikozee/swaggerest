package com.zikozee.swaggerest.controller;

import com.zikozee.swaggerest.model.Ballers;
import com.zikozee.swaggerest.model.BallersDTO;
import com.zikozee.swaggerest.service.BallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetSocketAddress;
import java.util.Set;

@Api(description = "This is the required POWERBALL controller")
@RestController
@AllArgsConstructor
@Slf4j
public class BallersController {

    private final BallService service;

    //SWAGGER PATH NOW:::: http://localhost:8088/swagger-ui/

    @ApiOperation(value = "This will get a list of powerball draws", notes = "call the get method here with the ")
    @GetMapping("/ballers")
    public Set<Ballers> getBallers(){
        return service.allBalls();
    }

    @ApiOperation(value = "This will get a single powerball draw ", notes = "Here you need to pass in powerball draw id")
    @GetMapping("/ballers/{id}")
    public ResponseEntity<BallersDTO> getOneBall(@PathVariable int id, @RequestHeader HttpHeaders headers){
        InetSocketAddress host = headers.getHost();
        String ip = host.getHostName();
        int port = host.getPort();
        log.info("IP Address: " + ip + " Port: " + port);
        BallersDTO ballersDTO = service.oneBall(id);
        //Add something to the header
        headers.set("best programmer", "Jesus is Lord");
       //return new ResponseEntity<>(ballers, HttpStatus.FOUND);
        return ResponseEntity.ok().headers(headers).body(ballersDTO);
    }

    @ApiOperation(value = "This will delete a powerball draw ", notes = "Here you need to pass in powerball draw id")
    @DeleteMapping("/ballers/{id}")
    public BallersDTO deleteOneBall(@PathVariable int id){
        return service.deleteBall(id);
    }

    @ApiOperation(value = "This will save a new powerball draw ", notes = "You don't pass in id as it will be generated automatically, other fields mandatory")
    @PostMapping("/ballers")
    public BallersDTO saveOrUpdate(BallersDTO ballersDTO){
        return service.saveOrUpdate(ballersDTO);
    }
}
