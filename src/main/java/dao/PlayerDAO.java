package dao;

import model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//선수 테이블
public class PlayerDAO {
    private Connection connection;

    public PlayerDAO(Connection connection) {
        this.connection = connection;
    }

    // 선수 삽입
    public PlayerDAO insert(Player player) {
        // sql문 작성
        String sql = "INSERT INTO player (team_id, name, position, created_at)\n" +
                "VALUES (?, ? , ?, NOW());";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,player.getTeamId());
            ps.setString(2, player.getPlayerName());
            ps.setString(3,player.getPosition());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }
    // 선수 수정
    public void update(Integer id) {
        //      sql문 작성
        String sql = "UPDATE player SET position = NULL WHERE id = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // 선수 삭제
    public void delete (){
        //  sql문 작성
        String sql = "";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 선수 하나 찾기
    public Player fineOne(Integer teamId, Integer playerId) {
        Player player = null;
        String sql = "select *from player where ? order by ? asc;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,teamId);
            ps.setInt(2,playerId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                player = new Player(
                        rs.getInt("id"),
                        rs.getInt("team_id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getTimestamp("created_at")
                );

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return player;

    }

      // 선수 전체 찾기
      // (안에 안 적어놔서 오류납니다, 안에 작성할 때 주석 푸시면 됩니다)
    public List<Player> findAll(Integer teamId) {
        List<Player> playerDaoAll = new ArrayList<>();

        String sql = "select * from player where team_id = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, teamId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Player player = new Player(
                        rs.getInt("id"),
                        rs.getInt("team_id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getTimestamp("created_at")
                );
                playerDaoAll.add(player);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return playerDaoAll;
    }

}
