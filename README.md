Projeto HomeBank ADS 
Projeto já usado em aulas passadas com registro de dados em arquivos. Agora está usando SQLite local

TRIGGER ADICIONADA JUNTO COM A TABELA MOVIMENTO

/*
CREATE TRIGGER deposito
         AFTER INSERT
            ON movimento
      FOR EACH ROW
BEGIN
    UPDATE usuario
       SET saldo = saldo + NEW.valor
     WHERE id = new.idusr;
END;

 */
