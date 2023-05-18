package com.main.psoos.controller;

import com.main.psoos.dto.ShirtDTO;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShirtController {
    List<Object> orders = new ArrayList<>();
    List<ShirtDTO> shirtOrders = new ArrayList<>();

    public void addShirtOrder(ShirtDTO tempShirt){orders.add(tempShirt);    }
}
