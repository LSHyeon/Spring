package com.spring.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		//1. 스프링 컨테이너 구동
		GenericXmlApplicationContext container 
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. 스프링 컨테이너 사용
		System.out.println("----- 컨테이너 구동 후 -----");
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		//데이터 입력
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("tx테스트");
		vo.setWriter("테스터");
		vo.setContent("tx테스트중");
		boardService.insertBoard(vo);
		
		
		//전체 데이터 조회
		List<BoardVO> list = boardService.getBoardList();
		for (BoardVO board : list) {
			System.out.println("board : " + board);
		}
		
		//3. 스프링 컨테이너 종료
		container.close();
		
	}

}
