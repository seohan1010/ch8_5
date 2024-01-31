package com.example.ch8_5.controller;

import com.example.ch8_5.mapper.BoardMapper;
import com.example.ch8_5.service.BoardService;
import com.example.ch8_5.to.BoardDto;
import com.example.ch8_5.to.PageHandler;
import com.example.ch8_5.to.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/board")
public class BoardController {

    BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 테스트 성공
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> retrieveBoardList(@RequestParam(required = false,defaultValue = "1") Integer page, @RequestParam(required = false,defaultValue = "10") Integer pageSize, SearchCondition sc) {
        Map<String, Object> map = null;
        List<BoardDto> list = null;
        PageHandler ph = null;

        // 페이지값과 페이지 사이즈 값이 null이면 아래의 로직을 실행 ---> 위처럼 설정을 해준다면 아래의 코드 2줄은 필요가 없을수도 있을거 같다.
        if (page == null) page = 1;
        if (pageSize == null) pageSize = 10;

        sc.setPage(page);
        sc.setPageSize(pageSize);
        try {
            // 전체 게시물의 개수를 가지고 오는 로직
            Long totalCnt = boardService.selectBoardCnt();
            // 페이징 결과를 가지고 오는 로직
            ph = new PageHandler(totalCnt, sc);
            // 해당하는 게시물을 가지고 오는 로직
            list = boardService.selectBoardList(sc);
            map = new HashMap<>();
            map.put("ph", ph);
            map.put("list", list);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }

    }

    //테스트 성공
    @RequestMapping(value = "/search_board", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> retrieveBoardListBySearchCondition(@RequestBody SearchCondition sc) {
        System.out.println("sc = " + sc);
        Map<String, Object> map = null;
        List<BoardDto> list = null;
        PageHandler ph = null;

        if (sc.getPage() == null) sc.setPage(1);
        if (sc.getPageSize() == null) sc.setPageSize(10);

        try {
            // 검색조건에 부합한 게시물의 갯수만 가지고 오는 로직
            Long totalCnt = boardService.selectBoardCntBySearchCondition(sc);
            list = boardService.selectBoardListBySearchCondition(sc);
            ph = new PageHandler(totalCnt, sc);
            map = new HashMap<>();
            map.put("ph", ph);
            map.put("list", list);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

    }

    // 테스트 성공
    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> registerBoard(@RequestBody BoardDto boardDto) {

        try {
            boardService.registerBoard(boardDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }


    @RequestMapping(value="/board/detail",method=RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> retrieveBoardDetail(@RequestParam Long bno){
            Map<String,Object> map  = null;

        try {
            map = new HashMap<>();
            BoardDto board=boardService.selectBoardDetail(bno);
            map.put("board",board);

            return new ResponseEntity<>(map,HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }


    }


    @RequestMapping(value="/board",method=RequestMethod.PUT)
    public ResponseEntity<HttpStatus> modifyBoardDetail(@RequestBody BoardDto boardDto){

        try {
            boardService.modifyBoardDetail(boardDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value="/board",method=RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> removeBoardDetail(@RequestParam Long bno){

        try {
            boardService.removeBoardDetail(bno);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
