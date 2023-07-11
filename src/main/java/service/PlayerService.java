package service;

import dao.PlayerDAO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import model.Player;
import model.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
//선수 비즈니스 로직
public class PlayerService {
    private PlayerDAO playerDAO;

    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

//    선수 등록 받기
    public static void PlayerRegist(BufferedReader reader, PlayerService playerService)
            throws IOException {

        String input = reader.readLine();
        String[] values = input.split("&");

        if(values.length != 3) {
            System.out.println("입력 형식이 잘못되었습니다");
            return;
        }

        int id = Integer.parseInt(values[0]);
        String name = values[1];
        String code = values[2];

        Player player = new Player(null, id, name, code, null);
        playerService.getPlayerDAO().insert(player);
        System.out.println("선수 등록이 완료되었습니다.");
    }

    public static PlayerService build(BufferedReader reader, PlayerDAO playerDao) {
        try {

            System.out.println("팀 번호를 입력해주세요");
            Integer input = Integer.valueOf(reader.readLine());

            List<Player> players = playerDao.findAll(input);

            for (Player playerValue : players) {
                System.out.println(playerValue.toString());
            }

            if (players.isEmpty()) {
                System.out.println("입력한 값이 데이터에 없습니다");
                return null;
            }

            return new PlayerService.Builder()
                    .reader(reader)
                    .playerDao(playerDao)
                    .inputTeamNumber(input)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

//  빌더 패턴
    public static class Builder {
        private BufferedReader reader;
        private PlayerDAO playerDao;
        private Integer inputTeamNumber;

        public Builder() {
        }

        public Builder reader(BufferedReader reader) {
            this.reader = reader;
            return this;
        }

        public Builder playerDao(PlayerDAO playerDao) {
            this.playerDao = playerDao;
            return this;
        }

        public Builder inputTeamNumber(Integer inputTeamNumber) {
            this.inputTeamNumber = inputTeamNumber;
            return this;
        }

        public PlayerService build() {
            return new PlayerService(playerDao);
        }
    }
}
