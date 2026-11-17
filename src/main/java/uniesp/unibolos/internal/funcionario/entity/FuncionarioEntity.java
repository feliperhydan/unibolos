package uniesp.unibolos.internal.funcionario.entity;

import uniesp.unibolos.internal.encomenda.entity.EncomendaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "funcionarios")
public class FuncionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 30)
    private String cargo;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = false, length = 20, unique = true)
    private String telefone;

    @Column(nullable = false)
    private boolean ativo = true;

    @Column(nullable = false)
    private LocalDateTime admitidoEm;

    @OneToMany(mappedBy = "funcionario")
    private List<EncomendaEntity> encomendas;


    public FuncionarioEntity(String nome, String cargo, String email, String telefone) {
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.telefone = telefone;
        this.admitidoEm = LocalDateTime.now();
    }

    public void adicionarEncomenda(EncomendaEntity encomenda) {
        encomendas.add(encomenda);
        encomenda.associarFuncionario(this);
    }

    public void alterarNome(String nome) {
        this.nome = nome;
    }

    public void alterarCargo(String cargo) {
        this.cargo = cargo;
    }

    public void alterarEmail(String email) {
        this.email = email;
    }

    public void alterarTelefone(String telefone) {
        this.telefone = telefone;
    }


    public void ativar() {
        this.ativo = true;
    }
    public void desativar() {
        this.ativo = false;
    }


}
