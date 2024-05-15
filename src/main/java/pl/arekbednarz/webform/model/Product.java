package pl.arekbednarz.webform.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name="products", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public @Data class Product {

    @Id
    @Column(name = "ID", unique = true, nullable = false,insertable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    @NotEmpty(message = "Field is mandatory")
    private String productName;

    @Column(name="product_type")
    @NotEmpty(message = "Field is mandatory")
    private String productType;

    @ManyToOne
    private Company company;
}
