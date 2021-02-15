package com.lovisa;

import java.util.ArrayList;
import java.util.Scanner;

public class problemb {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String oneString = scanner.nextLine();
            if (oneString.equals("0")) {
                break;
            }
            strings.add(oneString);
        }
        //för varje string i listan, dela upp paren mha whitespace
        for(String temp: strings){
            String[] line = temp.split("\\s");
            String s = line[0];
            String l = line[1];

            int first = doesitexist(s, l);
            int second = existsAfterDelete(s, l);
            int third = existsAfterInsert(s, l);
            System.out.println(first + " "+second+" "+third);
        }

    }
    public static int doesitexist(String sub, String full){
        int firstCount=0, startIndex=0;
        while((startIndex=full.indexOf(sub,startIndex))!=-1){
            firstCount++;
            startIndex++;
        }
        return firstCount;
    }
    //för varje index i String, ta bort en char och check om den nya stringen existerar string 2.
    public static int existsAfterDelete(String sub, String full){
        ArrayList<String> firstArray = new ArrayList<>();
        StringBuilder stringBuilder;
        int count = 0;
        for(int i = 0; i<sub.length();i++){
            stringBuilder = new StringBuilder(sub);
            stringBuilder.deleteCharAt(i);
            if(!firstArray.contains(stringBuilder.toString())){
                firstArray.add(stringBuilder.toString());
                count +=doesitexist(stringBuilder.toString(),full);

            }

        }
        return count;

    }
    //för varje index i String, insert A G C T och check om den nya stringen existerar string 2.
    public static int existsAfterInsert(String sub, String full){
        ArrayList<String> secondArray = new ArrayList<>();
        StringBuilder stringBuilder;
        char[] match = {'A','G','C','T'};
        int count =0;
        for(int i= 0; i<=sub.length();i++) {
            for (char c : match) {
                stringBuilder = new StringBuilder(sub);
                stringBuilder.insert(i, c);
                if (!secondArray.contains(stringBuilder.toString())) {
                    secondArray.add(stringBuilder.toString());
                    count += doesitexist(stringBuilder.toString(), full);

                }
            }
        }
        return count;
    }
}
