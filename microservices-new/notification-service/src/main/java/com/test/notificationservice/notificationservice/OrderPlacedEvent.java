package com.test.notificationservice.notificationservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderPlacedEvent implements Serializable {
    private String orderNumber;

    public String toString(){
        return orderNumber;
    }
}
