package com.example.ch8_5.controller;

import com.example.ch8_5.to.BoardDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/board")
public class BoardController {

    @RequestMapping(value="/board",method= RequestMethod.GET)
    public List<BoardDto> retrieveBoardList(){
        List<BoardDto> list = new ArrayList<>();
        list.add(new BoardDto());
        list.add(new BoardDto());
        list.add(new BoardDto());

        return list;

    }


}
