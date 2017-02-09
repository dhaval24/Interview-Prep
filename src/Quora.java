import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dhaval on 11/13/2016.
 */
public class Quora {

    private static class Employee implements Comparable{
        int lev;
        int exp;

        public Employee(int lev, int exp){
            this.lev = lev;
            this.exp = exp;
        }

        @Override
        public int compareTo(Object o) {
            return ((Employee)o).lev - this.lev;
        }

        public String toString() {
            return "{"+lev+"-"+exp+"}";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int noLines = Integer.valueOf(sc.nextLine());
        Employee[] employees = new Employee[noLines];
        for (int i = 0; i < noLines; i++) {
            String[] current = sc.nextLine().split(" ");
            System.out.println(current[0]);
            System.out.println(current[1]);
            employees[i] = new Employee(Integer.valueOf(current[0]), Integer.valueOf(current[1]));
        }

        Arrays.sort(employees);
        System.out.println(Arrays.toString(employees));
    }

}

