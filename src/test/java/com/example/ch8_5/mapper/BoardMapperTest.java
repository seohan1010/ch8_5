package com.example.ch8_5.mapper;

import com.example.ch8_5.to.BoardDto;
import com.example.ch8_5.to.SearchCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;


    @Test
    public void test() {
        System.out.println("<<<<<<<<<<< boardMapper = " + boardMapper);
        assertNotNull(boardMapper);
    }

    //테스트 성공

    @Test
    public void insertTest() {

        String title = "test title";
        String email = "aaa@aaa.com";
        String content = "test content";

        BoardDto boardDto = new BoardDto();
        boardDto.setTitle(title);
        boardDto.setWriter(email);
        boardDto.setContent(content);

        try {
            boardMapper.insertBoard(boardDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //테스트 성공
    @Test
    public void testData() throws Exception {

        deleteBoard();
        for (int i = 0; i < 256; i++) {
            BoardDto board = new BoardDto();
            board.setTitle("test title " + i);
            board.setWriter("aaa@aaa.com");
            board.setContent("test content " + i);
            boardMapper.insertBoard(board);
        }

    }


    public void deleteBoard() throws Exception {
        boardMapper.deleteBoard();

    }


    //테스트 성공
    @Test
    public void selectBoardDetailTest() throws Exception {

        BoardDto boardDto = boardMapper.selectBoardDetail(10l);
        assertNotNull(boardDto);
        System.out.println("<<<<<< boardDto = " + boardDto);

    }

    //테스트 성공
    @Test
    public void selectBoardCnt() throws  Exception{
        Long cnt = boardMapper.selectBoardCnt();
        System.out.println("<<<<<<<<<<<< cnt = " + cnt);


    }

    // 테스트 성공
    @Test
    public void selectBoardList()throws Exception{

        SearchCondition  sc = new SearchCondition(1,10,"1","");

        List<BoardDto> list = boardMapper.selectBoardList(sc);
        assertNotNull(list);
        list.forEach(System.out::println);


    }


    @Test
    public void selectBoardListBySearchCondition()throws Exception{

        SearchCondition sc = new SearchCondition(2,10,"1","T");
        List<BoardDto> list = boardMapper.selectBoardListBySearchCondition(sc);
        assertNotNull(list);
        list.forEach(System.out::println);

    }


    // 테스트 성공
    @Test
    public void updateBoardDetailTest() throws Exception {

        Long bno = 5L;
        String title = "modified title2";
        String content = "modified title2";


        BoardDto boardDto = new BoardDto();
        boardDto.setBno(bno);
        boardDto.setTitle(title);
        boardDto.setContent(content);
        boardMapper.updateBoardDetail(boardDto);
        BoardDto boardDto1 = boardMapper.selectBoardDetail(bno);
        assertNotNull(boardDto1);
        System.out.println("<<<<<<<<< boardDto1 = " + boardDto1);

    }

    //테스트 성공
    @Test
    public void deleteBoardDetailTest() throws Exception {

        Long bno = 5L;
        boardMapper.deleteBoardDetail(bno);
        BoardDto boardDto = boardMapper.selectBoardDetail(bno);
        System.out.println("<<<<<< boardDto = " + boardDto);
        assertEquals(boardDto.getDeletedYn(), "Y");

    }


}