package service;

import dao.OutPlayerDAO;
import dao.PlayerDAO;
import model.Outplayer;
import model.Player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

//퇴출선수 비즈니스 로직
public class OutPlayerService {
    private OutPlayerDAO outPlayerDao;
    private PlayerDAO playerDao;

    public OutPlayerService(OutPlayerDAO outPlayerDao, PlayerDAO playerDao) {
        this.outPlayerDao = outPlayerDao;
        this.playerDao = playerDao;
    }

    public void outPlayerRegist(BufferedWriter writer, BufferedReader reader) {
        String input = null;

        try {
            input = reader.readLine();

            String[] values = input.split(" ");
            if(values.length != 2) {
                System.out.println("입력 형식이 잘못되었습니다");
                return;
            }

            int id = Integer.parseInt(values[0]);
            String reason = values[1];


            List<Outplayer> outPlayers = outPlayerDao.findAll();

            boolean fineOne = false;
            for (Outplayer outPlayer : outPlayers) {
                if (!outPlayer.getOutPlayerId().equals(id)) {
                    fineOne = true;
                    break;
                }
                if (fineOne) {
                    try{
                        outPlayerDao.insert(outPlayer);

                        System.out.println("퇴출 선수 아이디는 " + id + " 번이고 " + "퇴출 이유는 " + reason + "입니다");
                        System.out.println("선수 등록이 완료되었습니다.");

                    } catch(Exception e) {
                        System.out.println("퇴출 선수 아이디가 같습니다");
                    }
                } else {
                    Outplayer outPlayerValue = new Outplayer(null,id,reason,null);
                    outPlayerDao.insert(outPlayerValue);
                    playerDao.update(id);
                    System.out.println("이미 퇴출된 선수입니다");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
