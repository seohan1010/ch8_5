package com.example.ch8_5.mapper;

import com.example.ch8_5.to.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardFileMapper {


    public abstract void insetBoardFile(BoardFileDto boardFileDto) throws Exception;

    public abstract void deleteBoardFile(Long fileNo) throws Exception;

    public abstract List<BoardFileDto> selectBoardFileNameList(Long bno) throws Exception;


}
