package xd.marcin.hotel.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
    property="refId", scope=Client.class)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phone;

    @Column
    private String email;

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="Address_ID", referencedColumnName = "id")
    Address address;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Reservation> reservations = new HashSet<Reservation>();

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Occupation> occupations = new HashSet<Occupation>();
}
