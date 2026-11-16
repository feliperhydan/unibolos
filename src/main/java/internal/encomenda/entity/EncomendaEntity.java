package internal.encomenda.entity;


import internal.cliente.entity.ClienteEntity;
import internal.funcionario.entity.FuncionarioEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "encomendas")
public class EncomendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_encomenda;

    // id_cliente do uml la
    // acho que nao precisa chamar a variavel de id_cliente
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteEntity cliente;

    // id_funcionario
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_funcionario", nullable = false)
    private FuncionarioEntity funcionario;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int quantidade;

    // precision fala q tem que ter ate 10 digitos
    // scale é a quant de casas decimais
    @Column(nullable = false, precision = 10, scale = 2)
    private Float valor_total;

    @Column(nullable = false)
    private LocalDateTime data_pedido;

    @Column(nullable = false)
    private LocalDateTime data_entrega;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(nullable = true)
    private String observacoes;



    public EncomendaEntity(String descricao, int quantidade, Float valor_total, String status, String observacoes) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor_total = valor_total;
        this.status = status;
        this.observacoes = observacoes;
    }

    public void associarCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public void associarFuncionario(FuncionarioEntity funcionario) {
        this.funcionario = funcionario;
    }

    public void alterarDados(String descricao, int quantidade, Float valor_total, String status, String observacoes) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor_total = valor_total;
        this.status = status;
        this.observacoes = observacoes;
    }

}
