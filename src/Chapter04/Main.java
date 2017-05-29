package Chapter04;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void getProperties(String className) throws ClassNotFoundException {
        Class<?> cl  = Class.forName(className);
        while (cl != null) {
            for (Field f : cl.getDeclaredFields())
                System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getGenericType() + " " + f.getName());
            cl = cl.getSuperclass();
        }
    }
    
    public static void testGetProperties() {
        try {
//            String s = "Point";
            getProperties(Point.class.getName());    
        }
        catch (Exception e) {
            System.out.println("Class not found");
        }
        
    }
    
    public static void findOut() {
        try {
            
            
        }
        catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        
        
    }
    public static void main(String[] args) {
//        testGetProperties();
        findOut();

    }

}
