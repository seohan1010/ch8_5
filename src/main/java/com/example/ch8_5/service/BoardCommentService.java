package com.example.ch8_5.service;

import com.example.ch8_5.to.BoardCommentDto;

import java.util.List;

public interface BoardCommentService {
    public abstract void registerBoardComment(BoardCommentDto boardCommentDto) throws Exception;

    public abstract List<BoardCommentDto> selectBoardCommentList(Long pbno) throws Exception;

    public abstract BoardCommentDto selectBoardCommentDetail(Long cno) throws Exception;

    public abstract void modifyBoardCommentDetail(BoardCommentDto boardCommentDto) throws Exception;

    public abstract void removeBoardCommentDetail(Long cno) throws Exception;
}
