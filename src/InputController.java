import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class InputController implements ActionListener {
    private final GraphicOutput.MainPanel panel;
    private final Player player;

    private final static String PRESSED = "pressed ";
    private final static String RELEASED = "released ";
    private final Timer timer;
    private final Map<String, String> pressedKeys = new HashMap<>();

    InputController(GraphicOutput.MainPanel panel, Player player, int delay) {
        this.panel = panel;
        this.player = player;

        timer = new Timer(delay, this);
        timer.setInitialDelay(0);

        setupKeyBindings();
    }

    private void setupKeyBindings() {
        addAction("A", "moveLeft");
        addAction("D", "moveRight");
        addAction("W", "moveUp");
        addAction("S", "moveDown");
    }

    public void addAction(String keyStroke, String action) {
        //  Separate the key identifier from the modifiers of the KeyStroke

        int offset = keyStroke.lastIndexOf(" ");
        String key = offset == -1 ? keyStroke : keyStroke.substring(offset + 1);
        String modifiers = keyStroke.replace(key, "");

        //  Get the InputMap and ActionMap of the component

        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();

        //  Create Action and add binding for the pressed key

        Action pressedAction = new AnimationAction(key, action);
        String pressedKey = modifiers + PRESSED + key;
        KeyStroke pressedKeyStroke = KeyStroke.getKeyStroke(pressedKey);
        inputMap.put(pressedKeyStroke, pressedKey);
        actionMap.put(pressedKey, pressedAction);

        //  Create Action and add binding for the released key

        Action releasedAction = new AnimationAction(key, null);
        String releasedKey = modifiers + RELEASED + key;
        KeyStroke releasedKeyStroke = KeyStroke.getKeyStroke(releasedKey);
        inputMap.put(releasedKeyStroke, releasedKey);
        actionMap.put(releasedKey, releasedAction);
    }

    private void handleKeyEvent(String key, String action) {
        //  Keep track of which keys are pressed

        if (action == null)
            pressedKeys.remove(key);
        else
            pressedKeys.put(key, action);

        //  Start the Timer when the first key is pressed

        if (pressedKeys.size() == 1) {
            timer.start();
        }

        //  Stop the Timer when all keys have been released

        if (pressedKeys.isEmpty()) {
            timer.stop();
        }
    }

    private class AnimationAction extends AbstractAction implements ActionListener {
        private final String action;

        public AnimationAction(String key, String action) {
            super(key);
            this.action = action;
        }

        public void actionPerformed(ActionEvent e) {
            handleKeyEvent((String) getValue(NAME), action);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (String action : pressedKeys.values()) {
            player.move(action);
            panel.repaint();
        }
    }
}
