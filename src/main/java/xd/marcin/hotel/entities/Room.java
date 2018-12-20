package xd.marcin.hotel.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Room
{
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    int beds;

    @Column
    String comment;
}
