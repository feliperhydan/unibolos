CREATE TABLE clientes (
    id_cliente BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    endereco VARCHAR(255) NOT NULL,
    criado_em TIMESTAMP NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE funcionarios (
    id_funcionario BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cargo VARCHAR(30) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL UNIQUE,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    admitido_em TIMESTAMP NOT NULL
);

CREATE TABLE encomendas (
    id_encomenda BIGSERIAL PRIMARY KEY,
    id_cliente BIGINT NOT NULL REFERENCES clientes(id_cliente),
    id_funcionario BIGINT NOT NULL REFERENCES funcionarios(id_funcionario),
    descricao TEXT NOT NULL,
    quantidade INTEGER NOT NULL CHECK (quantidade > 0),
    valor_total NUMERIC(10, 2) NOT NULL CHECK (valor_total >= 0),
    data_pedido TIMESTAMP NOT NULL,
    data_entrega TIMESTAMP NOT NULL,
    status VARCHAR(30) NOT NULL,
    observacoes VARCHAR(300)
);

CREATE TABLE pagamentos (
    id_pagamento BIGSERIAL PRIMARY KEY,
    id_encomenda BIGINT REFERENCES encomendas(id_encomenda),
    valor NUMERIC(10, 2) NOT NULL CHECK (valor >= 0),
    data_pagamento TIMESTAMP NOT NULL,
    forma_pagamento VARCHAR(30) NOT NULL
);

CREATE TABLE historicos (
    id_historico BIGSERIAL PRIMARY KEY,
    id_encomenda BIGINT NOT NULL REFERENCES encomendas(id_encomenda),
    id_funcionario BIGINT NOT NULL REFERENCES funcionarios(id_funcionario),
    status_anterior VARCHAR(255) NOT NULL,
    status_novo VARCHAR(255) NOT NULL,
    observacao VARCHAR(300),
    registrado_em TIMESTAMP NOT NULL
);

CREATE INDEX idx_encomendas_cliente ON encomendas(id_cliente);
CREATE INDEX idx_encomendas_funcionario ON encomendas(id_funcionario);
CREATE INDEX idx_pagamentos_encomenda ON pagamentos(id_encomenda);
CREATE INDEX idx_historicos_encomenda ON historicos(id_encomenda);

INSERT INTO clientes (nome, cpf, telefone, email, endereco, criado_em, ativo) VALUES
    ('Ana Beatriz Lima', '123.456.789-09', '(85) 99911-2233', 'ana.lima@example.com', 'Rua das Flores, 120, Aldeota, Fortaleza - CE', '2026-10-02 09:30:00', TRUE),
    ('Carlos Eduardo Souza', '987.654.321-00', '(85) 98822-3344', 'carlos.souza@example.com', 'Av. Beira Mar, 450, Meireles, Fortaleza - CE', '2026-10-08 14:15:00', TRUE),
    ('Mariana Alves Costa', '111.222.333-44', '(85) 99733-4455', 'mariana.costa@example.com', 'Rua dos Ipês, 75, Cocó, Fortaleza - CE', '2026-10-15 10:00:00', TRUE),
    ('Rafael Mendes Rocha', '555.666.777-88', '(85) 98644-5566', 'rafael.rocha@example.com', 'Rua do Sol, 220, Benfica, Fortaleza - CE', '2026-10-20 16:40:00', FALSE),
    ('Juliana Ferreira', '999.888.777-66', '(85) 99555-6677', 'juliana.ferreira@example.com', 'Av. Santos Dumont, 980, Papicu, Fortaleza - CE', '2026-11-01 11:20:00', TRUE);

INSERT INTO funcionarios (nome, cargo, email, telefone, ativo, admitido_em) VALUES
    ('Fernanda Oliveira', 'Confeiteira', 'fernanda.oliveira@unibolos.com', '(85) 99100-1100', TRUE, '2025-02-03 08:00:00'),
    ('Lucas Martins', 'Atendente', 'lucas.martins@unibolos.com', '(85) 99200-2200', TRUE, '2025-05-12 08:00:00');

INSERT INTO encomendas (id_cliente, id_funcionario, descricao, quantidade, valor_total, data_pedido, data_entrega, status, observacoes) VALUES
    (1, 1, 'Bolo de chocolate com morangos', 1, 180.00, '2026-11-05 09:00:00', '2026-11-22 15:00:00', 'EM_PRODUCAO', 'Escrever "Parabéns, Sofia".'),
    (2, 1, '50 cupcakes de baunilha decorados', 50, 225.00, '2026-11-10 13:30:00', '2026-11-25 10:00:00', 'CONFIRMADA', 'Decoração em tons de azul.'),
    (3, 2, 'Bolo red velvet para casamento', 1, 650.00, '2026-11-12 16:00:00', '2026-12-05 17:00:00', 'ORCAMENTO_ENVIADO', 'Três andares; aguarda confirmação.');

INSERT INTO pagamentos (id_encomenda, valor, data_pagamento, forma_pagamento) VALUES
    (1, 90.00, '2026-11-05 09:05:00', 'PIX'),
    (2, 225.00, '2026-11-10 13:35:00', 'CARTAO_CREDITO');

INSERT INTO historicos (id_encomenda, id_funcionario, status_anterior, status_novo, observacao, registrado_em) VALUES
    (1, 2, 'SOLICITADA', 'CONFIRMADA', 'Sinal recebido via PIX.', '2026-11-05 09:10:00'),
    (1, 1, 'CONFIRMADA', 'EM_PRODUCAO', 'Produção iniciada.', '2026-11-18 08:30:00'),
    (2, 2, 'SOLICITADA', 'CONFIRMADA', 'Pagamento integral confirmado.', '2026-11-10 13:40:00'),
    (3, 2, 'SOLICITADA', 'ORCAMENTO_ENVIADO', 'Orçamento enviado ao cliente.', '2026-11-12 16:20:00');
