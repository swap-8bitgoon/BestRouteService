package com.best.route.demo.manager;

import com.best.route.demo.entity.Edge;
import com.best.route.demo.entity.Location;
import lombok.AllArgsConstructor;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


@AllArgsConstructor
public class DepthFirstSearchManager {

    Location deliveryPartnerLocation;
    Map<Location, List<Edge>> graph;
    Map<String, Integer> pathToCost;

    public void findMinCostPath() {
        helperDFS(deliveryPartnerLocation, graph, 0, new LinkedHashSet<>());
        String result = ""; int minCost = Integer.MAX_VALUE;
        for (String paths : pathToCost.keySet()) {
            int currentCost = pathToCost.get(paths);
            if (currentCost < minCost) {
                minCost = currentCost;
                result = paths;
            }
        }

        System.out.println("Best Path:");
        System.out.println(result + " Cost: " + minCost);
    }

    public void helperDFS(Location currentPosition, Map<Location, List<Edge>> graph,
                              int currCost, Set<Location> visited) {
        if (visited.size() == graph.size()) {
            StringBuilder currPath = new StringBuilder();
            for (Location location : visited) {
                currPath.append(location.getName()).append(" - ");
            }
            pathToCost.put(currPath.toString(), currCost);
            return;
        }

        if (visited.contains(currentPosition)) {
            return;
        }

        visited.add(currentPosition);
        for (Edge edge : graph.get(currentPosition)) {
            helperDFS(edge.getTo(), graph, currCost + edge.getCost(), visited);
        }
        visited.remove(currentPosition);
    }
}
