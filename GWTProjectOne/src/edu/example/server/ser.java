package edu.example.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ser extends HttpServlet {
	
	  public void doGet(HttpServletRequest req,
	                    HttpServletResponse res)
	            throws ServletException, IOException
	  {
		  res.setContentType("text/html");//setting the content type  
		  PrintWriter out=res.getWriter();//get the stream to write the data  
		    
		  //writing html in the stream  
		  out.println("<html><body>");  
		  out.println("Welcome to servlet");  
		  out.println("</body></html>");  
		    
		  out.close();//closing the stream  
		
	  }
	 
        public void doPost(HttpServletRequest req,
	                     HttpServletResponse res)
	      throws ServletException, IOException {
	     doGet(req, res);
	     
	     
	  }
	}

