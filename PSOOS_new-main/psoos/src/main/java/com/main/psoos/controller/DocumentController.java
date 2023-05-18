package com.main.psoos.controller;

import com.main.psoos.dto.DocumentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DocumentController {
    List<DocumentDTO> documentOrders = new ArrayList<>();
    List<Object> orders = new ArrayList<>();

    @PostMapping("/addDocument")
    public String addDocument(DocumentDTO tempDocument, Model model){
        addDocumentOrder(tempDocument);
        model.addAttribute("orders", documentOrders);
        return "cartOrders";
    }
    public void addDocumentOrder(DocumentDTO tempDocument){
        tempDocument.setOrderType("DOCUMENT");
        documentOrders.add(tempDocument);
    }
}
