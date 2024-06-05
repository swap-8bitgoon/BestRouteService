package com.best.route.demo.service;

import com.best.route.demo.entity.Consumer;
import com.best.route.demo.entity.Edge;
import com.best.route.demo.entity.Location;
import com.best.route.demo.entity.Restaurant;
import com.best.route.demo.manager.DepthFirstSearchManager;
import com.best.route.demo.manager.GraphCreationManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestRouteService {

    public static void findBestRoute() {

        Restaurant R1 = new Restaurant("KFC", 15, 20, 30);

        Restaurant R2 = new Restaurant("Dominos", 11, 30, 25);

        Consumer C1 = new Consumer("Alex", 30, 25, "123");

        Consumer C2 = new Consumer("John", 27, 40, "456");

        Location deliveryPartnerLocation = Location.builder().latitude(10).longitude(10).name("Aman").build();

        GraphCreationManager graphCreationManager = new GraphCreationManager(deliveryPartnerLocation,
                                                                             new Restaurant[] {R1, R2},
                                                                             new Consumer[] {C1, C2});

        Map<Location, List<Edge>> edges = graphCreationManager.createGraph();

        DepthFirstSearchManager depthFirstSearchManager = new DepthFirstSearchManager(deliveryPartnerLocation,
                                                                                      edges,
                                                                                      new HashMap<>());

        depthFirstSearchManager.findMinCostPath();
    }
}
