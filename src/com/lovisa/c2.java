package com.lovisa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class c2 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> weightsStrings = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String item = scanner.nextLine();

            if (item.equals("0")) {
                break;
            }
            weightsStrings.add(item);
        }
        int kattis = 0;
        int kattis2 = 0;
        for (String x : weightsStrings) {
            IntStream skip = Arrays.stream(x.split("\\s+")).mapToInt(Integer::valueOf).skip(1);
            List<Integer> ints = skip.boxed().collect(Collectors.toList());
            int total = ints.stream().mapToInt(integer -> integer).sum();
            int target = total / 2;
            HashMap<ArrayList<Integer>,Integer> test = findCombos(ints);
            ArrayList<Integer> summor = new ArrayList<Integer>(test.values());
            summor.removeIf(Integer -> Integer==0);
            boolean named = summor.stream().anyMatch(n -> n == target);
            if (named == true) {
                assignKittens(target,total-target);
            } else {
                int base = summor.get(0);
                for (Integer integer : summor) {
                    if(integer>target){
                        int diff = Math.abs(integer - target);
                        if (diff < base) {
                            base = diff;
                        }
                    }
                }

                int katti1 = target + base;
                int katt2 = total-katti1;
                assignKittens(katti1,katt2);
            }
        }


    }
    public static void  assignKittens(int kattis, int kattis2){
        if(kattis<kattis2){
            int temp = kattis;
            kattis=kattis2;
            kattis2=temp;
        }
        System.out.println(kattis +" "+ kattis2);
    }

    public static HashMap<ArrayList<Integer>,Integer> findCombos(List<Integer> ints) {
        //base case is smallest combo = empty subarray
        if (ints.size() == 0) {
            HashMap<ArrayList<Integer>,Integer> outer = new HashMap<>();
            ArrayList<Integer> inner = new ArrayList<Integer>();
            Integer integer = null;
            outer.put(inner,integer);
            return outer;
        }
        int first = ints.get(0);
        HashMap<ArrayList<Integer>,Integer> returnList = new HashMap<>();
        List<Integer> rest = ints.subList(1, ints.size());
        HashMap<ArrayList<Integer>,Integer> withoutFirst = findCombos(rest);
        for (ArrayList<Integer> withoutFirstTemp : withoutFirst.keySet()
        ) {
            int withoutFirstTempSum = withoutFirstTemp.stream().mapToInt(Integer::intValue).sum();
            ArrayList<Integer> withFirst = new ArrayList<Integer>(withoutFirstTemp);
            withFirst.add(first);
            int withFirstSum = withFirst.stream().mapToInt(Integer::intValue).sum();

                if(!returnList.containsValue(withoutFirstTempSum)){
                    returnList.put(withoutFirstTemp, withoutFirstTempSum);
                }
                if(!returnList.containsValue(withFirstSum)){
                    returnList.put(withFirst,withFirstSum);


            }

        }
        return returnList;

    }
}

