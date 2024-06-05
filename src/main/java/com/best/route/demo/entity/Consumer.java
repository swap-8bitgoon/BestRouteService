package com.best.route.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer extends Location {

    private String phoneNumber;

    public Consumer(String name, int latitude, int longitude, String phoneNumber) {
        super(name, latitude, longitude);
        this.phoneNumber = phoneNumber;
    }
}
