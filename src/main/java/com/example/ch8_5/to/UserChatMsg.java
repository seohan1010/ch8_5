package com.example.ch8_5.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class UserChatMsg {

    @Id
    private Long msgNum;

    private String user;

    private String message;

    private Long chatNum;



    @Override
    public String toString() {
        return "UserChatMsg{" +
                "msgNum=" + msgNum +
                ", user='" + user + '\'' +
                ", message='" + message + '\'' +
                ", chatNum=" + chatNum +
                '}';
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserChatMsg that = (UserChatMsg) o;
        return Objects.equals(msgNum, that.msgNum) && Objects.equals(user, that.user) && Objects.equals(message, that.message) && Objects.equals(chatNum, that.chatNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgNum, user, message, chatNum);
    }


    public Long getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(Long msgNum) {
        this.msgNum = msgNum;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getChatNum() {
        return chatNum;
    }

    public void setChatNum(Long chatNum) {
        this.chatNum = chatNum;
    }






}
