package com.example.ch8_5.to;

import java.util.Objects;

public class BoardCommentDto {

    private Long cno;
    private Long pbno;
    private String commenter;
    private String comment;
    private String registerDate;
    private String updateDate;
    private String deletedYn;



    public BoardCommentDto() {
    }


    @Override
    public String toString() {
        return "BoardCommentDto{" +
                "cno='" + cno + '\'' +
                ", pbno='" + pbno + '\'' +
                ", commenter='" + commenter + '\'' +
                ", comment='" + comment + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", deletedYn='" + deletedYn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardCommentDto that = (BoardCommentDto) o;
        return Objects.equals(cno, that.cno) && Objects.equals(pbno, that.pbno) && Objects.equals(commenter, that.commenter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cno, pbno, commenter);
    }

    public Long getCno() {
        return cno;
    }

    public void setCno(Long cno) {
        this.cno = cno;
    }

    public Long getPbno() {
        return pbno;
    }

    public void setPbno(Long pbno) {
        this.pbno = pbno;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getDeletedYn() {
        return deletedYn;
    }

    public void setDeletedYn(String deletedYn) {
        this.deletedYn = deletedYn;
    }
}
