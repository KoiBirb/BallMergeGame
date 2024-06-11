/**
 * Bucket.java
 * Mariana Trillos
 * June 12, 2024
 * Draws game bucket
 */

package GUI;
import Main.GamePanel;

import java.awt.*;

public class Bucket {

    Rectangle r;
    Color bucketBackground = new Color(248, 229, 187, 95);
    Color bucketOutline = new Color (255, 240,201);

    public Bucket() {
        r = new Rectangle(350, 150, 500, 500);
    }

    /**
    * Draws the bucket
     */
    public void draw() {

        GamePanel.gc.setColor(bucketBackground);
        GamePanel.gc.fillRect((r.x+20), (r.y -25), r.width-40, r.height+20); //back panel
        GamePanel.gc.fillRect(r.x, r.y, r.width, r.height); //front MAIN bucket panel

        GamePanel.gc.setColor(bucketOutline);
        GamePanel.gc.setStroke(6);
        GamePanel.gc.drawRect(r.x, r.y, r.width, r.height+20); //outline the main box

        GamePanel.gc.drawLine((r.x+20), (r.y -25), ((r.x+ r.width) -20), (r.y-25)); //"3d" lines
        GamePanel.gc.drawLine((r.x+20), (r.y -25), r.x , r.y );
        GamePanel.gc.drawLine(((r.x+ r.width) -20), (r.y-25), (r.x + r.width) , r.y );

    }
}
