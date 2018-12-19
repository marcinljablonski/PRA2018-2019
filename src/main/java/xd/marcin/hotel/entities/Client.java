package xd.marcin.hotel.entities;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Client {

    public Client() {};

    @Id @GeneratedValue
    @Column
    private int cid;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phone;

    @Column
    private String email;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="Address_ID", referencedColumnName = "id")
    Address address;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Reservation> reservations = new HashSet<Reservation>();
//
//    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
//    private Set<Occupation> occupations = new HashSet<Occupation>();
}
