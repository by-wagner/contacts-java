package contacts.model;

import java.util.Arrays;
import java.util.List;

public class Organization extends Contact {
    private String name;
    private String address;

    public Organization(String name, String address, String phoneNumber) {
        super(phoneNumber);
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateLastEdit();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        updateLastEdit();
    }

    @Override
    public List<String> getEditableFields() {
        return Arrays.asList("name", "address", "number");
    }

    @Override
    public void setField(String field, String value) {
        switch (field) {
            case "name":
                setName(value);
                break;
            case "address":
                setAddress(value);
                break;
            case "number":
                setPhoneNumber(value);
                break;
            default:
                System.out.println("Unknown field: " + field);
        }
    }

    @Override
    public String toSearchableString() {
        return name + " " + address + " " + getPhoneNumber();
    }

    @Override
    public void displayInfo() {
        System.out.println("Organization name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Number: " + (getPhoneNumber().isEmpty() ? "[no number]" : getPhoneNumber()));
        System.out.println("Time created: " + getCreated());
        System.out.println("Time last edit: " + getLastEdit());
    }

    @Override
    protected String getSummary() {
        return name;
    }
}