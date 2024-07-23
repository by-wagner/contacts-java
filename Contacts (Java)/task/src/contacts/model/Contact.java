package contacts.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public abstract class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private String phoneNumber;
    private final LocalDateTime created;
    private LocalDateTime lastEdit;

    public Contact(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.created = LocalDateTime.now();
        this.lastEdit = LocalDateTime.now();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            updateLastEdit();
        } else {
            this.phoneNumber = "";
        }
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    protected void updateLastEdit() {
        this.lastEdit = LocalDateTime.now();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*$";
        return phoneNumber.matches(regex);
    }

    public abstract List<String> getEditableFields();
    public abstract void setField(String field, String value);
    public abstract String toSearchableString();
    public abstract void displayInfo();

    @Override
    public String toString() {
        return getSummary();
    }

    protected abstract String getSummary();
}