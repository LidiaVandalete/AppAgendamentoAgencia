package br.gama.projagenda.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.crypto.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn032_agendamento")
public class Agendamento {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_seq")
    private int num_seq;
    
    @Column(name="nome_cli", length=100)
    private String nome_cli;

    @Column(name="email_cli", length=100)
    private String email_cli;

    @Column(name="celular_cli", length=20)
    private String celular_cli;
    
    @Column(name="hora_agendamento")
    private LocalTime hora_agendamento;
    
    @Column(name="data_agendamento")
    private LocalDate data_agendamento;

    @Column(name="observacao", length=255)
    private String observacao;

    @JoinColumn(name="id_agencia")
    @ManyToOne
    @JsonIgnoreProperties("agendamentos")
    private Agencia agencia;

    public int getNum_seq() {
        return num_seq;
    }

    public void setNum_seq(int num_seq) {
        this.num_seq = num_seq;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public String getEmail_cli() {
        return email_cli;
    }

    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }

    public String getCelular_cli() {
        return celular_cli;
    }

    public void setCelular_cli(String celular_cli) {
        this.celular_cli = celular_cli;
    }

    public LocalTime getHora_agendamento() {
        return hora_agendamento;
    }

    public void setHora_agendamento(LocalTime hora_agendamento) {
        this.hora_agendamento = hora_agendamento;
    }

    public LocalDate getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(LocalDate data_agendamento) {
        this.data_agendamento = data_agendamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    
    }

