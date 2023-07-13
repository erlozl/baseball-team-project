package service;

import dao.TeamDAO;
import dto.TeamRespDTO;

import java.sql.Connection;
import java.util.List;

//팀 비즈니스 로직
public class TeamService {
    private TeamDAO teamDAO;


    //팀등록
    public TeamService(Connection connection) {
        this.teamDAO = new TeamDAO(connection);
    }


}