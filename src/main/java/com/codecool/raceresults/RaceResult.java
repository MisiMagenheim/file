package com.codecool.raceresults;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


class RaceResult {

    public List<String> calculateRacerResults(String fileName){
        List<String> raw;
        List<F1Driver> f1Drivers = new ArrayList<>();
        try {
            raw = Files.readAllLines(Paths.get(fileName));
            for (int i = 0; i < raw.size(); i++) {
                f1Drivers.add(getF1Driver(raw.get(i)));
            }
        } catch (IOException ioException) {
            System.out.println("File not found!");
        }
        return f1Drivers.stream()
                .map(F1Driver::getName)
                .collect(Collectors.toList());
    }

    private static F1Driver getF1Driver(String line) {
        String[] f1driverExam = line.split(",");
        return new F1Driver(f1driverExam[0],
                Integer.parseInt(f1driverExam[1])
                        + Integer.parseInt(f1driverExam[2])
                        + Integer.parseInt(f1driverExam[3])
                        + Integer.parseInt(f1driverExam[4]));
    }

}
