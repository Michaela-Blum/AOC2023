import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Dec_1 {

    public static void main(String[] args) {
        Scanner scan;
        int completeNumber = 0;
        try {
            scan = new Scanner(new File("C:\\Users\\Nina\\IdeaProjects\\AOC2023\\src\\ImportData1.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scan.hasNext()) {

            completeNumber += findNumber(scan.nextLine());
        }
        System.out.println(completeNumber);

        System.out.println(findNumber("1abc2"));
        System.out.println(findNumber("fivethreeonezblqnsfk1"));
        System.out.println(findS("six"));
        System.out.println(findS("sevenssss"));
        System.out.println(findS("one"));
        System.out.println(findNumber("six7"));
        System.out.println(stringparser3000("threeabcfourfive8"));

    }
    static int findNumber(String s) {
        s = stringparser3000(s);
        int completeNumber = 0;
        String first = "";
        String second = "";
        for (int i = 0; i < s.length(); i++) {
            String character = s.charAt(i) + "";

            if (character.matches("[0-9]")) {
                first = Integer.valueOf(character) + "";
                s = s.substring(i);
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            String string = s.charAt(i) + "";
            if (string.matches("[0-9]")) {
                second = Integer.valueOf(string) + "";
            }
        }
        String numberString = ("" + first + second);
        int number = Integer.valueOf(numberString);
        if (first == "" || second == "") {
            return 0;
        }
        return number;
    }

    static int findS (String s) {
        String s1;
        String s2;
        if (s.length() >= 3) {
            s1 = s.substring(0,3);
            if (s1.equals("six")) {
                return 6;
            }
        }
        if (s.length() >= 5) {
            s2 = s.substring(0,5);
            if (s2.equals("seven")) {
                return 7;
            }
        }
        return -1;
    }

    static int findO (String s) {
        String s1;
        if (s.length() >= 3) {
            s1 = s.substring(0,3);
            if (s1.equals("one")) {
                return 1;
            }
        }
        return -1;
    }

    static int findT (String s) {
        String s1;
        String s2;
        if (s.length() >= 3) {
            s1 = s.substring(0,3);
            if (s1.equals("two")) {
                return 2;
            }
        }
        if (s.length() >= 5) {
            s2 = s.substring(0,5);
            if (s2.equals("three")) {
                return 3;
            }
        }
        return -1;
    }

    static int findF (String s) {
        String s1;
        if (s.length() >= 4) {
            s1 = s.substring(0,4);
            if (s1.equals("four")) {
                return 4;
            }
            if (s1.equals("five")) {
                return 5;
            }
        }
        return -1;
    }
    static int findE (String s) {
        String s2 = "";
        if (s.length() >= 5) {
            s2 = s.substring(0,5);
            if (s2.equals("eight")) {
                return 8;
            }
        }
        return -1;
    }

    static int findN (String s) {
        String s1;
        if (s.length() >= 4) {
            s1 = s.substring(0,4);
            if (s1.equals("nine")) {
                return 9;
            }
        }
        return -1;
    }

    static String stringparser3000 (String s) {
        String returnString = "";
        for (int i = 0; i < s.length(); i++) {
            String character = s.charAt(i) + "";
            switch (character) {
                case "s" :
                    returnString = addToString(returnString, findS(s.substring(i)));
                    continue;
                case "o" :
                    returnString = addToString(returnString, findO(s.substring(i)));
                    continue;
                case "t" :
                    returnString = addToString(returnString, findT(s.substring(i)));
                    continue;
                case "f":
                    returnString = addToString(returnString, findF(s.substring(i)));
                    continue;
                case "e":
                    returnString = addToString(returnString, findE(s.substring(i)));
                    continue;
                case "n":
                    returnString = addToString(returnString, findN(s.substring(i)));
                    continue;
                default:
                    if (character.matches("[0-9]")) {
                        returnString = addToString(returnString, Integer.valueOf(character));
                    }

            }
        }


        return returnString;
    }

    static String addToString(String base,int value) {
        if (value >= 0) {
            return base + value;
        }
        return base;
    }
   
}
