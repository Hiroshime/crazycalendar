/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.control.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import crazycalendar.control.web.command.ICommand;
import crazycalendar.control.web.command.impl.ChangeCommand;
import crazycalendar.control.web.command.impl.ConsultCommand;
import crazycalendar.control.web.command.impl.DeleteCommand;
import crazycalendar.control.web.command.impl.SaveCommand;
import crazycalendar.control.web.command.impl.ViewCommand;
import crazycalendar.control.web.vh.IViewHelper;
import crazycalendar.control.web.vh.impl.LoginViewHelper;
import crazycalendar.control.web.vh.impl.CreateDeviceViewHelper;
import crazycalendar.control.web.vh.impl.ListDeviceViewHelper;
import crazycalendar.control.web.vh.impl.ViewDeviceViewHelper;
import crazycalendar.core.application.Result;
import crazycalendar.domain.DomainEntity;

/**
 *
 * @author Luiz
 */
public class Servlet extends HttpServlet {

    
    private static Map<String,ICommand> commands;
    private static Map<String,IViewHelper> views;
    
    
    /**
     * INICIO@@@@@
     * Form
     *     Servlet
     *          ViewHelper
     *                   Servlet
     *                       #Command
     *                             Facade
     *                                  DAO
     *                             Facade
     *                       #Command
     *                   Servlet
     *           ViewHelper
     *        Form
     * FIM@@@@@
     * 
     */
    
    
    
    public Servlet()
    {
        //Hash Map de commands
        commands = new HashMap<>();
        //Inserindo Instancias de Commands no map com indices de string
        commands.put("SALVAR", new SaveCommand());
        commands.put("CONSULTAR", new ConsultCommand());
        commands.put("VISUALIZAR", new ViewCommand());
        commands.put("EXCLUIR", new DeleteCommand());
        commands.put("ALTERAR", new ChangeCommand());
        //commands.put("ALTERAR", new ChangeCommand());  Ainda não vou terminar
        
        //Hash Map de ViewsHelpers
        views = new HashMap<>();
        
        //Inserindo instancias de viewhelpers no map com indices de string 
        //Apenas uma view helper de aluno
        views.put("/sup-web/userPage/Product", new CreateDeviceViewHelper());
        views.put("/altair_itsm/altair_page_bootstrap/pages/BaselineGeral", new ListDeviceViewHelper());
        views.put("/altair_itsm/altair_page_bootstrap/pages/VerDispositivo", new ViewDeviceViewHelper());
        views.put("/altair_itsm/altair_page_bootstrap/pages/Login", new LoginViewHelper());
    }

	
	
	protected void processRequest(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		//Obtem a uri do request http
		String uri = request.getRequestURI();
		
		//Obtêm um viewhelper indexado pela uri 
		IViewHelper view = views.get(uri);
		
		//Recebe uma entidade completa do viewhelper
		DomainEntity entity =  view.getEntity(request);
		
		//Obtêm a operação pegando parametro o botao pressionado
		String operation = request.getParameter("operacao");
		
		//Obtêm o command para executar a operação
		ICommand command = commands.get(operation);
		//Recebe resultado da execução do command passando por tudo
                //pode ser erro ou entidade
                
                Result result = command.execute(entity);
               
		//Executa o setView do viewhelper
                //para definir a saida na tela
		view.setView(result, request, response);
	
	}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
