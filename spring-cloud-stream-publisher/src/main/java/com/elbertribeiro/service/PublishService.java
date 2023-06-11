package com.elbertribeiro.service;

import com.elbertribeiro.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class PublishService {
    private final Logger logger = LoggerFactory.getLogger(PublishService.class);
    @Autowired
    private MessageChannel output;

    public Book publishEvent(Book book){
        output.send(MessageBuilder.withPayload(book).build());
        logger.info("Send event: " + book);
        return book;
    }
}
