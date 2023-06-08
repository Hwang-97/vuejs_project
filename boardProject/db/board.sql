DROP TABLE board_detail;
DROP TABLE board;

-- board 테이블 생성
CREATE TABLE board (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  created_at DATETIME NOT NULL,
  is_deletable BOOLEAN NOT NULL DEFAULT true
);

-- boardDetail 테이블 생성
CREATE TABLE board_detail (
  id INT AUTO_INCREMENT PRIMARY KEY,
  detail_text TEXT NOT NULL,
  FOREIGN KEY (id)
	REFERENCES board(id) ON UPDATE CASCADE
);

-- board 테이블에 더미 데이터 삽입
INSERT INTO board (title, author, content, created_at, is_deletable)
SELECT 
  CONCAT('Title', id) AS title,
  CONCAT('Author', id) AS author,
  CONCAT('Content', id) AS content,
  ( TIMESTAMPADD(
    SECOND,
    FLOOR(RAND() * TIMESTAMPDIFF(SECOND, '2022-01-01', DATE_FORMAT(now(), '%Y%m%d%H%i%s'))),
    '2022-01-01'
  )) AS created_at,
  CASE WHEN RAND() < 0.5 THEN true ELSE false END AS is_deletable
FROM
  (SELECT (a.n + (b.n * 10) + (c.n * 100) + 1) AS id
  FROM 
    (SELECT 0 AS n UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS a,
    (SELECT 0 AS n UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS b,
    (SELECT 0 AS n UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) AS c
  ) AS numbers
LIMIT 100;

-- board_detail 테이블에 더미 데이터 삽입
INSERT INTO board_detail (id, detail_text)
SELECT 
  board.id AS id,
  CONCAT('Detail text for board id ', board.id) AS detail_text
FROM
  board;

  
-- 조회
select * from board;
select * from board_detail;

-- tranjection 처리
commit;
rollback;