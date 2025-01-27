package com.food.controller;

import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.User;
import com.food.request.AddCartItemRequest;
import com.food.request.OrderRequest;
import com.food.response.PaymentResponse;
import com.food.service.OrderService;
import com.food.service.OrderServiceImp;
import com.food.service.PaymentService;
import com.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentResponse> createOrder(@RequestBody OrderRequest req,
                                                       @RequestHeader("Authorization") String jwt) throws Exception {
        System.out.println("Order Request: " + req);

        System.out.println("Authorization Header: " + jwt);
        User user=userService.findUserByJwtToken(jwt);
        Order order=orderService.createOrder(req,user);
        PaymentResponse res=paymentService.createPaymentLink(order);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(res);
    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
                                             @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        List<Order> orders=orderService.getUsersOrder(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
