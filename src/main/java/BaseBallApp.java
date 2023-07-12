import dao.OutPlayerDAO;
import dao.PlayerDAO;
import db.DBconnection;
import model.Player;
import service.OutPlayerService;
import service.PlayerService;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {

        try {



            // DB
            Connection connection = DBconnection.getInstance();

            // 필요한 객체 만들기
            PlayerDAO playerDao = new PlayerDAO(connection);
            OutPlayerDAO outPlayerDao = new OutPlayerDAO(connection);

            OutPlayerService outPlayerService = new OutPlayerService(outPlayerDao, playerDao);
            PlayerService playerService = new PlayerService(playerDao);

            // 입력 받기
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            // 파싱
            System.out.println(input);

            // 라우팅
            String method = input.split("\\?")[0];
            String body = input.split("\\?")[1];


            if(method.equals("퇴출등록")){ // 퇴출등록?playerId=4&reason=도박

                String[] params = body.split("&");
                int playerId = Integer.parseInt(params[0].split("=")[1]);
                String reason = params[1].split("=")[1];
                System.out.println(playerId);
                System.out.println(reason);

                outPlayerService.outPlayerRegist(playerId, reason);

            } else if(method.equals("퇴출목록")){

            } else if(method.equals("선수목록")){ // 선수목록?teamId=1
                String[] params = body.split("&");
                int teamId = Integer.parseInt(params[0].split("=")[1]);
                System.out.println(teamId);

                List<Player> playerList = playerService.선수목록(teamId);
                System.out.println(playerList);
            }

        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
