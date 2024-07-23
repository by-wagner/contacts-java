package contacts.app;

import contacts.model.Contact;
import contacts.model.Person;
import contacts.model.Organization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {
    private static List<Contact> phoneBook = new ArrayList<>();
    private static File file;

    public static void main(String[] args) {
        if (args.length > 0) {
            file = new File(args[0]);
            loadContacts();
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("[menu] Enter action (add, list, search, count, exit):");
            String action = scanner.nextLine().toLowerCase();
            System.out.println();

            switch (action) {
                case "add":
                    addContact(scanner);
                    break;
                case "list":
                    listContacts(scanner);
                    break;
                case "search":
                    searchContacts(scanner);
                    break;
                case "count":
                    countContacts();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown action. Please try again.");
            }
            System.out.println();
        }
    }

    private static void addContact(Scanner scanner) {
        System.out.println("Enter the type (person, organization):");
        String type = scanner.nextLine().toLowerCase();

        if (type.equals("person")) {
            System.out.println("Enter the name:");
            String name = scanner.nextLine();

            System.out.println("Enter the surname:");
            String surname = scanner.nextLine();

            System.out.println("Enter the birth date:");
            String birthDate = scanner.nextLine();
            if (birthDate.isEmpty()) {
                System.out.println("Bad birth date!");
            }

            System.out.println("Enter the gender (M, F):");
            String gender = scanner.nextLine();
            if (gender.isEmpty() || (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F"))) {
                System.out.println("Bad gender!");
            }

            System.out.println("Enter the number:");
            String phoneNumber = scanner.nextLine();

            Person person = new Person(name, surname, phoneNumber, birthDate, gender);
            if (person.getPhoneNumber().isEmpty()) {
                System.out.println("Wrong number format!");
            }
            phoneBook.add(person);
            saveContacts();
            System.out.println("The record added.");
        } else if (type.equals("organization")) {
            System.out.println("Enter the organization name:");
            String name = scanner.nextLine();

            System.out.println("Enter the address:");
            String address = scanner.nextLine();

            System.out.println("Enter the number:");
            String phoneNumber = scanner.nextLine();

            Organization organization = new Organization(name, address, phoneNumber);
            if (organization.getPhoneNumber().isEmpty()) {
                System.out.println("Wrong number format!");
            }
            phoneBook.add(organization);
            saveContacts();
            System.out.println("The record added.");
        } else {
            System.out.println("Unknown type. Please try again.");
        }
    }

    private static void removeContact(Scanner scanner) {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to remove!");
            return;
        }
        listContacts(scanner);
        System.out.println("Select a record:");
        int record = Integer.parseInt(scanner.nextLine());
        if (record > 0 && record <= phoneBook.size()) {
            phoneBook.remove(record - 1);
            saveContacts();
            System.out.println("The record removed!");
        } else {
            System.out.println("Invalid record number.");
        }
    }

    private static void editContact(Scanner scanner) {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to edit!");
            return;
        }
        listContacts(scanner);
        System.out.println("Select a record:");
        int record = Integer.parseInt(scanner.nextLine());
        if (record > 0 && record <= phoneBook.size()) {
            Contact contact = phoneBook.get(record - 1);
            System.out.println("Select a field (" + String.join(", ", contact.getEditableFields()) + "):");
            String field = scanner.nextLine().toLowerCase();
            System.out.println("Enter " + field + ":");
            String value = scanner.nextLine();
            contact.setField(field, value);
            saveContacts();
            System.out.println("The record updated!");
        } else {
            System.out.println("Invalid record number.");
        }
    }

    private static void countContacts() {
        System.out.println("The Phone Book has " + phoneBook.size() + " records.");
    }

    private static void listContacts(Scanner scanner) {
        if (phoneBook.isEmpty()) {
            System.out.println("No records to display!");
            return;
        }
        for (int i = 0; i < phoneBook.size(); i++) {
            Contact contact = phoneBook.get(i);
            System.out.println((i + 1) + ". " + contact);
        }
        System.out.println("[list] Enter action ([number], back):");
        String action = scanner.nextLine();
        if (!action.equals("back")) {
            try {
                int index = Integer.parseInt(action);
                if (index > 0 && index <= phoneBook.size()) {
                    Contact contact = phoneBook.get(index - 1);
                    contact.displayInfo();
                    System.out.println("[record] Enter action (edit, delete, menu):");
                    String recordAction = scanner.nextLine();
                    switch (recordAction) {
                        case "edit":
                            editContactDetails(scanner, contact);
                            break;
                        case "delete":
                            removeContact(scanner);
                            break;
                        case "menu":
                            break;
                    }
                } else {
                    System.out.println("Invalid index.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static void editContactDetails(Scanner scanner, Contact contact) {
        System.out.println("Select a field (" + String.join(", ", contact.getEditableFields()) + "):");
        String field = scanner.nextLine().toLowerCase();
        System.out.println("Enter " + field + ":");
        String value = scanner.nextLine();
        contact.setField(field, value);
        saveContacts();
        System.out.println("The record updated!");
    }

    private static void searchContacts(Scanner scanner) {
        System.out.println("Enter search query:");
        String query = scanner.nextLine();
        Pattern pattern = Pattern.compile(".*" + query + ".*", Pattern.CASE_INSENSITIVE);
        List<Contact> results = phoneBook.stream()
                .filter(contact -> pattern.matcher(contact.toSearchableString()).matches())
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            System.out.println("Found " + results.size() + " results:");
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i));
            }

            System.out.println("[search] Enter action ([number], back, again):");
            String action = scanner.nextLine();
            switch (action) {
                case "back":
                    return;
                case "again":
                    searchContacts(scanner);
                    break;
                default:
                    try {
                        int index = Integer.parseInt(action);
                        if (index > 0 && index <= results.size()) {
                            Contact contact = results.get(index - 1);
                            contact.displayInfo();
                            System.out.println("[record] Enter action (edit, delete, menu):");
                            String recordAction = scanner.nextLine();
                            switch (recordAction) {
                                case "edit":
                                    editContactDetails(scanner, contact);
                                    break;
                                case "delete":
                                    removeContact(scanner);
                                    break;
                                case "menu":
                                    return;
                            }
                        } else {
                            System.out.println("Invalid index.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
            }
        }
    }

    private static void saveContacts() {
        if (file != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(phoneBook);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadContacts() {
        if (file != null && file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                phoneBook = (List<Contact>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}