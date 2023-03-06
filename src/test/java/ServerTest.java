import Server.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.Socket;

import static org.mockito.Mockito.*;



public class ServerTest {

    @Test
    public void testWhatPort(){
        //arrange
        int expected = 8888;//указал в settings.txt
        Server server = new Server();//при создании читает settings.txt
        //act
        int port = server.getPort();
        //assert
        Assertions.assertEquals(expected, port);
    }
    @Test
    public void testSendMessageToAll1(){
        //arrange
        Server server = new Server();
        ClientHandler clientHandler = mock(ClientHandler.class);
        //act
        server.sendMessageToAllClients("text", clientHandler);
        //assert
        Mockito.verify(clientHandler, Mockito.times(0)).sendMessage("text");
    }

   @Test
    public void testCounter(){
        //arrange
        ClientHandler clientHandler1 = new ClientHandler(mock(Socket.class), new Server());
       ClientHandler clientHandler2 = new ClientHandler(mock(Socket.class), new Server());
       int expected = 2;
       //act
       int count = ClientHandler.getCountClients();
       //assert
       Assertions.assertEquals(expected, count);
   }

}

