package br.ufjf.dcc192;

import java.sql.Timestamp;

/**
 *
 * @author Ramon Larivoir
 */
public class Evento {
    long id;
    String titulo;
    double minimo;
    Timestamp data;
    Timestamp sorteio;

    public Evento() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Timestamp getSorteio() {
        return sorteio;
    }

    public void setSorteio(Timestamp sorteio) {
        this.sorteio = sorteio;
    }
    
    public void sorteia() {
        
    }
}
