package xd.marcin.hotel.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.key.ZonedDateTimeKeyDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

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

//    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="room_ID", referencedColumnName = "id")
    Room room;

    @Column
//    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
//    @JsonDeserialize(using = ZonedDateTimeKeyDeserializer.class)
    private ZonedDateTime fromDate;

    @Column
    private ZonedDateTime toDate;
}
