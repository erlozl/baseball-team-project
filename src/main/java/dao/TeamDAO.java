package dao;

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
    public void insert() {
        // sql문 작성
        String sql = "";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    // 팀 수정
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
    public void selectOne() {
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
