package com.main.psoos.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShirtDTO {

    String orderType;
    private String shirtSize;
    private String printType;
    private Integer noOfShirt;
}
