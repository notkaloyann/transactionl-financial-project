package com.example.transactionl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequestMapping("/financial-data")
@Controller
public class FinancialDataController {

    @GetMapping("/companies-stocks")
    public String financeOverview() throws IOException {
        return "financial-info";
    }
}
