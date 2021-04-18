package pl.adiks.shoppingclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    private final RestTemplate restTemplate;

    public ShoppingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{price}")
    public String invokePaymentService(@PathVariable int price) {
        String url = "http://PAYMENT-SERVICE/payment/payNow/" + price;

        return restTemplate.getForObject(url, String.class);
    }
}
