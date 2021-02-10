# cs-center
2021-02-09 

## 바뀐 DB
```
drop table board CASCADE CONSTRAINTS;
create table board(
    num NUMBER PRIMARY KEY,
    type VARCHAR2(20) NOT NULL, 
    writer VARCHAR2(20) NOT NULL REFERENCES admin(id) on delete CASCADE, 
    title VARCHAR2(50) NOT NULL,
    content VARCHAR2(1000), 
    regdate date default sysdate,
    updatedate date default sysdate
);

create SEQUENCE seq_qna;
CREATE TABLE qna(
	num NUMBER PRIMARY KEY,
	writer VARCHAR2(20) REFERENCES member(id) on delete CASCADE,
	o_history NUMBER REFERENCES order1(num) on delete CASCADE,
    q_cate VARCHAR2(50) NOT NULL,
    pwd VARCHAR2(50),
    title VARCHAR2(50) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    state VARCHAR2(50) NOT NULL,
    regdate date default sysdate,
    updatedate date default sysdate,
   path VARCHAR2(50) NOT NULL
    );

drop table reply CASCADE CONSTRAINTS;
CREATE TABLE reply(
    num NUMBER PRIMARY KEY NOT NULL,
    faq_num NUMBER NOT NULL REFERENCES faq(num) on delete CASCADE,
    writer VARCHAR2(20) NOT NULL,
    content VARCHAR2(1000), 
    r_date date,
    path varchar2(500)
);

INSERT INTO board VALUES(seq_board.nextval, 'faq', 'admin', '자주묻는 질문1', '자주묻는 내용1', sysdate, sysdate);
INSERT INTO board VALUES(seq_board.nextval, 'faq', 'admin', '자주묻는 질문2', '자주묻는 내용2', sysdate, sysdate);
INSERT INTO board VALUES(seq_board.nextval, 'faq', 'admin', '자주묻는 질문3', '자주묻는 내용3', sysdate, sysdate);
INSERT INTO board VALUES(seq_board.nextval, 'faq', 'admin', '자주묻는 질문4', '자주묻는 내용4', sysdate, sysdate);
INSERT INTO board VALUES(seq_board.nextval, 'faq', 'admin', '자주묻는 질문5', '자주묻는 내용5', sysdate, sysdate);
INSERT INTO board VALUES(seq_board.nextval, 'faq', 'admin', '자주묻는 질문6', '자주묻는 내용6', sysdate, sysdate);

INSERT INTO board VALUES(seq_board.nextval, 'notice', 'admin', '공지사항1', '공지사항내용입니다1', sysdate, sysdate);
INSERT INTO board VALUES(seq_board.nextval, 'notice', 'admin', '공지사항2', '공지사항내용입니다2', sysdate, sysdate);
INSERT INTO board VALUES(seq_board.nextval, 'notice', 'admin', '공지사항3', '공지사항내용입니다3', sysdate, sysdate);
INSERT INTO board VALUES(seq_board.nextval, 'notice', 'admin', '공지사항4', '공지사항내용입니다4', sysdate, sysdate);
INSERT INTO board VALUES(seq_board.nextval, 'notice', 'admin', '공지사항5', '공지사항내용입니다5', sysdate,sysdate);
commit; 
```

## 변경사항
1.구매자가 올리는 문의사항과 관리자가 올리는 자주묻는질문, 공지사항 분리
2.문의사항은 Qna 테이블로 나누었고 / 자주묻는질문과 공지사항은 Board테이블에 type을 추가해 구분
3. 자주묻는 질문과 공지사항은 댓글달기 기능, 이미지 넣기 기능 삭제
4. 문의사항에 댓글기능과 이미지 넣기 기능 추가
5. 자주묻는 질문과 공지사항(Board)의 아이디 참조를 admins(id)로 바꿔 관리자만 등록할 수 있도록 함

## 현재 완료된 구현기능
1. 공지사항 링크를 누르면 공지사항 리스트가 뜨고 문의사항누르면 문의사항이 뜬다.
2. 문의사항 작성폼 추가 (작성까지는 안됌 - 주문내역을 받아오는 방법에 고민을 하고 있습니다.)
3. 1:1문의작성이 성공적으로 이루어지면 나의 문의내역으로 이동(/mypage/myQuestion)

## 남은 것
1.admin 부분 수정
2.답변 상태 기능 구현
3.문의글 작성 기능 구현

## 고민사항
1.문의글 비밀번호를 회원아이디의 아이디로 자동세팅할것인지, 문의글의 비밀번호를 새로 받을것인지
2.문의글의 답변상태를 DB에 저장할 필요가 있는지
