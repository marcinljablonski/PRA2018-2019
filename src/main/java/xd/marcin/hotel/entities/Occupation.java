package xd.marcin.hotel.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
public class Occupation {
    @Id @GeneratedValue
    @Column
    private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    private Client client;

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="room_ID", referencedColumnName = "id")
    Room room;

    @Column
    private Date fromDate;

    @Column
    private Date toDate;
}
