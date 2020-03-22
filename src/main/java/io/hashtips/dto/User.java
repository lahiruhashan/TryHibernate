package io.hashtips.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String username;
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "addresses",
            joinColumns = @JoinColumn(name = "user_id"))
    private Collection<Address> listOfAddresses = new ArrayList<Address>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", listOfAddresses=" + listOfAddresses +
                '}';
    }
}
