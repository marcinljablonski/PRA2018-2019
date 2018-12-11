package hotel.models;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Room
{
    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "author_seq")
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    int beds;

    @Column(nullable = false)
    String comment;
}
