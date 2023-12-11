package application.server.control;

import network.server.Server;
import protocol.client2server.ClientMessage;

public class JoinGameController extends Controller{

    public JoinGameController(Server server){
        super(server);
    }
    @Override
    public void handleMessage(ClientMessage message, String connectionId){

    }
}
