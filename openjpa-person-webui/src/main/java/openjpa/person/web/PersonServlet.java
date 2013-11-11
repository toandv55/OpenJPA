package openjpa.person.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import openjpa.person.api.PersonService;
import openjpa.person.api.Person;

public class PersonServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) 
                         throws ServletException, IOException {
        
        PrintWriter html = response.getWriter();
        try {
            InitialContext ctx = new InitialContext();
			
			// JDNI name of the service registered through interface PersonService 
            String jndi = "osgi:service/" + PersonService.class.getName();
			
			// Looks for the service
			PersonService ps = (PersonService) ctx.lookup(jndi);
			String textId = request.getParameter("id");
			
			int id = 0;
			try {
				id = Integer.parseInt(textId);
			} catch(NumberFormatException e) {
				html.append("Id must be a number!");
			}
			String name = request.getParameter("name");
			ps.add(id, name);
			Person person = ps.find(id);
			//html.append(person.getId() + " : " + person.getName() + " added successfully!");
			request.setAttribute("person", person);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/person.jsp");
			dispatcher.forward(request, response);
		   
		 
		   
		   
			
        } catch (NamingException e)  {
            html.append("Cannot find the service!");
        } 
    }

}
