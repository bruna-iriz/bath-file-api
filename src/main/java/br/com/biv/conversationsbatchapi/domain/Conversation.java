package br.com.biv.conversationsbatchapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "conversation")
public class Conversation implements Serializable {

    private static final long serialVersionUID = 2l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String data;
    private String status;
    private String mensagem;

    @Override
    public String toString() {
        return "conversation{" +
                "id='" + id + "'" +
                "data='" + data + "'" +
                ", status ='" + status + "'" +
                ", mensagem='" + mensagem + "'" + "'" +
                '}';
    }
}
