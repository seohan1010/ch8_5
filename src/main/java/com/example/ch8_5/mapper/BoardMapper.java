package com.example.ch8_5.mapper;


import com.example.ch8_5.to.BoardDto;
import com.example.ch8_5.to.SearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

public abstract int selectBoardCnt()throws Exception;


}
