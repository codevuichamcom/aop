package com.funny.code.service;

import com.funny.code.annotation.PositiveNumber;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {
    // this here is what's called a join point

    public void shipStuff(@PositiveNumber Integer id, @PositiveNumber Integer id2) {
        System.out.println("In Service: " + id + id2);
    }
}