package service;

import dao.StadiumDAO;
import model.Stadium;

import java.sql.Connection;
import java.util.List;

public class StadiumService {
    private StadiumDAO stadiumDAO;

    public StadiumService(StadiumDAO stadiumDAO) {
        this.stadiumDAO = stadiumDAO;
    }

    // 야구장 목록 조회
    public List<Stadium> findAllStadiums() {
        return stadiumDAO.findAll();
    }

    //야구장 등록
    public StadiumService(Connection connection) {
        this.stadiumDAO = new StadiumDAO(connection);

    }
}