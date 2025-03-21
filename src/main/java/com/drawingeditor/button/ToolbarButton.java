package com.drawingeditor.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarButton {
    private JButton button;
    private String label;
    private ActionListener actionListener;

    public ToolbarButton(String label, ActionListener actionListener) {
        this.label = label;
        this.actionListener = actionListener;
        this.button = new JButton(label);

        // Set common button properties
        button.setPreferredSize(new Dimension(100, 40));
        button.setFocusable(false);
        button.setBackground(Color.WHITE);

        // Add the action listener to the button
        button.addActionListener(actionListener);
    }

    // Return the JButton to add to the toolbar
    public JButton getButton() {
        return button;
    }

    // Set the button label
    public void setLabel(String label) {
        button.setText(label);
    }

    // Set the button icon
    public void setIcon(Icon icon) {
        button.setIcon(icon);
    }

    // Set the action listener for the button
    public void setActionListener(ActionListener actionListener) {
        button.removeActionListener(actionListener); // Remove the previous listener
        button.addActionListener(actionListener);
    }
}
