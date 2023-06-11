package com.elbertribeiro.service;

import com.elbertribeiro.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class ConsumerService {
    private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @StreamListener(Sink.INPUT)
    public void consumeMessage(Book book) {
        logger.info("Consume payload: " + book);
    }

}
