package Operations;
import java.util.*;

// main class 
public class Main{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Addemployee> empList = new ArrayList<>();
        System.out.println("**************** Welcome to Employee Management Portal *****************");
        while (true){
        System.out.println();
        System.out.println("1. Add employee details \n 2. View employee details \n 3. Update employee details \n 4. Exit");
        
        
            int n = sc.nextInt();
            switch(n){
                case 1:
                    System.out.println("Enter id: ");
                    int id = sc.nextInt();
                    System.out.println("Enter name: ");
                    String name = sc.next();
                    System.out.println("Enter salary: ");
                    float salary = sc.nextFloat();
                    System.out.println("Enter designation: ");
                    String designation = sc.next();
                    Addemployee add = new Addemployee(name, id, designation, salary);
                    empList.add(add);
                    System.out.println("Employee added successfully!");
                    break;
                    

                case 2:
                    System.out.print("Enter employee ID to view: ");
                    int viewId = sc.nextInt();
                    Viewemployee viewer = new Viewemployee(empList);
                    viewer.displayById(viewId);
                    break;
                case 3:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = sc.nextInt();
                    Updateemployee updater = new Updateemployee(empList);
                    updater.updateById(updateId, sc);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid number.... Please enter a valid number :)");
            }
        }
    }
}
