package xd.marcin.hotel.entities;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Address
{

    public Address(){};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    String street;

    @Column
    String city;

    @Column
    String nr;

    @Column
    String postcode;

}
