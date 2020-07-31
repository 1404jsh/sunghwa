package com.kh.portfolio.board.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Entity
@Data
public class BoardVO {
	
	private long bnum;												//	BNUM	NUMBER(10,0)	No		1	게시글번호
	@Valid // **계층형 유효성 검사시 반드시 추가해준다**
	private BoardCategoryVO boardCategoryVO;	//	BCATEGORY	NUMBER(4,0)	Yes		2	BCATEGORY.CID
	
	@NotNull
	@Size(min=2, max=50, message= "제목이 2~50자 까지 입력가능 합니다.")
	private String btitle;										//	BTITLE	VARCHAR2(150 BYTE)	Yes		3	제목
	@NotNull
	@Pattern(regexp = "\\w+@\\w.\\w+(\\.\\w+)?", message="이메일 형식으로 입력바랍니다. ex)admin@gmail.com")
	private String bid;												//	BID	VARCHAR2(40 BYTE)	Yes		4	MEMBER.ID
	private String bnickname;									//	BNICKNAME	VARCHAR2(30 BYTE)	Yes		5	"작성자이름"
	private Timestamp	bcdate;									//	BCDATE	TIMESTAMP(6)	Yes	systimestamp 	6	작성일
	private Timestamp	budate;									//	BUDATE	TIMESTAMP(6)	No	"systimestamp "	7	수정일
	private int hit;													//	BHIT	NUMBER(5,0)	Yes	0 	8	조회수
	@NotNull(message = "내용을 입력바랍니다.")
	@Size(min=4, message = "내용은 최소 4자 이상 입력바랍니다.")
	private String bcontent;									//	BCONTENT	CLOB	Yes		9	본문내용
	private int bgroup;												//	BGROUP	NUMBER(5,0)	Yes		10	답글그륩
	private int bstep;												//	BSTEP	NUMBER(5,0)	Yes		11	답변글의 단계
	private int bindent;											//	BINDENT	NUMBER(5,0)	Yes		12	답변글의 들여쓰기
	
	//첨부파일
	private List<MultipartFile> files;
}
