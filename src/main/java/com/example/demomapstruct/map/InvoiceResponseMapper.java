package com.example.demomapstruct.map;

import com.example.demomapstruct.dto.InvoiceRequest;
import com.example.demomapstruct.dto.InvoiceResponse;
import com.example.demomapstruct.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceResponseMapper {

    @Mappings({
            @Mapping(source = "customerId", target = "customer")
    })
    InvoiceResponse invoiceToInvoiceResponse(Invoice invoice);

    List<InvoiceResponse> invoiceListToInvoiceResponseList(List<Invoice> invoices);
}
