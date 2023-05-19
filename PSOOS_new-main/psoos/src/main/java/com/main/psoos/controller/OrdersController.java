package com.main.psoos.controller;

import com.main.psoos.dto.DocumentDTO;
import com.main.psoos.dto.MugDTO;
import com.main.psoos.dto.ShirtDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "docs_customize";
    }

    @GetMapping("/account")
    public String account(){
        return "myAccount_home";
    }

    List<DocumentDTO> documentOrders = new ArrayList<>();
    List<Object> orders = new ArrayList<>();

    @PostMapping("/addDocument")
    public String addDocument(DocumentDTO tempDocument, Model model){
        addDocumentOrder(tempDocument);
        model.addAttribute("orders", documentOrders);
        model.addAttribute("mugOrders", mugOrders);
        model.addAttribute("shirtOrders", shirtOrders);
        return "checkout_page";
    }
    public void addDocumentOrder(DocumentDTO tempDocument){
        tempDocument.setOrderType("DOCUMENT");
        documentOrders.add(tempDocument);
    }

    List<MugDTO> mugOrders = new ArrayList<>();
    @PostMapping("/addMug")
    public String addMug(MugDTO mugDTO, Model model){
        addMugOrder(mugDTO);
        model.addAttribute("mugOrders", mugOrders);
        model.addAttribute("orders", documentOrders);
        model.addAttribute("shirtOrders", shirtOrders);
        return "checkout_page";
    }
    public void addMugOrder(MugDTO mugDTO){
        mugDTO.setOrderType("MUG");
        mugOrders.add(mugDTO);
    }
    List<ShirtDTO> shirtOrders = new ArrayList<>();
    @PostMapping("/addShirt")
    public String addShirt(ShirtDTO shirtDTO, Model model){
        addShirtOrder(shirtDTO);
        model.addAttribute("mugOrders", mugOrders);
        model.addAttribute("shirtOrders", shirtOrders);
        model.addAttribute("orders", documentOrders);
        return "checkout_page";
    }

    public void addShirtOrder(ShirtDTO tempShirt){
        tempShirt.setOrderType("SHIRT");
        shirtOrders.add(tempShirt);
    }
}
