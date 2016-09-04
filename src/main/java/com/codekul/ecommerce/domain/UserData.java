package com.codekul.ecommerce.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aniruddha on 3/9/16.
 */
@Entity
@Table(name = "user_data_table")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    private String userName;

    private String password;

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
