package Chapter01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.*;

public class Main {

    public static void printInt() {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.printf("%o, %d, %x, %a", number, number, number, 1.0/number);
        in.close();
    }
    
    public static void cacuMod() {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println("Using \"%\": " + number % 360);
        System.out.println("Using Math.floorMod: " + Math.floorMod(number, 360));
        in.close();
    }
    
    public static void findMax() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        in.close();
        int max = a > b ? a : b;
        max = max > c ? max : c;
        System.out.println("Max is: " + max);
    }
    
    public static void mDouble() {
        System.out.println("Min positive value: " + Math.nextUp((double)0));
//        System.out.println("Min positive value: " + Double.MIN_VALUE);
        System.out.println("Max positive value: " + Math.nextDown(Double.POSITIVE_INFINITY));
//        System.out.println("Max positive value: " + Double.MAX_VALUE);
    }
    
    public static void DoubleToInt() {
        double x = Double.MAX_VALUE / 2;
        System.out.println((int)x);
    }
    
    public static void cacuFactorial(int num) {
        BigInteger ret = BigInteger.valueOf(num);
        for (int i = num - 1; i > 0; i--) {
            ret = ret.multiply(BigInteger.valueOf(i));
        }
        System.out.println(ret);
    }
    
    public static void getAllSubString(String string) {
        for (int i = 0; i < string.length(); i++)
            for (int j = string.length(); j > i; j--)
                System.out.println(string.substring(i, j));
    }
    
    public static void stringEqualTest() {
        String a = "world";
        String b = "world".trim();
        System.out.println("a == b? " + (a == b) );
        System.out.println("a equals to b? " + a.equals(b));
    }
    
    public static void notASCII(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) > 127)
                System.out.println(string.charAt(i) + ": " + string.codePointAt(string.offsetByCodePoints(0, i)));
        }
    }
    
    public static void lottery() {
//        Integer[] nums = (Integer[])Stream.iterate(1, n -> n + 1).limit(49).toArray();
        int[] nums = new int[49];
        int[] rets = new int[6];
        for (int i = 0; i < 49; i++) 
            nums[i] = i + 1;
        int count = 0;
        while (count < 6) {
            int index = (int)(Math.random() * 49);
            if (nums[index] == 0)
                continue;
            rets[count] = nums[index];
            nums[index] = 0;
            count++;
        }
        Arrays.sort(rets);
        System.out.println(Arrays.toString(rets));
    }
    
    public static void cube() {
        int[][] nums = new int[4][];
        int[] counts = new int[10];
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (in.hasNextLine()) {
            String l = in.nextLine();
            if ("".equals(l))
                break;
            IntStream line = Stream.of(l.split(" ")).mapToInt(e -> Integer.parseInt(e));
            nums[i] = line.toArray();
            for (int j = 0; j < 4; j++) {
                counts[i] += nums[i][j];
                counts[j+4] += nums[i][j];
                if (i == j)
                    counts[8] += nums[i][j];
                else if (i + j == 3)
                    counts[9] += nums[i][j];
            }
            i++;
        }
        in.close();
        if (Arrays.stream(counts).distinct().count() == 1)
            System.out.println("This is a cube.");
        else
            System.out.println("This is not a cube");
    }
    
    public static void pascalTriangle(int n) {
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        pascal.add(first);
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> level = new ArrayList<>();
            level.add(1);
            for (int j = 1; j < i; j++) {
                level.add(pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j));
            }
            level.add(1);
            pascal.add(level);
        }
        System.out.println(pascal);
    }
    
    public static double average(double first, double... rest) {
        return (first + Arrays.stream(rest).sum()) / (1 + rest.length);
    }
    
    public static void main(String[] args) {
        System.out.println("Chapter 01 tests. Please uncommit lines you want to test in main function.");
//        printInt();
//        cacuMod();
//        findMax();
//        mDouble();
//        DoubleToInt();
//        cacuFactorial(1000);
//        getAllSubString("wuzeran");
//        stringEqualTest();
//        notASCII("你好, hello!");
//        lottery();
//        cube();
//        pascalTriangle(10);
//        System.out.println(average(1,2,3,4,5,6));
    }

}
