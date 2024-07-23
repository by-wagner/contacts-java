package contacts.model;

import java.util.Arrays;
import java.util.List;

public class Person extends Contact {
    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public Person(String name, String surname, String phoneNumber, String birthDate, String gender) {
        super(phoneNumber);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateLastEdit();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        updateLastEdit();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        updateLastEdit();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        updateLastEdit();
    }

    @Override
    public List<String> getEditableFields() {
        return Arrays.asList("name", "surname", "birth", "gender", "number");
    }

    @Override
    public void setField(String field, String value) {
        switch (field) {
            case "name":
                setName(value);
                break;
            case "surname":
                setSurname(value);
                break;
            case "birth":
                setBirthDate(value);
                break;
            case "gender":
                setGender(value);
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
        return name + " " + surname + " " + getPhoneNumber() + " " + birthDate + " " + gender;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Birth date: " + (birthDate.isEmpty() ? "[no data]" : birthDate));
        System.out.println("Gender: " + (gender.isEmpty() ? "[no data]" : gender));
        System.out.println("Number: " + (getPhoneNumber().isEmpty() ? "[no number]" : getPhoneNumber()));
        System.out.println("Time created: " + getCreated());
        System.out.println("Time last edit: " + getLastEdit());
    }

    @Override
    protected String getSummary() {
        return name + " " + surname;
    }
}