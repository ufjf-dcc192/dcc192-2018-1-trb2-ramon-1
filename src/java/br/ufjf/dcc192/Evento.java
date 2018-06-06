package br.ufjf.dcc192;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ramon Larivoir
 */
public class Evento {

    long id;
    String titulo;
    double minimo;
    Date data;
    Date sorteio;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getSorteio() {
        return sorteio;
    }

    public void setSorteio(Date sorteio) {
        this.sorteio = sorteio;
    }

    
    /*
        Função sorteia retorna um sorteado por chamada de função, por isso contador foi 
        criado fora da função e incrementado a cada vez que for feito um sorteio;    
    */    
    int contadorSorteio = 0; // contador começa com 0

    public Participante sorteia(List<Participante> listaParticipantes, Participante participante) {
        int totalParticipantes = listaParticipantes.size(); //total de participantes      
        
        for (int i = 0; i < listaParticipantes.size(); i++) {
            if (contadorSorteio < totalParticipantes) {
                if (listaParticipantes.get(i) != participante && listaParticipantes.get(i) != null) {
                    Participante sorteado = listaParticipantes.get(i);  //guarda sorteado
                    listaParticipantes.remove(listaParticipantes.get(i)); //remove sorteado da lista
                    listaParticipantes.remove(participante);
                    contadorSorteio++;
                    return sorteado;
                }
            }
        }
        return null;
    }
}
