package xd.marcin.hotel.entities;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;


@Entity
@Data
public class Reservation {

    public Reservation(){};

    @Id @GeneratedValue
    @Column
    private int id;

    @Column
    private int beds;

    @Column
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @Column
    private ZonedDateTime fromDate;

    @Column
    private ZonedDateTime toDate;
}
