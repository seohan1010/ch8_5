package com.example.ch8_5.to;

import java.util.Objects;

public class BoardDto {

    private String bno;
    private String title;
    private String writer;
    private String content;
    private String writeDate;
    private String updateDate;
    private String boardLike;
    private String deletedYn;


    @Override
    public String toString() {
        return "BoardDto{" +
                "bno='" + bno + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", writeDate='" + writeDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", boardLike='" + boardLike + '\'' +
                ", deletedYn='" + deletedYn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDto boardDto = (BoardDto) o;
        return Objects.equals(bno, boardDto.bno) && Objects.equals(title, boardDto.title) && Objects.equals(writer, boardDto.writer) && Objects.equals(content, boardDto.content) && Objects.equals(writeDate, boardDto.writeDate) && Objects.equals(updateDate, boardDto.updateDate) && Objects.equals(boardLike, boardDto.boardLike) && Objects.equals(deletedYn, boardDto.deletedYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bno, title, writer, content, writeDate, updateDate, boardLike, deletedYn);
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getBoardLike() {
        return boardLike;
    }

    public void setBoardLike(String boardLike) {
        this.boardLike = boardLike;
    }

    public String getDeletedYn() {
        return deletedYn;
    }

    public void setDeletedYn(String deletedYn) {
        this.deletedYn = deletedYn;
    }
}
