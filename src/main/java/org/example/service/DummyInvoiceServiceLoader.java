package org.example.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Profile("dev")

// This needs to run with following command: java -Dspring.profiles.active=dev -jar target/MyI*
public class DummyInvoiceServiceLoader {
    private final InvoiceService invoiceService;

    public DummyInvoiceServiceLoader(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostConstruct
    public void setup() {
        System.out.println("Creating dev Invoices...");
        invoiceService.create("Erika", 300, "Liebe Erika");
        invoiceService.create("Ulli", 200, "Hi Ulli");
    }
}
