/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movierental;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Acer
 */
public class MouseImpl implements MouseListener {

    int id;
    
    public MouseImpl(int id){
        this.id = id;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(getId());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public int getId() {
        return id;
    }
    
    
}
