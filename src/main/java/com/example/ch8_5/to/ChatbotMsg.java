package com.example.ch8_5.to;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ChatbotMsg {
    @Id
    private Long msgNum;
    private String user;
    private String message;
    private Long chatNum;


    @Override
    public String toString() {
        return "RequestMsg{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                ", chatNum=" + chatNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       ChatbotMsg that = (ChatbotMsg) o;
        return Objects.equals(user, that.user) && Objects.equals(message, that.message) && Objects.equals(chatNum, that.chatNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, message, chatNum);
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
