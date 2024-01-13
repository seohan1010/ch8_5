package com.example.ch8_5.service;

import com.example.ch8_5.mapper.BoardMapper;
import com.example.ch8_5.to.BoardDto;
import com.example.ch8_5.to.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }


    @Override
    public void insertBoard(BoardDto boardDto) throws Exception {
        boardMapper.insertBoard(boardDto);
    }

    @Override
    public Long selectBoardCnt() throws Exception {
        return boardMapper.selectBoardCnt();
    }

    @Override
    public BoardDto selectBoardDetail(Long bno) throws Exception {
        return boardMapper.selectBoardDetail(bno);
    }

    @Override
    public List<BoardDto> selectBoardList(SearchCondition sc) throws Exception {
        return boardMapper.selectBoardList(sc);
    }

    @Override
    public List<BoardDto> selectBoardListBySearchCondition(SearchCondition sc) throws Exception {
        return boardMapper.selectBoardListBySearchCondition(sc);
    }

    @Override
    public void updateBoardDetail(BoardDto boardDto) throws Exception {
        boardMapper.updateBoardDetail(boardDto);
    }

    @Override
    public void deleteBoardDetail(Long bno) throws Exception {
        boardMapper.deleteBoardDetail(bno);
    }

    @Override
    public void deleteBoard() throws Exception {
        boardMapper.deleteBoard();
    }


}
