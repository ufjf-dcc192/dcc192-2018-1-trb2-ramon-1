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

    public Boolean getSorteado() {
        return sorteado;
    }

    public void setSorteado(Boolean sorteado) {
        this.sorteado = sorteado;
    }

    public void sorteia() {
        Date hoje = new Date();
        if (this.sorteado == false && this.data.before(hoje)) {
            List<Participante> participantes = EventoDAO.getInstance().listAllParticipantes(this.id); //guarda lista de participantes do evento id em participantes
            Collections.shuffle(participantes);  //embaralha a lista        

            int primeiroParticipante = 0;
            int ultimoParticipante = participantes.size() - 1;
            for (int i = 0; i < participantes.size(); i++) {
                if (i != participantes.size() - 1) {
                    Long idParticipante = participantes.get(i).getId();
                    Long idAmigoSorteado = participantes.get(i + 1).getId();
                    EventoDAO.getInstance().atualizaAmigo(idParticipante, idAmigoSorteado, this.id);
                }               
            }

            Long idParticipante = participantes.get(ultimoParticipante).getId();
            Long idAmigoSorteado = participantes.get(primeiroParticipante).getId();
            EventoDAO.getInstance().atualizaAmigo(idParticipante, idAmigoSorteado, this.id);

            this.sorteado = true;
            EventoDAO.getInstance().setSorteado(this.id, this.sorteado);
        }
    }
}
