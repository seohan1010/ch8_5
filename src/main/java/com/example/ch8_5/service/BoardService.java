package com.example.ch8_5.service;

import com.example.ch8_5.to.BoardDto;
import com.example.ch8_5.to.SearchCondition;

import java.util.List;

public interface BoardService {
    public abstract void registerBoard(BoardDto boardDto) throws Exception;

    public abstract Long selectBoardCnt() throws Exception;

    public abstract Long selectBoardCntBySearchCondition(SearchCondition searchCondition)throws Exception;

    public abstract BoardDto selectBoardDetail(Long bno) throws Exception;

   public abstract List<BoardDto> selectBoardList(SearchCondition sc) throws Exception;

    public abstract List<BoardDto> selectBoardListBySearchCondition(SearchCondition sc) throws Exception;

    public abstract void modifyBoardDetail(BoardDto boardDto) throws Exception;

    public abstract void removeBoardDetail(Long bno) throws Exception;

    public abstract void deleteBoard() throws Exception;
}
