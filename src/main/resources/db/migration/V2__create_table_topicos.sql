CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data DATETIME NOT NULL,
    duvida_resolvida BOOLEAN DEFAULT FALSE,
    autor_id BIGINT NOT NULL,
    curso VARCHAR(25) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES autores(id)
);