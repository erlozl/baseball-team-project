package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Player {
    private Integer playerId;
    private Integer teamId;
    private String playerName;
    private String position;
    private Timestamp playerCreatedAt;
}
