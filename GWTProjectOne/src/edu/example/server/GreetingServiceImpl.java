package edu.example.server;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Document;
import com.fourspaces.couchdb.Session;
import com.fourspaces.couchdb.ViewResults;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.example.client.GreetingService;
import edu.example.shared.GetSet;

import java.util.*;
/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	Session dbSession=null;
	
	 


	@Override
	public GetSet check(GetSet g) throws IllegalArgumentException {
		
	
		
		// TODO Auto-generated method stub
		String user = null,pass=null;
		String cs=null;
		dbSession = new Session("127.0.0.1",5984);
		
		String dbname="user";
		
		
		
		Database db=dbSession.getDatabase(dbname);
	    ViewResults result = db.getAllDocuments();
		
int c=0,k=0;
		List<Document> sd=result.getResults();
		for (Document d: sd) {
		     
		
			String id=d.getJSONObject().getString("id");
		    
	
			Document row = db.getDocument(id);
			
	
           	   if( g.getEmail().equals(id) )
		    	{
           		   c++;
           		   if(row.containsKey("pwd"))
           		   { 
           			   k++;
           			   pass=row.get("pwd").toString();
           			
           			   if(g.getPwd().equals(pass))
           		       { 
           				  
           				   cs="Welcome	"+row.get("username").toString() ;
           				   break;
           				   }
           		   }
		    	  }
		    	else
		    	{
		    	cs="Please Register";
		    	}
		    
		        
		}
               g.setMsg(cs);
               
               return g;
				
	}

	@Override
	public GetSet register(GetSet g) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String s1=null,s2=null,s3=null;
		dbSession = new Session("127.0.0.1",5984);
		
		String dbname="user";
		
		Database db=dbSession.getDatabase(dbname);
		
		Document doc=new Document();
	    s1=g.getEmail();
	    s2=g.getUsername();
	    s3=g.getPwd();
	    
		doc.setId(s1);
		

		doc.put("username",s2);
		doc.put("pwd",s3);
		
		db.saveDocument(doc);
		
		g.setMsg("you are now registered");
		return g;
	}

	@Override
	public GetSet update(GetSet g) throws IllegalArgumentException {
		
		// TODO Auto-generated method stub
		
		String user = null,pass=null;
		String cs=null;
		dbSession = new Session("127.0.0.1",5984);
		
		String dbname="user";
		
		ArrayList<String> a= new ArrayList<String>();
		
		Database db=dbSession.getDatabase(dbname);
	    ViewResults result = db.getAllDocuments();
		
//Document doc =new Document();
		List<Document> sd=result.getResults();
		for (Document d: sd) {
		     
		
			String id=d.getJSONObject().getString("id");
		    
	
			Document row = db.getDocument(id);
			
	
           	   if( g.getEmail().equals(id) )
		    	{
           		
           		   if(row.containsKey("pwd"))
           		   { 
           			
           			   pass=row.get("pwd").toString();
           			
           			   if(g.getPwd().equals(pass))
           		       {  
           				   
           				  user =row.get("username").toString();
           				 a.add("xyz");
           				 a.add(g.getUpdate().toString());
           				  //System.out.println(g.getUpdate().toString());
           				  row.put("username",a);
           				 // row.replace("username", user,g.getUpdate().toString());
           				 
		           			db.saveDocument(row);
		           			
		           			
		          // String s []=	row.getRevisions();
		          /* for (int j=0;j<s.length;j++)
		        	   
		           {
		        	 System.out.println(s[j]);
		        		  
		        	  }*/
		           
           				  cs="Username updated to	"+row.get("username").toString() ;
           				   break;
           				   }
           		   }
		    	  }
		    	else
		    	{
		    	cs="not updated";
		    	}
		    
		        
		}
               g.setMsg(cs);
               
               return g;
		
		
	}


	public GetSet extract(GetSet g) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		String s=g.getQuestion();
		String q=null;
		ArrayList<String> query= new ArrayList<String>();
		ArrayList<String> stop= new ArrayList<String>();
		ArrayList<String> questions= new ArrayList<String>();
		stop.add("what");
		stop.add("What");
		stop.add("is");
		stop.add("Where");
		stop.add("where");
		
		StringTokenizer st = new StringTokenizer(s," ");  
	    while (st.hasMoreTokens()) {  
	             
	    	query.add(st.nextToken() );
	    } 
	    
		query.removeAll(stop);
		
	    Session dbSession=null;
		dbSession = new Session("127.0.0.1",5984);
		
		String dbname="questions";
		
		
		ArrayList<String> list=new ArrayList<String>();
		Database db=dbSession.getDatabase(dbname);
	    ViewResults result = db.getAllDocuments();
		

		List<Document> sd=result.getResults();
		for (Document d: sd) {
		     
		
			String id=d.getJSONObject().getString("id");
		    

			Document row = db.getDocument(id);
			

	       		   if(row.containsKey("ques"))
	       		   { 
	       			 System.out.println("sdavjhvdsa");
	       			q=row.get("ques").toString();
	       			questions.add(q);
	       			 
	       		   }
		    	  
		    	else
		    	{
		   System.out.println("error");
		    	}
		    
		        
		}
	        //String pattern=null;  
	      for(String o : questions)
	      {
	    	// String line=o;
	    	 
	    	 for(String a: query)
	    	 { 
	    		 System.out.println(a);
	    		/*//System.out.println(a);
	    	
	    		pattern ="\\"+a+"\\b";
	    	
	         Pattern r = Pattern.compile(pattern);

	    
	         Matcher m = r.matcher(line);*/
	         if (o.contains(a)) {
	           System.out.println(o);
	        	 
	        	 list.add(o);
	        	 g.setAl(list);
	         }
	      }
	      }
	     return g;
		}
		
		
		
	}
	
	/*@Override
	public String check(String s1, String s2) throws IllegalArgumentException 
	
	{
		// TODO Auto-generated method stub
		
		String user = null,pass=null;
		String cs=null;
		dbSession = new Session("127.0.0.1",5984);
		
		String dbname="user";
		
		
		
		Database db=dbSession.getDatabase(dbname);
	    ViewResults result = db.getAllDocuments();
		
int c=0,k=0;
		List<Document> sd=result.getResults();
		for (Document d: sd) {
		     
		
			String id=d.getJSONObject().getString("id");
		    
	
			Document row = db.getDocument(id);
	
           	   if( s1.equals(id) )
		    	{
           		   c++;
           		   if(row.containsKey("pwd"))
           		   { 
           			   k++;
           			   pass=row.get("pwd").toString();
           			
           			   if(s2.equals(pass))
           		       { 
           				   
           				   cs="Welcome	"+row.get("username").toString() ;
           				   break;
           				   }
           		   }
		    	  }
		    	else
		    	{
		    	cs="Please Register";
		    	}
		    
		        
		}

		return cs;
}

	@Override
	public String register(String s1, String s2, String s3)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
        dbSession = new Session("127.0.0.1",5984);
		
		String dbname="user";
		
		Database db=dbSession.getDatabase(dbname);
		
		Document doc=new Document();
		doc.setId(s1);
		
		
		doc.put("username",s2);
		doc.put("pwd",s3);
		db.saveDocument(doc);
		
		return "You are now registered";
	}*/
	
