package com.funny.code.controller;

import com.funny.code.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final ShipmentService shipmentService;


    @GetMapping("/hello/{id}")
    public String hello(@PathVariable Integer id) {
        shipmentService.shipStuff(id, id+1);
        return "OK";
    }
}
