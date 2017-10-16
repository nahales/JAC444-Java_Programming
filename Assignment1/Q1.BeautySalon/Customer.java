package beautysalon;

/**
 *
 * @author Nahal
 */
public class Customer {
    private String name;
    private Boolean member = false;
    private String memberType;

    public Customer(String name) {
      this.name = name;
    }

    public String getName(){
      return name;
    }

    public Boolean isMember() {
      return member;
    }

    public void setMember(Boolean member) {
      this.member = member;
    }

    public String getMemberType() {
      return memberType;
    }

    public void setMemberType(String memberType) {
      this.memberType = memberType;
    }

    public String toString() {
    	String resultStr = "Name: '" + name + "'\n" + "Membership: " + memberType;
    	return resultStr;
    }
  }
