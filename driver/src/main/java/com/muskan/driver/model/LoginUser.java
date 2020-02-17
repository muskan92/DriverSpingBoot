package com.muskan.driver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String  userName;
    private String mobile;
    @Email
    private String email;
    private boolean isActive;
    private String password;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created_at;
    @JsonIgnore
    private Date updated_at = new Date();



/*    private Location location;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Location{
        @Id
        @JsonIgnore
        @GeneratedValue()
        private Long id;
        private int x;
        private int y;

    }*/


}
