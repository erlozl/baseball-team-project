package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Stadium {
    private Integer stadiumId;
    private String Name;
    private Timestamp stadiumCreated_at;

    @Override
    public String toString() {
        return "Stadium{" +
                "stadiumId=" + stadiumId +
                ", Name='" + Name + '\'' +
                ", stadiumCreated_at=" + stadiumCreated_at +
                '}';
    }

    public Stadium() {

    }

    public Stadium(Integer stadiumId, String name, Timestamp stadiumCreated_at) {
        this.stadiumId = stadiumId;
        Name = name;
        this.stadiumCreated_at = stadiumCreated_at;
    }
}
