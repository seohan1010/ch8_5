package com.example.ch8_5.mapper;

import com.example.ch8_5.to.BoardCommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardCommentMapper {

public abstract void insertBoardComment(BoardCommentDto boardCommentDto)throws Exception;

public abstract List<BoardCommentDto> selectBoardCommentList(Long pbno)throws Exception;

public abstract BoardCommentDto selectBoardCommentDetail(Long cno)throws Exception;

public abstract void updateBoardCommentDetail(BoardCommentDto boardCommentDto)throws Exception;

public abstract void deleteBoardCommentDetail(Long cno)throws Exception;

}
