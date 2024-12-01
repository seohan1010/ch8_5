package com.example.ch8_5.service;

import com.example.ch8_5.mapper.BoardCommentMapper;
import com.example.ch8_5.mapper.BoardMapper;
import com.example.ch8_5.to.BoardCommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {

    BoardCommentMapper boardCommentMapper;

    @Autowired
    public BoardCommentServiceImpl(BoardCommentMapper boardCommentMapper) {
        this.boardCommentMapper = boardCommentMapper;
    }

    @Override
    public void registerBoardComment(BoardCommentDto boardCommentDto) throws Exception {
        boardCommentMapper.insertBoardComment(boardCommentDto);
    }

    ;

    @Override
    public List<BoardCommentDto> selectBoardCommentList(Long pbno) throws Exception {
        return boardCommentMapper.selectBoardCommentList(pbno);
    }

    ;

    @Override
    public BoardCommentDto selectBoardCommentDetail(Long cno) throws Exception {
        return boardCommentMapper.selectBoardCommentDetail(cno);
    }

    ;

    @Override
    public void modifyBoardCommentDetail(BoardCommentDto boardCommentDto) throws Exception {
        boardCommentMapper.updateBoardCommentDetail(boardCommentDto);
    }

    ;

    @Override
    public void removeBoardCommentDetail(Long cno) throws Exception {
        boardCommentMapper.deleteBoardCommentDetail(cno);
    }

    ;

}
