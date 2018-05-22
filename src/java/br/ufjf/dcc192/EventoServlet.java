/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramon Larivoir
 */
@WebServlet(name = "EventoServlet", urlPatterns = {"/index.html", "/eventos.html", "/novoevento.html", "/inscricao.html", "/amigo.html", "/inscritos.html"})
public class EventoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/index.html", "br.ufjf.dcc192.IndexCommand");
        rotas.put("/eventos.html", "br.ufjf.dcc192.EventosListCommand");
        rotas.put("/novoevento.html", "br.ufjf.dcc192.EventoNovoCommand");
        
        String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException|IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: " + ex);
            Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/novoevento.html", "br.ufjf.dcc192.EventoNovoPostCommand");
        
        String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException|IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: " + ex);
            Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
