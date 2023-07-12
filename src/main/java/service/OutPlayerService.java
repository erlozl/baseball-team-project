package service;

import dao.OutPlayerDAO;
import dao.PlayerDAO;
import model.Outplayer;
import model.Player;
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
    public void outPlayerRegist(int playerId, String reason) {
        
        // playerId 로 값있는지 체크
        Outplayer result = outPlayerDao.fineOne(playerId);

        if(result==null){
            Outplayer outplayer = new Outplayer(null, playerId, reason, null);
            outPlayerDao.insert(outplayer);
            playerDao.update(playerId);
            System.out.println("성공");
        } else {
            System.out.println("실패");
        }

    }
}
