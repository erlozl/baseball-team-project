package dao;

import model.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//팀 테이블
public class TeamDAO {
    private Connection connection;

    public TeamDAO(Connection connection) {
        this.connection = connection;
    }

    // 팀 삽입
    public void insert(Team team) {
        // sql문 작성
        String sql = "INSERT INTO team (stadium_id, name, created_at) VALUES (?, ?, NOW());";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, team.getStadiumId());
            ps.setString(2, team.getTeamName());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 팀 수정
    public void update(Team team) {
        //      sql문 작성
        String sql = "UPDATE team SET stadium_id = ? WHERE id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,team.getStadiumId());
            ps.setInt(2,team.getTeamId());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 팀 삭제
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

    // 팀 하나 찾기
    public void fineOne() {
        String sql = " ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){


            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

      // 팀 전체 찾기
      // (안에 안 적어놔서 오류납니다, 안에 작성할 때 주석 푸시면 됩니다)
//    public List<OutPlayer> findAll() {
//        list<OutPlayer> OutplayerDaoAll = new ArrayList<>();
//
//        String sql = "";
//
//        try {
//            PreparedStatement pstmt = connection.prepareStatement(sql);
//            ResultSet rs = pstmt.executeQuery();
//            while(rs.next()){
//
//                );
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return OutplayerDaoAll;
//    }



}
