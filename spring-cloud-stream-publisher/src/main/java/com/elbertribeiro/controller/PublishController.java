package com.elbertribeiro.controller;

import com.elbertribeiro.Book;
import com.elbertribeiro.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("publish")
public class PublishController {
    private final PublishService service;

    public PublishController(PublishService service) {
        this.service = service;
    }

    @PostMapping
    public Book publishEventResource(@RequestBody Book book) {
        return service.publishEvent(book);
    }
}
