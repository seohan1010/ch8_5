package com.example.ch8_5.to;

import java.util.Objects;

public class BoardFileDto {

    private String fileNo;
    private String bno;
    private String fileName;
    private String filePath;
    private String deletedYn;


    public BoardFileDto() {
    }

    @Override
    public String toString() {
        return "BoardFileDto{" +
                "fileNo='" + fileNo + '\'' +
                ", bno='" + bno + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", deletedYn='" + deletedYn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardFileDto that = (BoardFileDto) o;
        return Objects.equals(fileNo, that.fileNo) && Objects.equals(bno, that.bno) && Objects.equals(fileName, that.fileName) && Objects.equals(filePath, that.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileNo, bno, fileName, filePath);
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDeletedYn() {
        return deletedYn;
    }

    public void setDeletedYn(String deletedYn) {
        this.deletedYn = deletedYn;
    }
}
