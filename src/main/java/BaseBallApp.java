import dao.OutPlayerDAO;
import dao.PlayerDAO;
import dao.StadiumDAO;
import dao.TeamDAO;
import db.DBconnection;
import model.Stadium;
import model.Team;
import service.StadiumService;
import service.TeamService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {
        //DB
        Connection connection = DBconnection.getInstance();

       //필요한객체만들기
        OutPlayerDAO outPlayerDao = new OutPlayerDAO(connection);
        PlayerDAO playerDao = new PlayerDAO(connection);
        TeamDAO teamDao = new TeamDAO(connection);
        StadiumDAO stadiumDAO = new StadiumDAO(connection);
        StadiumService stadiumService = new StadiumService(stadiumDAO);


        // 입력 받기
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // 파싱

        String action = input.split("\\?")[0];

        // 야구장목록
        if(action.equals("야구장목록")){
            List<Stadium> stadiums = stadiumService.findAllStadiums();
            System.out.println(stadiums.toString());
        }

        // 야구장등록?name=사직야구장
        if(action.equals("야구장등록")){
            String body = input.split("\\?")[1]; // name=사직야구장
            String name = body.split("=")[1];
            Stadium stadium = new Stadium(null, name, null);
            try {
                stadiumDAO.insert(stadium);
                System.out.println("야구장 등록이 완료되었습니다.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("야구장 등록에 실패하였습니다.");
            }
        }

        // 팀등록?stadiumId=1&name=NC
        // if
        if(action.equals("팀등록")){
            String body = input.split("\\?")[1]; // stadiumId=1&name=NC
            String stadiumid = body.split("&")[0];//stadiumId=1
            String name = body.split("=")[1];//name=NC
            String[] body2 = body.split("&");
            int stadiumId = Integer.parseInt(body2[0].split("=")[1]);
            String name = body2[1].split("=")[1];
            Team team = new Team(null,stadiumid, name, null);
            try {
                TeamDAO.insert(team);
                System.out.println("팀 등록이 완료되었습니다.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("팀 등록에 실패하였습니다.");
            }
        }


        // if


        // if

    }
}