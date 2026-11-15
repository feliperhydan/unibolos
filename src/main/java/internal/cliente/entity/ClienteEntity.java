package internal.cliente.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false, length = 11, unique = true)
    private String telefone;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private Date criado_em;

    @Column(nullable = false)
    private Boolean ativo = true;


    // Contem somente coisas que precisam ser declaradas na criação da entidade
    // então, você não vai encontrar "Ativo" aqui, pq ele já começa ativo.
    public ClienteEntity(String nome, String cpf, String telefone, String email, String endereco, Date criado_em) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.criado_em = criado_em;
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
