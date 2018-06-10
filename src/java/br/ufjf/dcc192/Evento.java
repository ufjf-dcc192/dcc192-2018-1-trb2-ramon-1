package br.ufjf.dcc192;

import java.sql.Timestamp;
import java.util.Collections;
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
    Boolean sorteado;

    public Evento() {
        sorteado = false;
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

    public void sorteia() {

        if (this.sorteado == false) {
            
            List<Participante> participantes = EventoDAO.getInstance().listAllParticipantes(this.id); //guarda lista de participantes do evento id em participantes
            Collections.shuffle(participantes);  //embaralha a lista        

            int primeiroParticipante = 0;
            int ultimoParticipante = participantes.size() - 1;

            for (int i = 0; i < participantes.size(); i++) {
                Long idParticipante = participantes.get(i).id;
                Long idAmigoSorteado = participantes.get(i + 1).id;
                EventoDAO.getInstance().atualizaAmigo(idParticipante, idAmigoSorteado, this.id);
                i++;    // em conjunto com a iteração do for incrementa dois, pulando assim o amigo sorteado anteriormente                
                this.sorteado = true;
            }

            Long idParticipante = participantes.get(ultimoParticipante).id;
            Long idAmigoSorteado = participantes.get(primeiroParticipante).id;
            EventoDAO.getInstance().atualizaAmigo(idParticipante, idAmigoSorteado, this.id);

        }

    }
}
