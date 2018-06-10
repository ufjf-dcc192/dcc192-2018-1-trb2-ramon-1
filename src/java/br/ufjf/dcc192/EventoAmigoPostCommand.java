/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramon Larivoir
 */
public class EventoAmigoPostCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/participantes/amigo.jsp");
        Long idParticipante = Long.parseLong(request.getParameter("idParticipante"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Participante participante = EventoDAO.getInstance().login(idParticipante, email, senha);
        Participante amigo = EventoDAO.getInstance().getParticipante(participante.getIdAmigo());
        Evento evento = EventoDAO.getInstance().getEvento(participante.getIdEvento());
        if (participante.getNome() == null) {
            dispacher = request.getRequestDispatcher("/WEB-INF/erros/erro.jsp");
            request.setAttribute("titulo", "Login inválido!");
            String link = "eventos.html";
            request.setAttribute("link", link);
        } else {
            request.setAttribute("participante", participante);
            request.setAttribute("amigo", amigo);
            request.setAttribute("evento", evento);
            request.setAttribute("titulo", participante.getNome());

        }
        dispacher.forward(request, response);
    }

}
