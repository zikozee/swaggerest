package com.zikozee.swaggerest.controller;

import com.zikozee.swaggerest.model.BallersDTO;
import com.zikozee.swaggerest.service.BallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetSocketAddress;
import java.util.List;

@Api(description = "This is the required POWERBALL controller")
@RestController
@AllArgsConstructor
@Slf4j
public class BallersController {

    private final BallService service;

    //SWAGGER PATH NOW:::: http://localhost:8088/swagger-ui/

    @ApiOperation(value = "This will get a list of powerball draws", notes = "call the get method here with the ")
    @GetMapping("/ballers")
    @ResponseStatus(HttpStatus.OK)
    public List<BallersDTO> getBallers(){
        return service.allBalls();
    }

    @ApiOperation(value = "This will get a single powerball draw ", notes = "Here you need to pass in powerball draw id")
    @GetMapping("/ballers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BallersDTO> getOneBall(@PathVariable("id") long id, @RequestHeader HttpHeaders headers){
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
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BallersDTO> deleteOneBall(@PathVariable("id") long id){
        return new ResponseEntity<>(service.deleteBall(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will save a new powerball draw ", notes = "You don't pass in id as it will be generated automatically, other fields mandatory")
    @PostMapping("/ballers")
    @ResponseStatus(HttpStatus.CREATED)
    public BallersDTO saveOrUpdate(BallersDTO ballersDTO){
        return service.saveOrUpdate(ballersDTO);
    }
}
