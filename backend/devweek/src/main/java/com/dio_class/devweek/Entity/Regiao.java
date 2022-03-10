package com.dio_class.devweek.Entity;

import javax.persistence.*;

@Entity //coluna no banco de dados
public class Regiao {
//    (1) Attributes

    // Id is auto generated, auto increment and cannot be null (JPA is doing it)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private Long qtd_exames;
    private String regiao;

//    (2) Constructor
    public Regiao(Long qtd_exames, String regiao) {
        this.qtd_exames = qtd_exames;
        this.regiao = regiao;
    }

    public Regiao() {}

//    (3) Getters/Setters
    public Long getId() {
        return id;
    }

    public Long getQtd_exames() {
        return qtd_exames;
    }

    public void setQtd_exames(Long qtd_exames) {
        this.qtd_exames = qtd_exames;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
}
