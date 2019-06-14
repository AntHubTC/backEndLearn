package stream.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by tangc on 2016/2/18.
 */
public class TextFileTest {
    public static void main(String[] args){
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[2] = new Employee("Carl Cracker", 75000, 1987, 12, 15);

        try {
            // write data
            PrintWriter out = new PrintWriter("employee.dat");
            wirteData(staff, out);
            out.close();

            //read data
            Scanner in = new Scanner(new FileReader("employee.dat"));
            Employee[] newStaff = readData(in);
            in.close();

            for (Employee employee : newStaff) {
                System.out.println(employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void wirteData(Employee[] employees,PrintWriter out) throws IOException{
        out.println(employees.length);
        for (Employee employee : employees) {
            employee.writeData(out);
        }
    }

    private static Employee[] readData(Scanner in){
        int n = in.nextInt();
        in.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = new Employee();
            employees[i].readData(in);
        }
        return employees;
    }
}

