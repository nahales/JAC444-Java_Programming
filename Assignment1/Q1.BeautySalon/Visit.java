package beautysalon;
import java.util.Date;
import java.text.*;
/**
 *
 * @author Nahal
 */
public class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;
    private static DecimalFormat df1 = new DecimalFormat("");
    private static DecimalFormat df2 = new DecimalFormat("##");
    
    public Visit(Customer customer, Date date) {
      this.customer = customer;
      this.date = date;
    }
    
    public double getServiceExpense(){
      return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
      this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
      return productExpense;
    }

    public void setProductExpense(double productExpense) {
      this.productExpense = productExpense;
    }

    public double getTotalExpense() {
      double serviceDiscountAmt = serviceExpense * DiscountRate.getServiceDiscountRate(customer.getMemberType());
      double productDiscountAmt = productExpense * DiscountRate.getProductDiscountRate(customer.getMemberType());
      double totalExpense = (serviceExpense - serviceDiscountAmt) + (productExpense - productDiscountAmt);
      return totalExpense;
    }

    public String toString() {
      SimpleDateFormat sdf = new SimpleDateFormat("E yyyy/MM/dd HH:mm:ss");
      String dateStr = sdf.format(date);
	  return "\nCustomer's Bill\n" + customer.toString() + 
                "\nDate: " + dateStr +
                "\nService Expense: " + serviceExpense +
                "\nDiscount on Service: %" + df1.format(DiscountRate.getServiceDiscountRate(customer.getMemberType())*100) +
                "\nProduct Expense: " + productExpense +
                "\nDiscount on Product: %" + df1.format(DiscountRate.getProductDiscountRate(customer.getMemberType())*100) + 
                "\nTotal After Discount: " + df2.format(getTotalExpense());
    }
}
