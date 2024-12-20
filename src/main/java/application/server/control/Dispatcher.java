package application.server.control;

import application.server.network.MessageQueue;
import application.server.network.MessageWrapper;
import protocol.client2server.ClientMessage;
import protocol.client2server.DropBomb;
import protocol.client2server.JoinGame;
import protocol.client2server.MovePlayer;

public class Dispatcher extends Thread {
    private volatile boolean running = true;
    private MessageQueue messageQueue;
    private ControllerFactory controllerFactory;

    public Dispatcher(MessageQueue queue, ControllerFactory controllerFactory) {
        messageQueue = queue;
        this.controllerFactory = controllerFactory;
    }

    @Override
    public void run() {
        while (running) {
            MessageWrapper wrapper = messageQueue.remove();
            ClientMessage message = wrapper.getMessage();
            String connectionId = wrapper.getConnectionId();
            Controller controller;
            if (message instanceof JoinGame) {
                controller = controllerFactory.createJoinGameController();
                try {
                    controller.handleMessage(message, connectionId);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if (message instanceof MovePlayer) {
                controller = controllerFactory.createMovePlayerController();
                try {
                    controller.handleMessage(message, connectionId);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if (message instanceof DropBomb) {
                controller = controllerFactory.createDropBombController();
                try {
                    controller.handleMessage(message, connectionId);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void stopDispatcher() {
        running = false;
    }
}
