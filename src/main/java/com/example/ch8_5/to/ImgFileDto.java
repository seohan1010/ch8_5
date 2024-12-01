package com.example.ch8_5.to;

import java.util.Objects;

public class ImgFileDto {

    private String fileNo;
    private Long bno;
    private String imgName;
    private String imgPath;
    private String deletedYn;

    public ImgFileDto() {
    }


    @Override
    public String toString() {
        return "ImgFileDto{" +
                "fileNo='" + fileNo + '\'' +
                ", bno='" + bno + '\'' +
                ", imgName='" + imgName + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", deletedYn='" + deletedYn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImgFileDto that = (ImgFileDto) o;
        return Objects.equals(fileNo, that.fileNo) && Objects.equals(bno, that.bno) && Objects.equals(imgName, that.imgName) && Objects.equals(imgPath, that.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileNo, bno, imgName, imgPath);
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public Long getBno() {
        return bno;
    }

    public void setBno(Long bno) {
        this.bno = bno;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDeletedYn() {
        return deletedYn;
    }

    public void setDeletedYn(String deletedYn) {
        this.deletedYn = deletedYn;
    }
}
