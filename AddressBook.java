import java.util.LinkedList;
import java.util.Scanner;

public class AddressBook {

    private static LinkedList<Contact> contacts = new LinkedList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        String fname, phone, email;

        while (true) {
            System.out.println("\n****************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("****************************");

            System.out.print("Please Enter a command :");
            choice = sc.next().charAt(0); // read the first character of the input string
            sc.nextLine(); // consume newline character

            switch (choice) {
                case 'A':
                case 'a': {
                    System.out.print("Enter Name :");
                    fname = sc.nextLine(); // consume the '\n' character left by previous nextInt() or next() method
                    while (true) {
                        System.out.print("Enter Phone Number :");
                        phone = sc.nextLine();
                        int index = search(contacts, phone);
                        if (index == -1) {
                            break;
                        } else {
                            System.out.println("** Phone Number already Exists **");
                        }
                    }

                    System.out.print("Enter Email :");
                    email = sc.nextLine();
                    Contact c = new Contact(fname, phone, email);
                    contacts.add(c);

                    System.out.println("** Contact Added Successfully **");
                    continue; // go back to the beginning of the while loop
                }
                case 'D':
                case 'd': {
                    System.out.print("Enter Phone Number :");
                    final String phoneNum = sc.nextLine(); // consume the '\n' character left by previous nextInt() or next() method
                    boolean removed = contacts.removeIf(contact -> contact.getPhoneNo().equals(phoneNum));
                    if (removed) {
                        System.out.println("** Contact Removed Successfully **");
                    } else {
                        System.out.println("** Contact Not Found **");
                    }
                    continue; // go back to the beginning of the while loop
                }

                case 'P':
                case 'p': {
                    System.out.println("Displaying all contacts :");

                    for (Contact c : contacts) {
                        System.out.println(c);
                    }

                    continue; // go back to the beginning of the while loop
                }
                case 'S':
                case 's': {
                    int cnt = 0;
                    System.out.print("Enter Search Word :");
                    String word = sc.next();
                    for (Contact c : contacts) {
                        if (c.getName().contains(word) || c.getEmail().contains(word)
                                || c.getPhoneNo().contains(word)) {
                            System.out.println(c);
                            cnt++;
                        }
                    }

                    if (cnt == 0) {
                        System.out.println("No contacts found with the keyword '" + word + "'");
                    }
                    continue; // go back to the beginning of the while loop
                }
                case 'Q':
                case 'q': {
                    System.out.println("Exiting the program...");
                    sc.close(); // close the scanner to free system resources
                    return;  // exit the main method and terminate the program
                }
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private static int search(LinkedList<Contact> contacts, String phone) {
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNo().equals(phone)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
