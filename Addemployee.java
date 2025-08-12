package Operations;
import java.util.*;
import java.util.ArrayList;
// abstract class for employee
abstract class Employeedetails{
    String name;
    int id;
    String designation;
    float salary;
    public Employeedetails(String name, int id, String designation, float salary){
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }
    public abstract void displaydetails();
}

// class for adding employee details
class Addemployee extends Employeedetails {
    public Addemployee(String name, int id, String designation, float salary){
        super(name, id, designation, salary);
    }
    public void displaydetails(){
        System.out.println("ID          : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Designation : " + designation);
        System.out.println("Salary      : ₹" + salary);
    }
    
}

// class for displaying employee details
class Viewemployee{
    
    ArrayList<Addemployee> list;

    public Viewemployee(ArrayList<Addemployee> list) {
        this.list = list;
    }

    public void displayById(int searchId) {
        boolean found = false;
        for (Addemployee emp : list) {
            if (emp.id == searchId) {
                System.out.println("\nEmployee Found:");
                emp.displaydetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nEmployee with ID " + searchId + " is not found.");
        }
    }
    
}

// updating or changing employee details
// Class to update employee
class Updateemployee {
    ArrayList<Addemployee> list;

    public Updateemployee(ArrayList<Addemployee> list) {
        this.list = list;
    }

    public void updateById(int searchId, Scanner sc) {
        boolean found = false;
        for (Addemployee emp : list) {
            if (emp.id == searchId) {
                System.out.println("\nEmployee Found. Current details:");
                emp.displaydetails();

                System.out.println("\nEnter new name (or press Enter to skip): ");
                sc.nextLine(); // Consume leftover newline
                String newName = sc.nextLine();
                if (!newName.isEmpty()) {
                    emp.name = newName;
                }

                System.out.println("Enter new designation (or press Enter to skip): ");
                String newDesignation = sc.nextLine();
                if (!newDesignation.isEmpty()) {
                    emp.designation = newDesignation;
                }

                System.out.println("Enter new salary (or enter -1 to skip): ");
                float newSalary = sc.nextFloat();
                if (newSalary >= 0) {
                    emp.salary = newSalary;
                }

                System.out.println("\nEmployee details updated successfully:");
                emp.displaydetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nEmployee with ID " + searchId + " not found.");
        }
    }
}