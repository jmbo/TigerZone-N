
/**********************************************************************

  �TigerClient� Class will establish a socket connection to the server using a provided IP address and port number. 
  The TigerClient will listen on then socket for messages from the server. 
  The client will provide an output stream for which messages will be sent to the server.  
  The TigerClient class will be instantiated as part of the main application, it will pass the IP address of the server as an argument.  
  ***See below as example of the main application.*** 

***********************************************************************/

/*
public static void main(String[] args)  
{
     
     // Get IP address, if none provided use �localhost� 
     String serverAdx = (args.length == 0)?"localhost":args[1];

     TigerClient client = new TigerClient(serverAdx);
	   �
	   Client.talktoserver();

*/

/* The TigerClient will realize the Tigerzone protocol which is entirely text based. */ 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/* A client for the Tigerzone game */
public class TigerClient 
{
    private static int PORT = 1234;  /* TODO: Get port number. For now hardcoded */
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    /* Constructs the client by connecting to a server */
    public TigerClient(String serverAdx) 
    {
        // Setup connection
        socket = new Socket(serverAdx, PORT);

	      // input stream
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	      
        // output stream
        // Second argument is boolean value. When true: println / printf methods will flush the output buffer
        out = new PrintWriter(socket.getOutputStream(), true);
    }

 /* The TigerClient will have a method that will talk with the server and realizes the communication protocols. */

     public void talktoserver() 
     {
          String response;

          // TODO: display server messages on terminal screen
          
          while(true)
          {
              response = in.readLine();

              // Authentication Protocol

              if (response.startsWith("THIS IS SPARTA!")) 
              {
	             // display message on terminal screen
		         // send back �join� 
                 // out.println(�JOIN �    
              } 
              
              else if (response.startsWith("HELLO!")) 
              {
		         // send back �I am � with username and password   
              }
              
              else if (response.startsWith("WELCOME")) 
              {
		         // end of authentication
		         // Save off passed in PID
		         // authenticated = true
	          }

	            // Challenge Protocol
	            if( authenticated )
              {
                  if (response.startsWith("NEW CHALLANGE")) 
                  {
	                    /* save off passed in CID and ROUNDS */
	                    /* challenge = true */
                  }
              }
          }
    }
}