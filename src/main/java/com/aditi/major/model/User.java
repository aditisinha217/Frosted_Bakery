package com.aditi.major.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(nullable=false)
    private String firstName;

    private String lastName;

    @Column(nullable=false)
    @NotEmpty
    @Email(message = "errors.invalid_email")
    private String email;


    private String password;
    
    // @ManyToMany(cascade= CascadeType.MERGE, fetch = FetchType.EAGER)
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(
        name="user_role",
        joinColumns={@JoinColumn(name="USER_ID" , referencedColumnName = "ID")}, 
        inverseJoinColumns=  {@JoinColumn(name="ROLE_ID", referencedColumnName = "ID")}
    )

    private List<Role> roles;

    public User(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getFirstName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles=user.getRole();
    }
    
    public User(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRole() {
        return roles;
    }

    public void setRole(List<Role> role) {
        this.roles = role;
    }
}
