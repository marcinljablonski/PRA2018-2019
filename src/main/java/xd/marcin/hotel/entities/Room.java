package xd.marcin.hotel.entities;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Room
{
    public Room(){};

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    int beds;

    @Column
    String comment;
}
