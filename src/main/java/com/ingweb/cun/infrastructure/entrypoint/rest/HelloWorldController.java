package com.ingweb.cun.infrastructure.entrypoint.rest;

import com.ingweb.cun.application.dto.BrandCarDtoRequest;
import com.ingweb.cun.application.dto.BrandCarDtoResponse;
import com.ingweb.cun.infrastructure.util.StatusCodeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloWorldController {

    @GetMapping("world")
    public String hello() {
        BrandCarDtoRequest marca = new BrandCarDtoRequest();
        return "Hello World";
    }

    @GetMapping("prueba")
    public ResponseEntity<BrandCarDtoResponse> getBrandCarDto() {
        BrandCarDtoResponse marca = new BrandCarDtoResponse();
        marca.setCodeResponse(StatusCodeResponse.ERROR_SERVER.getValueCode());
        marca.setMessageResponse(StatusCodeResponse.ERROR_SERVER.getMessageStatus());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(marca);
    }



    /*
    @Bean
    public Object hello2(){
        return new Object();
    }
     */

}
