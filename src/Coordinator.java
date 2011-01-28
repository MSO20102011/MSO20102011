public class Coordinator extends UserDecorator {

    public Coordinator(User u) {
        super(u);
    }

    /* Mark a given parent as having missed a lunch today. */
    public void reportMissingTurn(Parent p) { }
}
