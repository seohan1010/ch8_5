package com.example.ch8_5.service;

import com.example.ch8_5.mapper.BoardFileMapper;
import com.example.ch8_5.to.BoardFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardFileServiceImpl implements BoardFileService {

    BoardFileMapper boardFileMapper;


    @Autowired
    public BoardFileServiceImpl(BoardFileMapper boardFileMapper) {
        this.boardFileMapper = boardFileMapper;
    }

    @Override
    public void insetBoardFile(BoardFileDto boardFileDto)throws Exception{
        boardFileMapper.insetBoardFile(boardFileDto);
    }


    @Override
    public void deleteBoardFile(Long fileNo)throws Exception{
        boardFileMapper.deleteBoardFile(fileNo);
    }

    @Override
    public List<BoardFileDto> selectBoardFileNameList(Long bno)throws Exception{
        return boardFileMapper.selectBoardFileNameList(bno);
    }


}
