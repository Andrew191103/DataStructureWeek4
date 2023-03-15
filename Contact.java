public class Contact {

    //Declaring instance variables
    private String name;
    private String phoneNo;
    private String email;

    //Parameterized constructor
    public Contact(String name, String phoneNo,
                   String email) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;

    }
    /**
     * @return the address
     */

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toString method is used to display the contents of an object inside it
    public String toString() {
        return name + " " + phoneNo + " " + email+" ";
    }

}