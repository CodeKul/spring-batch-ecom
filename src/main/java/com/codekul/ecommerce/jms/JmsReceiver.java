package com.codekul.ecommerce.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by aniruddha on 4/9/16.
 */
@Component
public class JmsReceiver {

    @JmsListener(destination = "book", containerFactory = "bookFactory")
    public void saveBook(Book book){
        System.out.println("Received Book - "+book);
    }
}
