package com.example.ch8_5.controller;


import com.example.ch8_5.mapper.BoardCommentMapper;
import com.example.ch8_5.service.BoardCommentService;
import com.example.ch8_5.to.BoardCommentDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/comment")
public class BoardCommentController {

    BoardCommentService boardCommentService;

    @Autowired
    public BoardCommentController(BoardCommentService boardCommentService) {
        this.boardCommentService = boardCommentService;
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> registerBoardComment(@RequestBody BoardCommentDto boardCommentDto) {


        try {
            boardCommentService.registerBoardComment(boardCommentDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public ResponseEntity<List<BoardCommentDto>> retrieveBoardCommentList(@RequestParam("pbno") Long pbno) {
        Map<String, Object> map = null;
        List<BoardCommentDto> list = null;

        try {
            list = boardCommentService.selectBoardCommentList(pbno);

            return new ResponseEntity<>(list, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value="/comment/detail",method=RequestMethod.GET)
    public ResponseEntity<BoardCommentDto> retrieveBoardCommentDetail(@RequestParam("cno") Long cno){
    BoardCommentDto boardCommentDto = null;


        try {
           boardCommentDto =  boardCommentService.selectBoardCommentDetail(cno);
            return new ResponseEntity<>(boardCommentDto,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(boardCommentDto,HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value="/comment",method=RequestMethod.PUT)
    public ResponseEntity<HttpStatus> modifyBoardCommentDetail(@RequestBody BoardCommentDto boardCommentDto){


        try {
            boardCommentService.modifyBoardCommentDetail(boardCommentDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }


    @RequestMapping(value="/comment",method=RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> removeBoardCommentDetail(@RequestParam("cno") Long cno){


        try {
            boardCommentService.removeBoardCommentDetail(cno);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
