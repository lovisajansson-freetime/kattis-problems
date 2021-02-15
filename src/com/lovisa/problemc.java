package com.lovisa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class problemc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> weightsStrings = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String item = scanner.nextLine();

            if (item.equals("0")) {
                break;
            }
            weightsStrings.add(item);
        }
        for (String x : weightsStrings) {
            Optional<String> nbrOfItems = Arrays.stream(x.split("\\s+")).findFirst();
            int items = Integer.parseInt(nbrOfItems.get());
            int kattis = 0;
            int kattis2 = 0;
            IntStream sortedItems = Arrays.stream(x.split("\\s+")).mapToInt(Integer::valueOf).skip(1)
                    .sorted();
            int[] ints = sortedItems.toArray();
            int base= 0;
        }
    }
    public static void getcombo(){

    }
}