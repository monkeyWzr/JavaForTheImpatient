package Chapter02;

import java.time.LocalDate;

public class Main {

    public static void cal() {
        LocalDate date = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 1);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int value = date.getDayOfWeek().getValue() % 7;
        for (int i = 0; i < value; i++)
            System.out.print("    ");
        while (date.getMonthValue() == LocalDate.now().getMonthValue()) {
            System.out.printf("%-4d", date.getDayOfMonth());
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 7)
                System.out.println();
        }
    }
    
    public static void testPointWithMutator() {
        PointWithMutator p = new PointWithMutator(3, 4).translate(1, 3).scale(0.5);
        System.out.print(p);
    }
    
    public static void testPointWithAccessor() {
        PointWithAccessor p = new PointWithAccessor(3, 4).translate(1, 3).scale(0.5);
        System.out.print(p);
    }
    
    public static void main(String[] args) {
//        cal();
//        testPointWithMutator();
        testPointWithAccessor();

    }

}
