package com.example.ch8_5.service;

import com.example.ch8_5.to.BoardFileDto;

import java.util.List;

public interface BoardFileService {
    void insetBoardFile(BoardFileDto boardFileDto) throws Exception;

    void deleteBoardFile(Long fileNo) throws Exception;

    List<BoardFileDto> selectBoardFileNameList(Long bno) throws Exception;
}
