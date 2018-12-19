package xd.marcin.hotel.entities;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.Id;
import java.time.ZonedDateTime;


@Entity
@Data
public class Occupation {

    public Occupation() {};

    @Id @GeneratedValue
    @Column
    private int id;

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
