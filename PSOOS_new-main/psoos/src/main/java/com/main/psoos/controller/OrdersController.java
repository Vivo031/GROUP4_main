package com.main.psoos.controller;

import com.main.psoos.dto.DocumentDTO;
import com.main.psoos.dto.MugDTO;
import com.main.psoos.dto.ShirtDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController {
    @GetMapping("/myOrdersPage")
    public String myOrdersPage(){
        return "myAccount_orders";
    }

    @GetMapping("/orderSummary")
    public String orderSummary(){
        return "checkout_page";
    }

    @GetMapping("/orderType")
    public String orderType(){
        return "home_OrderType";
    }

    @GetMapping("/likeToCustomize")
    public String likeToCustomize(){
        return "WhatWouldLikeToCustomize";
    }

    @GetMapping("/likeToHelp")
    public String likeToHelp(){
        return "WhatWouldLikeToHelp";
    }

    @GetMapping("/mugCustomize")
    public String mugCustomize(){
        return "mug_customize";
    }

    @GetMapping("/shirtCustomize")
    public String shirtCustomize(){
        return "tshirt_customize";
    }

    @GetMapping("/shirtHelp")
    public String shirtHelp(){
        return "tshirt_help";
    }

    @GetMapping("/docsCustomize")
    public String docsCustomize(){
        return "docs_upload";
    }

    @GetMapping("/account")
    public String account(){
        return "myAccount_home";
    }


}
