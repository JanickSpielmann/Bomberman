package application.server.control;

import network.server.Server;

public class ControllerFactory {
    private Server server;

    public ControllerFactory(Server server){
        this.server = server;
    }
    public Controller createJoinGameController() {
        return new JoinGameController(server);
    }
}
