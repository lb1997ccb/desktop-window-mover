package org.windowmover;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A graphical user interface (GUI) application that allows users to move a window on the desktop
 * in four directions: up, down, left, and right.
 */
public class DesktopWindowMoverGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton moveUp, moveDown, moveLeft, moveRight;
    private int xPosition, yPosition;
    private final int windowWidth = 300, windowHeight = 300;

    /**
     * ActionListener implementation to handle button clicks for window movement.
     */
    class MoveListener implements ActionListener {
        /**
         * Responds to button clicks by adjusting the window position based on the button pressed.
         *
         * @param e The ActionEvent triggered by button click.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == moveUp && yPosition > 0) {
                yPosition -= 10; // Move window up by 10 pixels
            } else if (e.getSource() == moveDown && yPosition < getDesktopHeight() - windowHeight) {
                yPosition += 10; // Move window down by 10 pixels
            } else if (e.getSource() == moveLeft && xPosition > 0) {
                xPosition -= 10; // Move window left by 10 pixels
            } else if (e.getSource() == moveRight && xPosition < getDesktopWidth() - windowWidth) {
                xPosition += 10; // Move window right by 10 pixels
            }
            setLocation(xPosition, yPosition); // Update window position
        }
    }

    /**
     * Constructs the GUI window for moving the desktop window.
     */
    public DesktopWindowMoverGUI() {
        super("Desktop Window Mover GUI"); // Set window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application on close
        setSize(windowWidth, windowHeight); // Set initial window size

        // Calculate initial window position centered on the desktop
        xPosition = (getDesktopWidth() - windowWidth) / 2;
        yPosition = (getDesktopHeight() - windowHeight) / 2;
        setLocation(xPosition, yPosition); // Set window position

        // Create buttons for moving the window in each direction
        moveUp = new JButton("Move Up");
        moveDown = new JButton("Move Down");
        moveLeft = new JButton("Move Left");
        moveRight = new JButton("Move Right");

        // Add ActionListener to handle button clicks
        MoveListener listener = new MoveListener();
        moveUp.addActionListener(listener);
        moveDown.addActionListener(listener);
        moveLeft.addActionListener(listener);
        moveRight.addActionListener(listener);

        // Set layout for the GUI using BorderLayout with vertical spacing of 25 pixels
        setLayout(new BorderLayout(0, 25));

        // Add buttons to the GUI in their respective positions
        add(moveUp, BorderLayout.NORTH);
        add(moveDown, BorderLayout.SOUTH);
        add(moveLeft, BorderLayout.WEST);
        add(moveRight, BorderLayout.EAST);

        setVisible(true); // Make the GUI visible
    }

    /**
     * Retrieves the width of the desktop screen.
     *
     * @return The width of the desktop screen in pixels.
     */
    private int getDesktopWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    /**
     * Retrieves the height of the desktop screen.
     *
     * @return The height of the desktop screen in pixels.
     */
    private int getDesktopHeight() {
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }
}
