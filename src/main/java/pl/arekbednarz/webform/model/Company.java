package pl.arekbednarz.webform.model;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name="company", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public @Data class Company implements Serializable {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "street")
    private String street;

    @Column(name = "house_no")
    private String houseNo;

    @Column(name = "appart_no")
    private String apprtNo;

    @Column(name = "city")
    private String city;

    @Column(name= "zip")
    private String zip;

    @Column(name= "status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    private Owner companyOwners;
}
