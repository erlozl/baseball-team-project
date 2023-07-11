import dao.OutPlayerDAO;
import dao.PlayerDAO;
import dao.StadiumDAO;
import dao.TeamDAO;
import db.DBconnection;
import model.Player;
import service.OutPlayerService;
import service.PlayerService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {

        try {
            // DB
            Connection connection = DBconnection.getInstance();

            // 입출력
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

//          ---------------------------------
            PlayerDAO playerDao = new PlayerDAO(connection);

            // 퇴출선수
            OutPlayerDAO outPlayerDao = new OutPlayerDAO(connection);
            OutPlayerService outPlyserService = new OutPlayerService(outPlayerDao, playerDao);
            System.out.println("선수 퇴출 등록을 해주세요");
            System.out.print("선수 번호와 퇴출 이유를 구분하여 입력하세요: ");
            outPlyserService.outPlayerRegist(writer,reader);

            // 선수 퇴출 등록
//            Outplayer outplayer = new Outplayer(null,12,"도박",null);
//            outPlayerDao.insert(outplayer);

//          ---------------------------------

            // 선수

            PlayerService playerService = new PlayerService(playerDao);

            // 선수 등록 - 일단 완료
//
//            System.out.println("선수 등록을 해주세요");
//            System.out.print("선수 팀 번호, 이름, 포지션을 &으로 구분하여 입력하세요: ");
//            playerService.PlayerRegist(reader, playerService);
//
//
//            // 팀별 선수 목록 - 일단 완료
//
//            System.out.println("선수 목록을 보여주세요");
//            playerService.build(reader, playerDao);

//          ---------------------------------

            // 야구장
            StadiumDAO stadiumDao = new StadiumDAO(connection);

//          ---------------------------------

            // 팀
            TeamDAO teamDao = new TeamDAO(connection);

//            Team team = new Team(4,3,null,null);
//            teamDao.update(team);

        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
