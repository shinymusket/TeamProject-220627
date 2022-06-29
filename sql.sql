CREATE TABLE ex_memberinfo(
 id VARCHAR2(20) PRIMARY KEY,
 passwd VARCHAR2(20) NOT NULL,
 name VARCHAR2(20) NOT NULL,
 email VARCHAR2(50) NOT NULL,
 nickname VARCHAR2(30) NOT NULL,
 reg_date date DEFAULT sysdate
);

DROP TABLE ex_memberinfo;

SELECT * FROM ex_memberinfo;

UPDATE ex_memberinfo SET name=?, nickname=?, email=? WHERE id=?;

SELECT COUNT(*) FROM ex_memberinfo WHERE id=?;

INSERT INTO ex_memberinfo(id, passwd, name, email, nickname) VALUES(?, ?, ?, ?, ?);

SELECT passwd FROM ex_memberinfo WHERE id=?;

SELECT * FROM ex_memberinfo WHERE id=?;

CREATE TABLE member_tbl_02 (
    custno NUMBER(6) PRIMARY KEY,
    custname VARCHAR2(20),
    phone VARCHAR2(13),
    address VARCHAR2(60),
    joindate DATE,
    grade CHAR(1),
    city CHAR(2)
);

CREATE SEQUENCE member_seq
START WITH 100001
INCREMENT BY 1;

INSERT INTO member_tbl_02 VALUES(MEMBER_SEQ.nextval, '���ູ', '010-1111-2222', '���� ���빮�� �ְ�1��', '20151202', 'A', '01' );
INSERT INTO member_tbl_02 VALUES(MEMBER_SEQ.nextval, '���ູ', '010-1111-3333', '���� ���빮�� �ְ�2��', '20151206', 'B', '01' );
INSERT INTO member_tbl_02 VALUES(MEMBER_SEQ.nextval, '�����', '010-1111-4444', '�︪�� �︪�� ����1��', '20151001', 'B', '30' );
INSERT INTO member_tbl_02 VALUES(MEMBER_SEQ.nextval, '�ֻ��', '010-1111-5555', '�︪�� �︪�� ����2��', '20151113', 'A', '30' );
INSERT INTO member_tbl_02 VALUES(MEMBER_SEQ.nextval, '����ȭ', '010-1111-6666', '���ֵ� ���ֽ� �ܳ�����', '20151225', 'B', '60' );
INSERT INTO member_tbl_02 VALUES(MEMBER_SEQ.nextval, '������', '010-1111-7777', '���ֵ� ���ֽ� ��������', '20151211', 'C', '60' );

SELECT MAX(custno) FROM member_tbl_02;

SELECT * FROM member_tbl_02;

DROP TABLE member_tbl_02;
DROP SEQUENCE member_seq;


INSERT INTO member_tbl_02 VALUES(MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, ? );

CREATE TABLE money_tbl_02 (
    custno NUMBER(6),
    salenol NUMBER(8),
    pcost NUMBER(8),
    amount NUMBER(4),
    price NUMBER(8),
    pcode VARCHAR2(4),
    sdate DATE,
    CONSTRAINT money_tbl_02_PK PRIMARY KEY(custno, salenol)
);

CREATE SEQUENCE money_seq
START WITH 100001
INCREMENT BY 1;

DROP TABLE money_tbl_02;
DROP SEQUENCE money_seq;

SELECT * FROM member_tbl_02;
SELECT * FROM money_tbl_02;

SELECT * 
FROM member_tbl_02 m1 JOIN money_tbl_02 m2
USING(custno);

SELECT DISTINCT(custno), custname, grade, m2.price
FROM member_tbl_02 m1 JOIN money_tbl_02 m2
USING(custno);

SELECT m1.custno, custname, grade, SUM(m2.price)
FROM member_tbl_02 m1 INNER JOIN  money_tbl_02 m2
ON m1.custno = m2.custno 
GROUP BY m1.custno, custname, grade;

SELECT m1.custno, custname, grade, SUM(m2.price)
FROM member_tbl_02 m1 INNER JOIN  money_tbl_02 m2
ON m1.custno = m2.custno 
GROUP BY m1.custno, custname, grade
ORDER BY SUM(m2.price) DESC;

SELECT * FROM member_tbl_02 WHERE custno=?;

UPDATE member_tbl_02 SET custname=?, phone=?, address=?, joindate=?, grade=?, city=?  WHERE custno=?;





SELECT custno ,sum(price) FROM money_tbl_02 WHERE custno=100001 GROUP BY custno;



INSERT INTO money_tbl_02 VALUES(100001, 20160001, 500, 5, 2500, 'A001', '20160101');
INSERT INTO money_tbl_02 VALUES(100001, 20160002, 1000, 4, 4000, 'A002', '20160101');
INSERT INTO money_tbl_02 VALUES(100001, 20160003, 500, 3, 1500, 'A003', '20160101');
INSERT INTO money_tbl_02 VALUES(100002, 20160004, 2000, 1, 2000, 'A004', '20160102');
INSERT INTO money_tbl_02 VALUES(100002, 20160005, 500, 1, 500, 'A001', '20160103');
INSERT INTO money_tbl_02 VALUES(100003, 20160006, 1500, 2, 3000, 'A003', '20160103');
INSERT INTO money_tbl_02 VALUES(100004, 20160007, 500, 2, 1000, 'A001', '20160104');
INSERT INTO money_tbl_02 VALUES(100004, 20160008, 300, 1, 300, 'A005', '20160104');
INSERT INTO money_tbl_02 VALUES(100004, 20160009, 600, 1, 600, 'A006', '20160104');
INSERT INTO money_tbl_02 VALUES(100004, 20160010, 3000, 1, 3000, 'A007', '20160106');

COMMIT;

---------------------------------------------------------------------------------

-- ��ǥ �̷� ���̺�
CREATE TABLE TBL_VOTE_202005(
    v_jumin CHAR(13) PRIMARY KEY,
    v_name VARCHAR2(20),
    m_no CHAR(1),
    v_time CHAR(4),
    v_area CHAR(20),
    v_confirm CHAR(1),
    FOREIGN KEY(m_no) REFERENCES tbl_member_202005(m_no)
);

CREATE TABLE TBL_VOTE_202005(
    v_jumin CHAR(13),
    v_name VARCHAR2(20),
    m_no CHAR(1),
    v_time CHAR(4),
    v_area CHAR(20),
    v_confirm CHAR(1),
    CONSTRAINT TBL_VOTE_202005_v_jumin_pk PRIMARY KEY(v_jumin),
    CONSTRAINT TBL_VOTE_202005_m_no_fk FOREIGN KEY(m_no) REFERENCES tbl_member_202005(m_no)
);

INSERT INTO TBL_VOTE_202005 VALUES('99010110001', '������', '1', '0930', '��1��ǥ��', 'N');
INSERT INTO TBL_VOTE_202005 VALUES('89010120002', '������', '2', '0930', '��1��ǥ��', 'N');
INSERT INTO TBL_VOTE_202005 VALUES('69010110003', '������', '3', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('59010120004', 'ȫ����', '4', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('79010110005', '������', '5', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('89010120006', '������', '1', '0930', '��1��ǥ��', 'Y');

INSERT INTO TBL_VOTE_202005 VALUES('59010110007', '������', '1', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('49010120008', '������', '3', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('79010110009', '������', '3', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('89010120010', '������', '4', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('99010110011', '������', '5', '0930', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('79010120012', '������', '1', '1330', '��1��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('69010110013', '������', '4', '1330', '��2��ǥ��', 'Y');

INSERT INTO TBL_VOTE_202005 VALUES('89010110014', '������', '2', '1330', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('99010110015', '������', '3', '1330', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('79010110016', '������', '2', '1330', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('89010110017', '������', '4', '1330', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('99010110018', '������', '2', '1330', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('99010110019', '������', '4', '1330', '��2��ǥ��', 'Y');

INSERT INTO TBL_VOTE_202005 VALUES('79010110020', 'Ȳ����', '5', '1330', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('69010110021', '������', '3', '1330', '��2��ǥ��', 'Y');

INSERT INTO TBL_VOTE_202005 VALUES('79010110022', '������', '3', '1330', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('99010110023', '������', '1', '1330', '��2��ǥ��', 'Y');
INSERT INTO TBL_VOTE_202005 VALUES('59010110024', '������', '3', '1330', '��2��ǥ��', 'Y');

SELECT * FROM TBL_VOTE_202005;

COMMIT;

-- �ĺ��� ���̺�
CREATE TABLE tbl_member_202005 (
    m_no CHAR(1),
    m_name VARCHAR2(20),
    p_code CHAR(2),
    p_shool CHAR(1),
    m_jumin CHAR(13),
    m_city VARCHAR2(20),
    CONSTRAINT tbl_member_202005_m_no_pk PRIMARY KEY(m_no),
    CONSTRAINT tbl_member_202005_p_code_fk FOREIGN KEY(p_code) REFERENCES tbl_party_202005(p_code)
);

SELECT * FROM  tbl_member_202005;

INSERT INTO tbl_member_202005 VALUES ('1', '���ĺ�', 'P1', '1' , '6603011999991', '����ȭ��');
INSERT INTO tbl_member_202005 VALUES ('2', '���ĺ�', 'P2', '3' , '5503011999992', '�ε鷡��');
INSERT INTO tbl_member_202005 VALUES ('3', '���ĺ�', 'P3', '2' , '7703011999993', '���Ȳɵ�');
INSERT INTO tbl_member_202005 VALUES ('4', '���ĺ�', 'P4', '2' , '8803011999994', '���޷���');
INSERT INTO tbl_member_202005 VALUES ('5', '���ĺ�', 'P5', '3' , '9903011999995', '��������');

DROP TABLE tbl_member_202005;

DROP TABLE TBL_VOTE_202005;
DROP TABLE tbl_member_202005;

-- ���� ���̺�
CREATE TABLE tbl_party_202005 (
    p_code CHAR(2),
    p_name VARCHAR2(20),
    p_indate DATE,
    p_reader VARCHAR2(20),
    p_tel1 CHAR(3),
    p_tel2 CHAR(4),
    p_tel3 CHAR(4),
    CONSTRAINT tbl_party_202005_p_code_pk PRIMARY KEY(p_code)
);

INSERT INTO tbl_party_202005 VALUES ('P1', 'A����', '2010-01-01', '����ǥ', '02', '1111', '0001');
INSERT INTO tbl_party_202005 VALUES ('P2', 'B����', '2010-02-01', '���ǥ', '02', '1111', '0002');
INSERT INTO tbl_party_202005 VALUES ('P3', 'C����', '2010-03-01', '���ǥ', '02', '1111', '0003');
INSERT INTO tbl_party_202005 VALUES ('P4', 'D����', '2010-04-01', '����ǥ', '02', '1111', '0004');
INSERT INTO tbl_party_202005 VALUES ('P5', 'E����', '2010-05-01', '�Ӵ�ǥ', '02', '1111', '0005');

SELECT * FROM tbl_party_202005;

COMMIT;