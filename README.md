-- 데이터베이스 만들기
CREATE DATABASE project;
drop DATABASE project;

-- stadium 테이블 만들기
CREATE TABLE stadium (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255),
created_at TIMESTAMP
);
-- team 테이블 만들기
CREATE TABLE team (
id INT PRIMARY KEY AUTO_INCREMENT,
stadium_id INT,
name VARCHAR(255),
created_at TIMESTAMP,
FOREIGN KEY (stadium_id) REFERENCES stadium(id)
);

-- player 테이블 만들기
CREATE TABLE player (
id INT PRIMARY KEY AUTO_INCREMENT,
team_id INT,
name VARCHAR(255),
position VARCHAR(255),
created_at TIMESTAMP,
CONSTRAINT unique_team_position UNIQUE (team_id, position),
FOREIGN KEY (team_id) REFERENCES team(id)
);

-- out_player 테이블 만들기
CREATE TABLE out_player (
id INT PRIMARY KEY AUTO_INCREMENT,
player_id INT,
reason VARCHAR(255),
created_at TIMESTAMP,
FOREIGN KEY (player_id) REFERENCES player(id)
);
-- stadium 데이터더미 넣기
INSERT INTO stadium (name, created_at) VALUES ('부산', NOW());
INSERT INTO stadium (name, created_at) VALUES ('서울', NOW());
INSERT INTO stadium (name, created_at) VALUES ('대전', NOW());

-- team데이터더미넣기
INSERT INTO team (stadium_id, name, created_at) VALUES (1, '롯데', NOW());
INSERT INTO team (stadium_id, name, created_at) VALUES (2, '삼성', NOW());
INSERT INTO team (stadium_id, name, created_at) VALUES (3, '한화', NOW());


-- 팀목록 조인쿼리
SELECT t.id, t.name AS team_name, s.id AS stadium_id, s.name AS stadium_name
FROM team t
LEFT JOIN stadium s ON t.stadium_id = s.id;

select * from team;
-- player 데이터더미넣기
-- 롯데
INSERT INTO player (team_id, name, position, created_at)
VALUES (1, '최준용', '투수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (1, '윤동희', '외야수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (1, '한동희', '3루수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (1, '전준우', '좌익수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (1, '안권수', '우익수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (1, '손성빈', '포수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (1, '황성빈', '중견수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (1, '안치홍', '2루수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (1, '이학주', '유격수', NOW());

-- 삼성
INSERT INTO player (team_id, name, position, created_at)
VALUES (2, '이재현', '유격수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (2, '김현준', '중견수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (2, '류지혁', '3루수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (2, '구자욱', '좌익수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (2, '오승환', '투수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (2, '강민호', '포수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (2, '김지찬', '2루수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (2, '오재일', '1루수', NOW());
INSERT INTO player (team_id, name, position, created_at)
VALUES (2, '이해승', '내야수', NOW());


-- 한화
INSERT INTO player (team_id, name, position, created_at)
VALUES (3, '최재훈', '포수', CURRENT_TIMESTAMP);
INSERT INTO player (team_id, name, position, created_at)
VALUES (3, '문동주', '투수', CURRENT_TIMESTAMP);
INSERT INTO player (team_id, name, position, created_at)
VALUES (3, '김건', '내야수', CURRENT_TIMESTAMP);
INSERT INTO player (team_id, name, position, created_at)
VALUES (3, '원혁재', '외야수', CURRENT_TIMESTAMP);
INSERT INTO player (team_id, name, position, created_at)
VALUES (3, '노시환', '3루수', CURRENT_TIMESTAMP);
INSERT INTO player (team_id, name, position, created_at)
VALUES (3, '정은원', '2루수', CURRENT_TIMESTAMP);
INSERT INTO player (team_id, name, position, created_at)
VALUES (3, '이진영', '우익수', CURRENT_TIMESTAMP);
INSERT INTO player (team_id, name, position, created_at)
VALUES (3, '이원석', '좌익수', CURRENT_TIMESTAMP);
INSERT INTO player (team_id, name, position, created_at)
VALUES (3, '채은성', '1루수', CURRENT_TIMESTAMP);
