package com.blohny.article.controller;

import com.blohny.article.domain.Board;
import com.blohny.article.repository.BoardRepository;
import com.blohny.article.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/board/write")
    public String BoardWriteForm() {

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) {

        boardService.write(board);
        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String boardlist(Model model) {

        model.addAttribute("list", boardService.boardList());

        return "boardlist";
    }

    @GetMapping("/board/view") //파라미터 ? id = 1
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardview";
    }

    @DeleteMapping("/board/delete")
    public String delete(Integer id) {
        boardService.deleteBoard(id);

        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}") //@Integer 형태로 들어온다
    public String boardModify(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board) {
        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(boardTemp.getContent());

        boardService.write(boardTemp);

        return "redirect:/board/list";
    }

    @GetMapping("/error")
    @ResponseBody
    public String error() {
        return "에러다 에러 에러!!";
    }
}
