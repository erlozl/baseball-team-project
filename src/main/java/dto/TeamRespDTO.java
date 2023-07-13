package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
@AllArgsConstructor
//전체 팀 목록
public class TeamRespDTO {
    private Integer teamId;
    private String teamName;
    private Integer stadiumId;
    private String StadiumName;

    @Override
    public String toString() {
        return "TeamRespDTO{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", stadiumId=" + stadiumId +
                ", StadiumName='" + StadiumName + '\'' +
                '}';
    }
}

