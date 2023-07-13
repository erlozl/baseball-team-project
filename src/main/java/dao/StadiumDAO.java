package dao;

import model.Stadium;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//야구장 테이블
public class StadiumDAO {
    private Connection connection;

    public StadiumDAO(Connection connection) {
        this.connection = connection;
    }

    // 야구장 삽입
    public void insert(Stadium stadium) {
        // sql문 작성
        String sql = "INSERT INTO stadium (name, created_at) VALUES (?, NOW());";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, stadium.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 야구장 수정
    public void update() {
        //      sql문 작성
        String sql = "";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 야구장 삭제
    public void delete() {
        //      sql문 작성
        String sql = "";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 야구장 하나 찾기
    public void findOne() {
        String sql = " ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //야구장 전체 찾기
    //(안에 안 적어놔서 오류납니다, 안에 작성할 때 주석 푸시면 됩니다)
    public List<Stadium> findAll() {
        List<Stadium> stadiums = new ArrayList<>();

        String sql = "SELECT * FROM stadium";

        try {
            //Connection connection = DriverManager.getConnection("jdbc:your_database_connection_string");
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Stadium stadium = new Stadium();
                stadium.setStadiumId(rs.getInt("id"));
                stadium.setName(rs.getString("name"));
                stadium.setStadiumCreated_at(rs.getTimestamp("created_at"));

                stadiums.add(stadium);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return stadiums;
    }
}