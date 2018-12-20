package xd.marcin.hotel.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
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
