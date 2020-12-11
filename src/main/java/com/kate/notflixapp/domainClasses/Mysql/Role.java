package com.kate.notflixapp.domainClasses.Mysql;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "permission")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<UserM> users;

    public void setUsers(Set<UserM> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}


