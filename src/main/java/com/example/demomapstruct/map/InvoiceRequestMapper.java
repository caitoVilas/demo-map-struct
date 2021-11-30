package com.example.demomapstruct.map;

import com.example.demomapstruct.dto.InvoiceRequest;
import com.example.demomapstruct.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceRequestMapper {

    @Mappings({
            @Mapping(source = "customer", target = "customerId")
    })
    Invoice invoiceRequestToInvoice(InvoiceRequest request);

    List<Invoice> invoiceRequestListToInvoiceList(List<InvoiceRequest> request);
}
