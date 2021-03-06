	
drop table BBS;	
CREATE TABLE BBS(
		SEQ INT AUTO_INCREMENT PRIMARY KEY,
		ID VARCHAR(50) NOT NULL,
		REF DECIMAL(8) NOT NULL,
		STEP DECIMAL(8) NOT NULL,
		DEPTH DECIMAL(8) NOT NULL,
		
		TITLE VARCHAR(200) NOT NULL,
		CONTENT VARCHAR(4000) NOT NULL,
		WDATE TIMESTAMP NOT NULL,
		
		DEL DECIMAL(1) NOT NULL,
		READCOUNT DECIMAL(8) NOT NULL
	);
	
	ALTER TABLE BBS
	ADD
	FOREIGN KEY(ID) REFERENCES MEMBER(ID);
	
	INSERT INTO BBS (ID,REF,STEP,DEPTH,TITLE, CONTENT,WDATE,DEL,READCOUNT)
	VALUES('acogange2@naver.com',(SELECT IFNULL(MAX(REF),0)+1 FROM BBS a),0,0,
	'제목입니다','내용입니다',NOW(),0,0);
	
	SELECT * FROM BBS;