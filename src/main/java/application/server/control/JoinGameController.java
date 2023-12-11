package application.server.control;

import application.server.model.Game;
import application.server.model.Player;
import network.Message;
import network.server.Server;
import protocol.client2server.ClientMessage;
import protocol.server2client.ErrorMessage;

public class JoinGameController extends Controller {

    public JoinGameController(Server server, Game game) {
        super(server, game);
    }

    @Override
    public void handleMessage(ClientMessage message, String connectionId) {
        if (game.NBOfPlayersComplete()) {
            Message response = new ErrorMessage("Spiel läuft bereits");
            server.send(response, connectionId);
        } else if (!game.isUnique(message.getPlayerName())) {
            Message response = new ErrorMessage("Spielername ist bereits vergeben");
            server.send(response, connectionId);
        } else {
            Player player = game.createPlayer(message.getPlayerName());
            Message response = player.createPlayerJoined();
            server.broadcast(response);
            if (game.NBOfPlayersComplete()){
                Message response1 = game.StartGame();
                server.broadcast(response1);
            }
        }
    }
}
