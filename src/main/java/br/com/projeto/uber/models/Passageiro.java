package main.java.br.com.projeto.uber.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "passageiros")
public class Passageiro extends Usuario{
    
    @Column(nullable = false, length = 20)
    private String metodoPagamentoPadrao;

    @Column(nullable = false)
    private Double avaliacao;

    public Passageiro(){}

    public Passageiro(String nome, String email, String senha, String telefone, String metodoPagamentoPadrao){
        super(nome,email,senha,telefone);
        this.metodoPagamentoPadrao = metodoPagamentoPadrao;
        this.avaliacao = 5.0;
    }

    public String getMetodoPagamentoPadrao() {
        return metodoPagamentoPadrao;
    }

    public void setMetodoPagamentoPadrao(String metodoPagamentoPadrao) {
        this.metodoPagamentoPadrao = metodoPagamentoPadrao;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    
}
