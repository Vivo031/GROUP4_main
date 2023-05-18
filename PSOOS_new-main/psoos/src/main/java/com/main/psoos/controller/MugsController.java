package com.main.psoos.controller;

import com.main.psoos.dto.MugDTO;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MugsController {
    List<Object> orders = new ArrayList<>();
    List<MugDTO> mugOrders = new ArrayList<>();
    public void addMugOrder(MugDTO mugDTO){orders.add(mugDTO);    }

}
