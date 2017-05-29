package Chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Main {

    public static double average(Measurable[] objects) {
        if (objects.length == 0)
            return 0;
        double sum = 0;
        for (Measurable employee : objects)
            sum += employee.getMeasure();
        return sum / objects.length;
    }
    
    public static Measurable largest(Measurable[] objects) {
        Employee largest = (Employee) objects[0];
        for (Measurable employee : objects)
            if (employee.getMeasure() > largest.getMeasure())
                largest = (Employee) employee;
        System.out.println("Largest employee: " + largest.getName());
        return largest;
    }
    
    public static IntSequence paramSequence(int... values) {
        return IntSequence.of(values);
    }
    
    public static void testParamSequence() {
        IntSequence param = paramSequence(1,2,3,4,5,6);
        while (param.hasNext())
            System.out.println(param.next());
    }
    
    public static void testConstantSequence() {
        IntSequence constantSequence = IntSequence.constant(1);
        for (int i = 0; i < 100; i++)
            System.out.println(constantSequence.next());
    }
    
    public static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        int i = 0;
        while (i < strings.size() - 1) {
            if (comp.compare(strings.get(i), strings.get(i + 1)) > 0) {
                Collections.shuffle(strings);
                i = 0;
            }
            else
                i++;
        }
    }
    
    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++)
            action.accept(i);
    }
    
    public static void testRepeat() {
        repeat(10, i -> System.out.println(i));
    }
    
    public static void testGreeter() {
        Runnable greeter1 = new Greeter(10, "Trump");
        Runnable greeter2 = new Greeter(10, "Obama");
        Executor exec = Executors.newCachedThreadPool();
        exec.execute(greeter1);
        exec.execute(greeter2);
    }
    
    public static void runTogether(Runnable... tasks) {
        Executor exec = Executors.newCachedThreadPool();
        for (Runnable task : tasks) {
            exec.execute(task); // OR
//            Thread thread = new Thread(task);
//            thread.start();
        }
    }
    
    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks)
            task.run();
    }
    
    public static void testRunTogether() {
        Runnable task1 = () -> repeat(10, i -> System.out.println("task1: " + i));
        Runnable task2 = () -> repeat(10, i -> System.out.println("task2: " + i));
        runTogether(task1, task2);
    }
    
    public static void testRunInOrder() {
        Runnable task1 = () -> repeat(10, i -> System.out.println("task1: " + i));
        Runnable task2 = () -> repeat(10, i -> System.out.println("task2: " + i));
        runInOrder(task1, task2);
    }
    
    public static void listDirectory() {
        
//        Implement FileFilter
        FileFilter filter = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory())
                    return true;
                else
                    return false;
            }
        };
        File[] files = new File("/").listFiles(filter);
//        Or use lambda expression
//        File[] files = new File("/").listFiles(pathname -> pathname.isDirectory() ? true: false);
        for (File dir : files)
            System.out.println(dir.getName());
    }
    
    public static void listFiles() {
        FilenameFilter filter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                 return name.endsWith(".ape");
            }
            
        };
        String[] files = new File("e:/music").list(filter);
//        Or use lambda expression
//        String[] files = new File("e:/music").list((dir, name) -> name.endsWith(".ape"));
        for (String file : files)
            System.out.println(file);
    }
    
    public static void sortFiles() {
        File[] files = new File("e:/music").listFiles();
//        Use methods reference
//        Arrays.sort(files, Comparator.comparing(File::isDirectory).reversed().thenComparing(File::getName));
        Arrays.sort(files, (first, second) -> {
            File f1 = (File) first;
            File f2 = (File) second;
            if (f2.isDirectory())
                if (f1.isDirectory())
                    return f1.getName().compareTo(second.getName());
                else
                    return 1;
            else
                if (f1.isDirectory())
                    return -1;
                else
                    return f1.getName().compareTo(f2.getName());
        });
        for (File file : files)
            System.out.println(file.getName());
            
    }
    
    public static Runnable runTasks(Runnable[] tasks) {
        return () -> {
            for (Runnable task : tasks)
                task.run();
        };
    }
    
    public static void main(String[] args) {
//        testConstantSequence();
//        testGreeter();
//        testRepeat();
//        testRunTogether();
//        testRunInOrder();
//        listDirectory();
//        listFiles();
        sortFiles();
    }
}
