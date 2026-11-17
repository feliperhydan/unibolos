package internal.cliente.entity;

import internal.encomenda.entity.EncomendaEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(nullable = false, length = 150)
    private String nome;
    // Tem 14 de tamanho por causa de CNPJ.
    @Column(nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(nullable = false, length = 20, unique = true)
    private String telefone;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private LocalDateTime criado_em;

    @Column(nullable = false)
    private Boolean ativo = true;

    @OneToMany(mappedBy = "cliente")
    private List<EncomendaEntity> encomendas;


    // Contem somente coisas que precisam ser declaradas na criação da entidade
    // então, você não vai encontrar "Ativo" aqui, pq ele já começa ativo.
    // o date tambem nao esta aqui,
    // pq eu ACHO que ele ja preenche automaticamente
    public ClienteEntity(String nome, String cpf, String telefone, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public void adicionarEncomenda(EncomendaEntity encomenda) {
        encomendas.add(encomenda);
        encomenda.associarCliente(this);
    }

    public void alterarNome(String nome) {
        this.nome = nome;
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
