package com.best.route.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant extends Location {

    private int averageTimeToPrepare;

    public Restaurant(String name, int latitude, int longitude, int averageTimeToPrepare) {
        super(name, latitude, longitude);
        this.averageTimeToPrepare = averageTimeToPrepare;
    }
}
