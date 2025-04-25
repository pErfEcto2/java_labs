package lab3;


interface Measurable {
    double getMeasure();
}

class Employee implements Measurable {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "name: " + name + "; salary: " + salary;
    }
}

class task1_and_2 {
    public static double average(Measurable[] objects) {
        if (objects == null || objects.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (Measurable obj : objects) {
            sum += obj.getMeasure();
        }

        return sum / objects.length;
    }

    public static Measurable largest(Measurable[] objects) {
        if (objects == null || objects.length == 0) {
            return null;
        }

        double max = Double.MIN_VALUE;
        Measurable target = null;
        for (Measurable obj : objects) {
            if (obj.getMeasure() > max) {
                max = obj.getMeasure();
                target = obj;
            }
        }

        return target;
    }

    public static void main(String[] args) {
        int n = 10;
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++)
            employees[i] = new Employee("Name " + i, i * 10);

        System.out.println("Average salary is: " + average(employees));
        Employee e = (Employee) largest(employees);
        System.out.println("An employee with the biggest salary is: " + e.getName());
    }
}