package main.java.br.com.projeto.uber.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;


@Entity
@Table(name = "corridas")
public class Corrida {
    
    @ManyToOne
    @JoinColumn(name = "passageiro_id", nullable = false)
    private Passageiro passageiro;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double latitudeOrigem;

    @Column(nullable = false)
    private Double longitudeOrigem;


     @Column(nullable = false)
    private Double latitudeDestino;

    @Column(nullable = false)
    private Double longitudeDestino;


    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Double precoEstimado;

    @Column(nullable = true)
    private Double precoFinal;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataSolicitacao;

    @Column(nullable = true)
    private LocalDateTime dataFinalizacao;

    public Corrida(){}

    public Corrida(Passageiro passageiro, Double latitudeOrigem, Double longitudeOrigem, Double latitudeDestino, Double longitudeDestino, Double precoEstimado){
        this.passageiro = passageiro;
        this.longitudeOrigem = longitudeOrigem;
        this.latitudeOrigem = latitudeOrigem;
        this.longitudeDestino = longitudeDestino;
        this.latitudeDestino = latitudeDestino;
        this.precoEstimado = precoEstimado;
        this.status = "SOLICITADA";
    }

    @PrePersist
    void executarAntesDeSalvar(){
        this.dataSolicitacao = LocalDateTime.now();
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public Long getId() {
        return id;
    }

    public Double getLatitudeOrigem() {
        return latitudeOrigem;
    }

    public Double getLongitudeOrigem() {
        return longitudeOrigem;
    }

    public Double getLatitudeDestino() {
        return latitudeDestino;
    }

    public Double getLongitudeDestino() {
        return longitudeDestino;
    }

    public String getStatus() {
        return status;
    }

    public Double getPrecoEstimado() {
        return precoEstimado;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void aceitarCorrida(Motorista motorista){
        this.status = "ACEITA";
        this.motorista = motorista;
    }

    public void iniciarTrajeto(){
        this.status = "EM_ANDAMENTO";
    }

    public void finalizarCorrida(Double valorCobrado){
        this.status = "FINALIZADA";
        this.precoFinal = valorCobrado;
        this.dataFinalizacao = LocalDateTime.now();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Corrida other = (Corrida) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    

}
