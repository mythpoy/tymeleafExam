package com.example.mythymeleaf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db column에서 auto_increament를 사용하면 알아서 값이 알아서 증가
    private Long id;

    @NotNull
    @Size(min=2, max=30, message = "제목은 2글자이상 30자 이하입니다.")
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
}
