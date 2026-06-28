package main.java.br.com.projeto.uber.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "motoristas")
public class Motorista extends Usuario{
    
    @Column(nullable = false, unique = true, length = 11)
    private String cnh;

    @Column(nullable = false)
    private Double avaliacao;

    @Column(nullable = false)
    private String statusAtual;

    @Column(nullable = true)
    private Double latitudeAtual;

    @Column(nullable = true)
    private Double longitudeAtual;

    @OneToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    public Motorista(){}

    public Motorista(String nome, String email, String senha, String telefone, String cnh){
        super(nome, email, senha, telefone);
        this.cnh = cnh;
        this.avaliacao = 5.0;
        this.statusAtual = "OFFLINE";
    }

    public String getCnh() {
        return cnh;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public String getStatusAtual() {
        return statusAtual;
    }

    public Double getLatitudeAtual() {
        return latitudeAtual;
    }

    public Double getLongitudeAtual() {
        return longitudeAtual;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setStatusAtual(String statusAtual) {
        this.statusAtual = statusAtual;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public void atualizarLocalizacao(Double latitude, Double longitude){
        this.latitudeAtual = latitude;
        this.longitudeAtual = longitude;
    }

    public void ficarDisponivel(){
        this.statusAtual = "ONLINE";
    }

    public void atenderCorrida(){
        this.statusAtual = "EM CORRIDA";
    }


}
