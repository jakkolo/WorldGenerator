import javax.swing.*;
import java.awt.event.ActionEvent;

public class InputController {
    private final GraphicOutput.MainPanel panel;
    private final Player player;

    InputController(GraphicOutput.MainPanel panel, Player player) {
        this.panel = panel;
        this.player = player;
        setupKeyBindings();
    }

    private void setupKeyBindings() {
        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("A"), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke("D"), "moveRight");
        inputMap.put(KeyStroke.getKeyStroke("W"), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke("S"), "moveDown");

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.left();
                panel.repaint();
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.right();
                panel.repaint();
            }
        });

        actionMap.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.up();
                panel.repaint();
            }
        });

        actionMap.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.down();
                panel.repaint();
            }
        });
    }
}
