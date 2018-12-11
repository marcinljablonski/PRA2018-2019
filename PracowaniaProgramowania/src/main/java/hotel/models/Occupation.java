package hotel.models;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.*;


@Entity
@Data
public class Occupation {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="room_ID", referencedColumnName = "id")
    Room room;

    @Column
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime fromDate;

    @Column
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime toDate;
}
