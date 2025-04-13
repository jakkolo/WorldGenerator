import javax.swing.*;
import java.awt.event.ActionEvent;

public class InputController {
    private final GraphicOutput.MainPanel panel;

    InputController(GraphicOutput.MainPanel panel){
        this.panel = panel;
        setupKeyBindings();
    }

    private void setupKeyBindings() {
        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("a"), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke("d"), "moveRight");
        inputMap.put(KeyStroke.getKeyStroke("w"), "moveForward");
        inputMap.put(KeyStroke.getKeyStroke("s"), "moveBackwards");

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.moveLeft();
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.moveRight();
            }
        });
    }
}
