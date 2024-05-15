package pl.arekbednarz.webform.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="owners", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public @Data class Owner {

    @Id
    @Column(name = "ID", unique = true, nullable = false,insertable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private Boolean enable;

    private Boolean isAdminUser;

    @Transient
    private String passwordRepeat;
}
