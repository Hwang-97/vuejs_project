-- board 테이블 생성
CREATE TABLE board (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  created_at DATETIME NOT NULL,
  is_deletable BOOLEAN NOT NULL DEFAULT true
);

-- 더미 데이터 삽입
INSERT INTO board (title, author, content, created_at, is_deletable)
VALUES
  ('첫 번째 게시물', '작성자1', '첫 번째 게시물의 내용입니다.', '2023-05-01 10:00:00', true),
  ('두 번째 게시물', '작성자2', '두 번째 게시물의 내용입니다.', '2023-05-02 11:30:00', true),
  ('세 번째 게시물', '작성자3', '세 번째 게시물의 내용입니다.', '2023-05-03 14:15:00', true),
  ('네 번째 게시물', '작성자4', '네 번째 게시물의 내용입니다.', '2023-05-04 16:45:00', false),
  ('다섯 번째 게시물', '작성자5', '다섯 번째 게시물의 내용입니다.', '2023-05-05 09:20:00', true);

-- boardDetail 테이블 생성
CREATE TABLE boardDetail (
  id INT PRIMARY KEY,
  detail_text TEXT NOT NULL
);

-- 더미 데이터 삽입
INSERT INTO boardDetail (id, detail_text)
VALUES
  (1, '첫 번째 게시물의 상세 내용입니다.'),
  (2, '두 번째 게시물의 상세 내용입니다.'),
  (3, '세 번째 게시물의 상세 내용입니다.'),
  (4, '네 번째 게시물의 상세 내용입니다.'),
  (5, '다섯 번째 게시물의 상세 내용입니다.');