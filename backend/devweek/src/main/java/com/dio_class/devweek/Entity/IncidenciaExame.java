package com.dio_class.devweek.Entity;

import javax.persistence.*;

@Entity //coluna no banco de dados
public class IncidenciaExame {
//    (1) Attributes

    // Id is auto generated, auto increment and cannot be null (JPA is doing it)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private Integer regiao_id;
    private Integer Mes;
    private Long faixa_id;
    private Integer qnt_exames;

//    (2) Constructor
    public IncidenciaExame(Integer regiao_id, Integer mes, Long faixa_id, Integer qnt_exames) {
        this.regiao_id = regiao_id;
        this.Mes = mes;
        this.faixa_id = faixa_id;
        this.qnt_exames = qnt_exames;
    }

    public IncidenciaExame() {}

//    (3) Getters/Setters
    public Long getId() {
        return id;
    }

    public Integer getRegiao_id() {
        return regiao_id;
    }

    public void setRegiao_id(Integer regiao_id) {
        this.regiao_id = regiao_id;
    }

    public Integer getMes() {
        return Mes;
    }

    public void setMes(Integer mes) {
        Mes = mes;
    }

    public Long getFaixa_id() {
        return faixa_id;
    }

    public void setFaixa_id(Long faixa_id) {
        this.faixa_id = faixa_id;
    }

    public Integer getQnt_exames() {
        return qnt_exames;
    }

    public void setQnt_exames(Integer qnt_exames) {
        this.qnt_exames = qnt_exames;
    }
}
