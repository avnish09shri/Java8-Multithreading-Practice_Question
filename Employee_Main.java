package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class Employee_Main {
    public static void main(String[] args){

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        employeeList.stream().filter(e-> e.getAge() > 25)
                .map(e-> e.getSalary()*1.25).forEach(System.out::println);

        System.out.println("------------------");
        Map<String, Long> collectgender = employeeList.stream().
                collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(collectgender);

        System.out.println("------------------");
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        System.out.println("------------------");
        Map<String, Double> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));

        System.out.println(collect);

        System.out.println("------------------");
        Optional<Employee> collectMaxSalary = employeeList.stream().
                collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

        System.out.println(collectMaxSalary.get());

        System.out.println("------------------");

        employeeList.stream().filter(e-> e.getYearOfJoining()>2015)
                .map(Employee:: getName).forEach(System.out::println);

        System.out.println("------------------");
        Map<String, Long> collectDeptEmployees = employeeList.stream().collect(Collectors.groupingBy
                (Employee::getDepartment, Collectors.counting()));

        System.out.println(collectDeptEmployees);

        System.out.println("------------------");
        Map<String, Double> collectAvgSalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collectAvgSalary);

        System.out.println("------------------");
        Optional<Employee> minAgeEmployeeByDept = employeeList.stream()
                .filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
                .min(Comparator.comparingInt(Employee::getAge));

        System.out.println(minAgeEmployeeByDept.get());

        System.out.println("------------------");
        Optional<Employee> mostExpEmp = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
        System.out.println(mostExpEmp.get());

        System.out.println("------------------");
        Map<String, Long> countMaleFemaleInDept = employeeList.stream()
                .filter(e -> e.getDepartment() == "Sales And Marketing")
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(countMaleFemaleInDept);

        System.out.println("------------------");
        Map<String, Double> avgSalaryByGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByGender);

        System.out.println("------------------");
        Map<String, List<Employee>> empNameByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(empNameByDept);

        System.out.println("------------------");
        DoubleSummaryStatistics avgTotalSalary = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(avgTotalSalary.getMax());
        System.out.println(avgTotalSalary.getAverage());
        System.out.println(avgTotalSalary.getSum());

        System.out.println("------------------");
        Map<Boolean, List<Employee>> partitionEmp = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() <= 25));
        System.out.println(partitionEmp);

        System.out.println("------------------");
        Optional<Employee> oldestEmp = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge));

        System.out.println("Employee: "+oldestEmp.get().getName()
                +"Age: "+oldestEmp.get().getAge()+" Department: "+
                oldestEmp.get().getDepartment());


    }
}
