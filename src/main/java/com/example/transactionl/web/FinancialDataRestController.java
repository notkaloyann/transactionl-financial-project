package com.example.transactionl.web;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;

@RestController
public class FinancialDataRestController {

    @GetMapping("/company/stocks/apple")
    public ResponseEntity<double[]> companyData() throws IOException {

        URL e_url = new URL("https://query1.finance.yahoo.com/v8/finance/chart/aapl?metrics=high?&interval=1d&range=5d");
        JsonNode test = get(e_url);
        JsonNode closePrice = test.path("chart").path("result").get(0).get("indicators").get("adjclose").get(0).get("adjclose");
        double[] parsedPrices = new ObjectMapper().convertValue(closePrice, double[].class);
        return ResponseEntity.ok().body(parsedPrices);
    }

    public static JsonNode get(URL url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(url);
    }


}
