package application.client.control;

import network.Message;
import network.client.ClientApplicationInterface;
import protocol.server2client.*;

public class Dispatcher implements ClientApplicationInterface {
    @Override
    public void handleMessage(Message message) {
        if (message instanceof PlayerJoined) {
            PlayerJoinedControl control = ControlFactory.instance().createPlayerJoinedControl();
            control.playerJoined((PlayerJoined)message);
        } else if (message instanceof ErrorMessage) {
            ErrorMessageControl control = ControlFactory.instance().createErrorMessageControl();
            control.errorMessage((ErrorMessage)message);
        } else if (message instanceof StartGame) {
            StartGameControl control = ControlFactory.instance().createStartGameControl();
            control.startGame((StartGame) message);
        }
    }
}
