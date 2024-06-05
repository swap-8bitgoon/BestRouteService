package com.best.route.demo.manager;

import com.best.route.demo.entity.Consumer;
import com.best.route.demo.entity.Edge;
import com.best.route.demo.entity.Location;
import com.best.route.demo.entity.Restaurant;
import lombok.AllArgsConstructor;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.best.route.demo.utils.CalculateTravelTime.findTravelTime;

@AllArgsConstructor
public class GraphCreationManager {

    Location deliveryPartnerLocation;
    Restaurant[] restaurants;
    Consumer[] consumers;

    public Map<Location, List<Edge>> createGraph() {

        Map<Location, List<Edge>> edges = new HashMap<>();
        Location[] nodesInGraph = new Location[] {restaurants[0], restaurants[1], consumers[0], consumers[1]};

        for (Location from : nodesInGraph) {
            for (Location to : nodesInGraph) {
                if (from.equals(to)) {
                    continue;
                }
                createEdge(from, to, edges);
                createEdge(to, from, edges);
            }
        }

        createEdge(deliveryPartnerLocation, restaurants[0], edges);
        createEdge(deliveryPartnerLocation, restaurants[1], edges);

        return edges;
    }

    public static void createEdge(Location from, Location to, Map<Location, List<Edge>> edges) {
        int travelTime = findTravelTime(from, to);
        List<Edge> neighbours = edges.getOrDefault(from, new ArrayList<>());
        neighbours.add(new Edge(from, to, travelTime));
        edges.put(from, neighbours);
    }
}
