package com.yzu.objects;

import javax.swing.JButton;

public class ItemButton extends JButton {
    private float opacity;

    public void setOpacity(float opacity) {
        this.opacity = opacity;
        repaint();
    }

    public float getOpacity() {
        return this.opacity;
    }

    public ItemButton(String text) {
        super(text);
    }
}
