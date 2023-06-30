/*********************************************
         MYCGV_MEMBMER 테이블 
*********************************************/
-- 회원가입, 로그인, 관리자(회원관리등)
-- 컬럼리스트 : ID, PASS, NAME, GENDER, EMAIL, ADDR, TEL, PNUMBER, HOBBYLIST, INTRO,MDATE;
-- ****  UI폼 NAME = VO 필드명 = 테이블 컬럼명
CREATE TABLE MYCGV_MEMBER(
    ID            VARCHAR2(30)    CONSTRAINT  PK_MYCGV_MEMBER_ID  PRIMARY KEY,
    PASS        VARCHAR2(30)  NOT NULL,
    NAME      VARCHAR2(30) NOT NULL,
    GENDER    VARCHAR2(1) NOT NULL,
    EMAIL       VARCHAR2(50)  NOT NULL,
    ADDR        VARCHAR2(150)  NOT NULL,
    TEL             VARCHAR2(10)   NOT NULL,
    PNUMBER   VARCHAR2(30)  NOT NULL,
    HOBBYLIST  VARCHAR2(50)  NOT NULL,
    INTRO        VARCHAR2(200) ,
    MDATE      DATE    
);

/*********************************************
         MYCGV_BOARD 테이블 
*********************************************/
-- 게시판
-- 컬럼리스트 : BID(게시글아이디), BTITLE(제목), BCONTENT(내용), BHITS(조회수), ID(회원아이디), BDATE(등록일자)
-- ** BID는 SEQUENCE를 생성하여 정의
CREATE TABLE MYCGV_BOARD(
  BID       VARCHAR2(30)    CONSTRAINT PK_MYCGV_BOARD_BID   PRIMARY KEY,
  BTITLE  VARCHAR2(100)   NOT NULL,
  BCONTENT  VARCHAR2(200),
  BHITS   NUMBER(4),
  ID       VARCHAR2(30)   NOT NULL,
  BDATE  DATE
);

CREATE SEQUENCE SEQU_MYCGV_BOARD
  START WITH 1
  INCREMENT BY 1;

SELECT * FROM USER_SEQUENCES;
SELECT * FROM USER_TABLES WHERE TABLE_NAME='MYCGV_BOARD';


SELECT * FROM USER_TABLES WHERE TABLE_NAME='MYCGV_MEMBER';
DESC MYCGV_MEMBER;
SELECT * FROM MYCGV_MEMBER;
DELETE  FROM MYCGV_MEMBER WHERE ID LIKE 'tet%';
commit;

SELECT COUNT(*) FROM MYCGV_MEMBER WHERE ID='test';
select count(*) from mycgv_member where id='hong' and pass='123dfdf4';

-- 등록일자(내림차순) : ORDER BY BDATE DESC
-- 행번호(ROWNUM) : 컬럼리스트에 ROWNUM RNO
SELECT ROWNUM RNO, BID, BTITLE, BCONTENT, BHITS, ID, BDATE
FROM (SELECT BID, BTITLE,BCONTENT,BHITS, ID, BDATE FROM MYCGV_BOARD
          ORDER BY BDATE DESC);

-- MYCGV_MEMBER 테이블에 등급(GRADE) 컬럼 추가
-- VARCHAR2(10) 
-- NULL 허용 형태로 추가후 --> 데이터 수정 후 제약사항 수정하여  NOT NULL
SELECT * FROM MYCGV_MEMBER;
ALTER TABLE MYCGV_MEMBER
ADD GRADE VARCHAR2(10);

-- 기존 데이터 등급 : GOLD
UPDATE MYCGV_MEMBER SET GRADE='GOLD';
SELECT * FROM MYCGV_MEMBER;
COMMIT;

-- 최근가입한 회원 기준으로 출력하며, 행번호도 함께 출력
select rownum rno, id, name, to_char(mdate,'yyyy-mm-dd') mdate, grade
from (select id, name, mdate, grade from mycgv_member
        order by mdate desc);

update mycgv_member set grade='GOLD' where id='smith';        
commit;


/*********************************************
         MYCGV_NOTICE 테이블 
*********************************************/  
-- 공지사항 : 관리자(CURD), 사용자(R)
-- 컬럼리스트 : NID(공지사항아이디), NTITLE(제목), NCONTENT(내용), NHITS(조회수), NDATE(등록일자)
-- ** NID는 SEQUENCE를 생성하여 정의
CREATE TABLE MYCGV_NOTICE(
  NID       VARCHAR2(30)    CONSTRAINT PK_MYCGV_NOTICE_NID   PRIMARY KEY,
  NTITLE  VARCHAR2(100)   NOT NULL,
  NCONTENT  VARCHAR2(200),
  NHITS   NUMBER(4),
  NDATE  DATE
);
SELECT * FROM USER_TABLES WHERE TABLE_NAME='MYCGV_NOTICE';
DESC MYCGV_NOTICE;
SELECT * FROM MYCGV_NOTICE;

CREATE SEQUENCE SEQU_MYCGV_NOTICE
  START WITH 1
  INCREMENT BY 1;

SELECT * FROM USER_SEQUENCES;  













