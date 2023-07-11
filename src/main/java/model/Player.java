package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private Integer playerId;
    private Integer teamId;
    private String playerName;
    private String position;
    private Timestamp playerCreatedAt;
}
