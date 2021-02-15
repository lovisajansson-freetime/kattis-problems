package com.lovisa;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class c {

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
        AtomicInteger kattis = new AtomicInteger();
        int kattis2 = 0;
        for (String x : weightsStrings) {
            IntStream skip = Arrays.stream(x.split("\\s+")).mapToInt(Integer::valueOf).skip(1);
            int[] ints = skip.toArray();
            int total= Arrays.stream(ints).sum();
            int target = total / 2;
            List<int[]> test = withOutFirst(ints);
            ArrayList<Integer> summor = new ArrayList<>();
            test.stream().forEach(ti ->{
                summor.add(Arrays.stream(ti).sum());
                if (Arrays.stream(ti).sum() == target) {
                    kattis.set(Arrays.stream(ti).sum());
            }});
            int i1 = Collections.max(summor);
            System.out.println(i1);


            if(kattis.get() ==0){
                int base = summor.get(0);
                for(Integer i : summor) {
                    int diff = Math.abs(i - target);
                    if (diff < base) {
                        base = diff;
                    }
                }
                kattis2 = target - base;
                kattis.set(total - kattis2);
            }
            System.out.println(kattis +" "+ (kattis2));
            }


            }

    public static List<int[]> withOutFirst(int [] ints) {
        //base case is smallest combo = empty subarray
        if (ints.length== 0) {
            ArrayList<int[]> outer = new ArrayList<int[]>();
            int [] inner = new int[]{0};
            outer.add(inner);
            return outer;
        }
            int first = ints[0];
            List<int[]> returnlist = new ArrayList<>();
            int[] rest = Arrays.copyOfRange(ints, 1, ints.length);
            List<int[]> withoputfirts= withOutFirst(rest);
        for (int[] temp: withoputfirts) {
            int[] clone = Arrays.copyOf(Arrays.stream(ints).skip(1).toArray(),ints.length);
            clone[clone.length-1]=first;
            if(!returnlist.contains(clone)) {
                returnlist.add(clone);
            }else if(!returnlist.contains(temp)) {
                returnlist.add(temp);
            }

        }
            return returnlist;

        }
    }


