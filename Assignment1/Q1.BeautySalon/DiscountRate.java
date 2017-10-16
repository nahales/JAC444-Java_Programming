package beautysalon;

/**
 *
 * @author Nahal
 */
public class DiscountRate {

    private static double serviceDiscountPremium = 0.2;
    private static double serviceDiscountGold = 0.15;
    private static double serviceDiscountSilver = 0.1;
    private static double productDiscountPremium = 0.1;
    private static double productDiscountGold = 0.1;
    private static double productDiscountSilver = 0.1;

    public static double getServiceDiscountRate(String memberType) {
      if (memberType.trim().equalsIgnoreCase("Premium")) {
        return serviceDiscountPremium;
      }
      if (memberType.trim().equalsIgnoreCase("Gold")) {
        return serviceDiscountGold;
      }
      if (memberType.trim().equalsIgnoreCase("Silver")) {
        return serviceDiscountSilver;
      }
      else {
        return 0;
      }
    }

    public static double getProductDiscountRate(String memberType){
    	if (memberType.trim().equalsIgnoreCase("Premium")) {
        return productDiscountPremium;
      }
      if ((memberType.trim()).equalsIgnoreCase("Gold")) {
        return productDiscountGold;
      }
      if ((memberType.trim()).equalsIgnoreCase("Silver")) {
        return productDiscountSilver;
      }
      else {
    	  return 0;
      }
    }
}
