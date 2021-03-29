package hu.beke.smol.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Address")
@Table(name = "address")
@Data
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zip")
    private int zip;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;
}
