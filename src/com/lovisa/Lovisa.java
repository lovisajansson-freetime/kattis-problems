package com.lovisa;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lovisa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String score = scanner.nextLine();
            strings.add(score);
            if (score.equals("0")) {
                break;
            }
        }
        for(String temp: strings){
            String[] line = temp.split("\\s");

        }
    }}








