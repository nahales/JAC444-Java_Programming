package beautysalon;
import java.util.Scanner;
import java.util.Date;
/**
 *
 * @author Nahal
 */
public class BeautySalon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	String response = "";
    	do {
        	System.out.println("\nCustomer");
        	
        	System.out.println("Name: ");
        	String customerName = in.next();
        	Customer customer  = new Customer(customerName);
        	
        	System.out.println("Is this customer a member?(y/n) ");
        	String member = in.next();
        	if (member.equalsIgnoreCase("y")) {
        		customer.setMember(true);
        	}
        	else {
        		customer.setMember(false);
        	}
        	
        	if(customer.isMember()) {
        		System.out.println("Membership: ");
            	String membership = in.next();
            	customer.setMemberType(membership);
        	}
        	else {
        		customer.setMemberType("None");
        	}
        	
        	Visit visit = new Visit(customer, new Date());
        	
        	System.out.println("Service Expense: ");
        	double serviceExp = in.nextDouble();
        	visit.setServiceExpense(serviceExp);
        	
        	System.out.println("Product Expense: ");
        	double productExp = in.nextDouble();
        	visit.setProductExpense(productExp);
        	
        	System.out.println(visit);
        	
        	System.out.println("\nDo you want to add another bill?(y/n)");
        	response = in.next();
    	} while(response.equalsIgnoreCase("y"));
    }
}
