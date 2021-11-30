package com.example.demomapstruct.dto;

import lombok.Data;

@Data
public class InvoiceResponse {

    private Long invoiceId;
    private Long customer;
    private String number;
    private String details;
    private Double amount;

}
