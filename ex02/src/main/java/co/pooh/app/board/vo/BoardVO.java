package co.pooh.app.board.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private long bno;		 //게시글 번호
	private String title;    //제목
	private String content;  //내용
	private String writer;   //작성자
	private Date regdate;    //작성일자
	private Date updatedate; //수정일자
	
}
