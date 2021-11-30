package com.example.demomapstruct.controller;

import com.example.demomapstruct.dto.InvoiceRequest;
import com.example.demomapstruct.dto.InvoiceResponse;
import com.example.demomapstruct.entity.Invoice;
import com.example.demomapstruct.map.InvoiceRequestMapper;
import com.example.demomapstruct.map.InvoiceResponseMapper;
import com.example.demomapstruct.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceRepository repository;
    @Autowired
    private InvoiceRequestMapper requestMapper;
    @Autowired
    private InvoiceResponseMapper responseMapper;

    @GetMapping
    public ResponseEntity<List<InvoiceResponse>> getAll(){
        List<Invoice> invoices = repository.findAll();
        List<InvoiceResponse> list = responseMapper.invoiceListToInvoiceResponseList(invoices);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponse> getById(@PathVariable Long id){

        Invoice invoice = repository.findById(id).orElse(null);
        if (invoice == null) return ResponseEntity.notFound().build();
        InvoiceResponse reponse = responseMapper.invoiceToInvoiceResponse(invoice);
        return ResponseEntity.ok(reponse);
    }

    @PostMapping
    public ResponseEntity<InvoiceResponse> save(@RequestBody InvoiceRequest request){
        Invoice invoice = requestMapper.invoiceRequestToInvoice(request);
        repository.save(invoice);
        InvoiceResponse response = responseMapper.invoiceToInvoiceResponse(invoice);
        return ResponseEntity.ok(response);
    }
}
