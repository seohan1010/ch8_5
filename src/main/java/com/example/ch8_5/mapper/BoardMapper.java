package com.example.ch8_5.mapper;


import com.example.ch8_5.to.BoardDto;
import com.example.ch8_5.to.SearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {


    public abstract void insertBoard(BoardDto boardDto) throws Exception;


    public abstract Long selectBoardCnt() throws Exception;
    public abstract Long selectBoardCntBySearchCondition(SearchCondition sc)throws Exception;

    public abstract BoardDto selectBoardDetail(Long bno) throws Exception;

    public abstract List<BoardDto> selectBoardList(SearchCondition sc) throws Exception;
    public abstract List<BoardDto> selectBoardListBySearchCondition(SearchCondition sc)throws Exception;

    public abstract void updateBoardDetail(BoardDto boardDto) throws Exception;

    public abstract void deleteBoardDetail(Long bno) throws Exception;

    public abstract void deleteBoard() throws Exception;


}
