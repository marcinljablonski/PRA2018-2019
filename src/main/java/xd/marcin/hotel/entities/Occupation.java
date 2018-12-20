package xd.marcin.hotel.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;
import java.time.ZonedDateTime;


@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Occupation {
    @Id @GeneratedValue
    @Column
    private int id;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="room_ID", referencedColumnName = "id")
    Room room;

    @Column
    private ZonedDateTime fromDate;

    @Column
    private ZonedDateTime toDate;
}
