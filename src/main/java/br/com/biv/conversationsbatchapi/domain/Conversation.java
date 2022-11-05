package br.com.biv.conversationsbatchapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conversation {

    private String date;
    private String status;
    private String message;

    @Override
    public String toString() {
        return "Conversation{" +
                "date='" + date + "'" +
                ", status ='" + status + "'" +
                ", message='" + message + "'" + "'" +
                '}';
    }
}
