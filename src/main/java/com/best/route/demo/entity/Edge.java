package com.best.route.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {

    private Location from;

    private Location to;

    private int cost;
}
