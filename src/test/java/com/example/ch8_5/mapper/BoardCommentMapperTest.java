package com.example.ch8_5.mapper;

import com.example.ch8_5.to.BoardCommentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardCommentMapperTest {

    @Autowired
    BoardCommentMapper boardCommentMapper;


    @Test
    public void test() throws Exception {

        Long bno = 5L;
        String commenter = "aaa@aaa.com";
        String comment = "test comment5";
        BoardCommentDto b = new BoardCommentDto();
        b.setPbno(bno);
        b.setCommenter(commenter);
        b.setComment(comment);
        boardCommentMapper.insertBoardComment(b);

    }

    @Test
    public void selecteBoardCommentListTest() throws Exception {

        Long pbno = 5L;
        List<BoardCommentDto> list = boardCommentMapper.selectBoardCommentList(pbno);
        list.forEach(System.out::println);
        assertNotNull(list);
    }

    @Test
    public void selectBoardCommentDetail() throws Exception {

        Long cno = 1L;
        BoardCommentDto data = boardCommentMapper.selectBoardCommentDetail(cno);
        System.out.println("<<<< data = " + data);
        assertNotNull(data);


    }


    @Test
    public void updateBoardCommentDetail() throws Exception {

        BoardCommentDto b = new BoardCommentDto();
        b.setCno(1L);
        b.setComment("modified comment2");

        boardCommentMapper.updateBoardCommentDetail(b);

        BoardCommentDto b2 = boardCommentMapper.selectBoardCommentDetail(b.getCno());
        System.out.println("b2 = " + b2);
        assertNotNull(b2);
    }


    @Test
    public void deleteTest() throws Exception {

        Long cno = 1L;
        boardCommentMapper.deleteBoardCommentDetail(cno);
        BoardCommentDto b = boardCommentMapper.selectBoardCommentDetail(cno);
        assertNull(b);
        System.out.println("<<<< b = " + b);

    }


}