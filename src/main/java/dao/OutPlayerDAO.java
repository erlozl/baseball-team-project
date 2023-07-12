package dao;

import model.Outplayer;
import model.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//퇴출 선수 테이블
public class OutPlayerDAO {
    private Connection connection;
    public OutPlayerDAO(Connection connection) {
        this.connection = connection;
    }

    // 퇴출 선수 삽입
    public void insert(Outplayer outplayer) {
        // sql문 작성
        String sql = "INSERT INTO out_player (player_id, reason, created_at) VALUES (?, ?, NOW());";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, outplayer.getPlayerId());
            ps.setString(2, outplayer.getReason());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 퇴출 선수 수정
    public void update() {
        //      sql문 작성
        String sql = "";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 퇴출 선수 삭제
    public void delete (){
        //      sql문 작성
        String sql = "";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 퇴출 선수 하나 찾기
    public Outplayer fineOne(Integer playerId) {
        Outplayer outplayer = null;
        String sql = "SELECT * FROM out_player WHERE player_id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, playerId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                outplayer = new Outplayer(
                        rs.getInt("id"),
                        rs.getInt("player_id"),
                        rs.getString("reason"),
                        rs.getTimestamp("created_at")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return outplayer;
    }

    // 퇴출 선수 전체 찾기
    // (안에 안 적어놔서 오류납니다, 안에 작성할 때 주석 푸시면 됩니다)
    public List<Outplayer> findAll() {
        List<Outplayer> OutplayerDaoAll = new ArrayList<>();

        String sql = "select * from out_player";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Outplayer outplayer = new Outplayer(
                        rs.getInt("id"),
                        rs.getInt("player_id"),
                        rs.getString("reason"),
                        rs.getTimestamp("created_at")
                );
                OutplayerDaoAll.add(outplayer);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return OutplayerDaoAll;
    }

}
