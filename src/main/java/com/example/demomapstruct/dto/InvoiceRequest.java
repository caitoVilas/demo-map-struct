package com.example.demomapstruct.dto;

import lombok.Data;

@Data
public class InvoiceRequest {

    private Long customer;
    private String number;
    private String details;
    private Double amount;
}
