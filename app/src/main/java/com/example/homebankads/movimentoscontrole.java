package com.example.homebankads;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class movimentoscontrole {

    private SQLiteDatabase db;
    private conectadb banco;

    public movimentoscontrole(Context contexto) {

        this.banco = new conectadb(contexto);
    }
    public void insere_movimento(movimentos movi){

        String INSERE_MOVIMENTO = "INSERT INTO movimento (idusr,tipo_opera,valor,destino,dataopera)" +
                " VALUES ("+
                "'"+movi.getIdusr()+"','"+movi.getTipo_opera()+"','"+
                movi.getValor()+"','"+movi.getDestino()+"','"+movi.getDataopera()+"')";
        try{
            SQLiteDatabase db=banco.getWritableDatabase();
            db.execSQL(INSERE_MOVIMENTO);
            db.close();
        }catch(Exception ex){
            //("Erro (criação tabela)",ex.getMessage());
        }


    }

    public void apaga_movimento(movimentos movi){
        String APAGA_MOVIMENTO = "DELETE FROM movimento WHERE idmov ="+movi.getIdmov();
        try{
            SQLiteDatabase db=banco.getWritableDatabase();
            db.execSQL(APAGA_MOVIMENTO);
            db.close();
        }catch(Exception ex){
            //("Erro (criação tabela)",ex.getMessage());
        }
    }
    public void atualiza_movimento(movimentos movi){
        String ATUALIZA_MOVIMENTO = "UPDATE TABLE usuario SET login = "+movi.getLogin()+", senha ="+movi.getSenha()+
                ",saldo="+movi.getSaldo()+" WHERE id = "+movi.getId();
        UPDATE movimento
        SET idmov = 'idmov',
                idusr = 'idusr',
                tipo_opera = 'tipo_opera',
                valor = 'valor',
                destino = 'destino',
                dataopera = 'dataopera'
        WHERE idmov = 'idmov'
        try{
            SQLiteDatabase db=banco.getWritableDatabase();
            db.execSQL(ATUALIZA_MOVIMENTO);
            db.close();
        }catch(Exception ex){
            //("Erro (criação tabela)",ex.getMessage());
        }
    }

}
