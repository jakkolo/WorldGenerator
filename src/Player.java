import constants.Drawable;

import java.awt.*;
import java.util.ArrayList;

public class Player implements Drawable {



    Player(ArrayList<Drawable> drawables){
        drawables.add(this);

    }
    @Override
    public void draw(Graphics g) {

    }
}
