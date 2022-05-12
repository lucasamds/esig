package br.com.esig;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Tarefa {
    /*Escolhendo o indice como chave primária, o banco de dados gera os valores da
     chave primária com auto incremento*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long indice;

    /*Os atributos da classe serão colunas da tabela, onde não poderão receber valor nulo*/
    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String responsavel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridade prioridade;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date deadline;

    @Column(nullable = false)
    private String situacao;

    public Tarefa() {
        situacao = "Em andamento";
    }

    /*Objetos com o mesmo indice, serão considerados o mesmo objeto*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(indice, tarefa.indice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indice);
    }

    public long getIndice() {
        return indice;
    }

    public void setIndice(long indice) {
        this.indice = indice;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
