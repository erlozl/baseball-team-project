package service;

import dao.TeamDAO;

import java.sql.Connection;

//팀 비즈니스 로직
public class TeamService {
    private TeamDAO teamDAO;


    //팀등록
    public TeamService(Connection connection) {
        this.teamDAO = new TeamDAO(connection);
    }
}