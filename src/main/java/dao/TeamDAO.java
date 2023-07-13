package dao;

import dto.TeamRespDTO;
import model.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//팀 테이블
public class TeamDAO {
    private static Connection connection;

    public TeamDAO(Connection connection) {
        this.connection = connection;
    }

    // 팀 삽입
    public static void insert(Team team) {
        // sql문 작성
        String sql;
        if (team.getStadiumId() != null) {
            sql = "INSERT INTO team (stadium_id, Name, created_at) VALUES (?, ?, NOW())";
        } else {
            sql = "INSERT INTO team (teamName, created_at) VALUES (?, NOW())";
        }

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            if (team.getStadiumId() != null) {
                ps.setInt(1, team.getStadiumId());
                ps.setString(2, team.getName());
            } else {
                ps.setString(1, team.getName());
            }

            ps.executeUpdate();
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 팀 삭제
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

    // 팀 하나 찾기
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

    //  팀 전체 찾기
    // (안에 안 적어놔서 오류납니다, 안에 작성할 때 주석 푸시면 됩니다)

    public List<TeamRespDTO> findAll() {
        List<TeamRespDTO> teamRespDTOAll = new ArrayList<>();

        String sql = "SELECT t.id, t.name AS team_name, s.id AS stadium_id, s.name AS stadium_name\n" +
                "FROM team t\n" +
                "LEFT JOIN stadium s ON t.stadium_id = s.id";

        try {
            //Connection connection = DriverManager.getConnection("jdbc:your_database_connection_string");
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                TeamRespDTO dto = TeamRespDTO.builder()
                        .teamId(rs.getInt(1))
                        .teamName(rs.getString(2))
                        .stadiumId(rs.getInt(3))
                        .StadiumName(rs.getString(4))
                        .build();
                teamRespDTOAll.add(dto);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return teamRespDTOAll;
    }
}



