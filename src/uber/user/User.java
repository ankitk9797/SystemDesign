package uber.user;

import java.util.UUID;

public abstract class User {
    private String id;
    private String name;
    private String contact;

    public User(String name, String contact) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
