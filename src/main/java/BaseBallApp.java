import dao.OutPlayerDAO;
import dao.PlayerDAO;
import dao.StadiumDAO;
import dao.TeamDAO;
import db.DBconnection;

import java.sql.Connection;

public class BaseBallApp {
    public static void main(String[] args) {
        Connection connection = DBconnection.getInstance();

        // 퇴출선수
        OutPlayerDAO outPlayerDao = new OutPlayerDAO(connection);

        // 선수
        PlayerDAO playerDao = new PlayerDAO(connection);

        // 야구장
        StadiumDAO stadiumDao = new StadiumDAO(connection);

        // 팀
        TeamDAO teamDao = new TeamDAO(connection);


    }
}
