/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramon Larivoir
 */
public class EventoNovoParticipanteCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher;
        Long idEvento = Long.parseLong(request.getParameter("idEvento"));
        Evento evento = EventoDAO.getInstance().getEvento(idEvento);
        Date hoje = new Date();
        if(evento.getData().after(hoje)) {
            dispacher = request.getRequestDispatcher("/WEB-INF/eventos/inscricao.jsp");
            request.setAttribute("idEvento", idEvento);
            request.setAttribute("titulo", "Novo Participante");
        } else {
            dispacher = request.getRequestDispatcher("/WEB-INF/erros/erro.jsp");
            request.setAttribute("titulo", "Inscrições encerradas!");
        }
        dispacher.forward(request, response);
    }

}
