Projeto HomeBank ADS
====================================================================================================
Projeto já usado em aulas passadas com registro de dados em arquivos. Agora está usando SQLite local
na disciplina de programação para dispositivos móveis turma ADS 19.


TRIGGER ADICIONADA JUNTO COM A TABELA MOVIMENTO deposito e saque

 String cria_t_deposito ="CREATE TRIGGER IF NOT EXISTS deposito \n" +
            "AFTER INSERT ON movimento \n" +
            "FOR EACH ROW WHEN New.tipo_opera=\"deposito\"  \n" +
            "BEGIN \n" +
            "\n" +
            "UPDATE usuario\n" +
            "       SET saldo = saldo + NEW.valor\n" +
            "     WHERE id = new.idusr;\n" +
            "\n" +
            "END;";

    String cria_t_saque ="CREATE TRIGGER IF NOT EXISTS saque \n" +
            "AFTER INSERT ON movimento \n" +
            "FOR EACH ROW WHEN New.tipo_opera=\"saque\"  \n" +
            "BEGIN \n" +
            "\n" +
            "UPDATE usuario\n" +
            "       SET saldo = saldo - NEW.valor\n" +
            "     WHERE id = new.idusr;\n" +
            "\n" +
            "END;";
