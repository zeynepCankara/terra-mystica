package gameLogicManager.gameControllerManager;

public interface NotificationHandler {
    public default String createSuccessMessage() {
        return "The action was successful!";
    }

    public default String createErrorMessage() {
        return "There is an error!";
    }

    public default String createFailureMessage() {
        return "The action has failed!";
    }
}
