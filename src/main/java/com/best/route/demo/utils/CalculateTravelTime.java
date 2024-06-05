package com.best.route.demo.utils;

import com.best.route.demo.entity.Location;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CalculateTravelTime {

    public static int findTravelTime(Location first, Location second) {
        int xAxisDiff = (first.getLatitude() - second.getLatitude());
        int yAxisDiff = (first.getLongitude() - second.getLongitude());
        return (int) Math.sqrt((xAxisDiff * xAxisDiff) + (yAxisDiff * yAxisDiff));
    }
}
