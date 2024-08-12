package com.example.Client.entity.User;

import com.example.Client.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User extends BaseEntity
         {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private Long userId;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Gender")
    private Boolean gender;

    @Column(name = "Phone_Number")
    private Long phoneNumber;

             @Column(name = "address")
             private String address;

    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonManagedReference
    private Set<Role> roles = new HashSet<>();

    public User() {
        this.uuid = UUID.randomUUID().toString();
    }

    public User (String email , String password , HashSet<Role> roles) {
        this.email = email ;
        this.password = password ;
        this.roles = roles ;
    }


}
