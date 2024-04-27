package com.kuznetsov.clock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock {

    private final SimpleDateFormat timeFormat;
    private final SimpleDateFormat dateFormat;
    private final SimpleDateFormat dayOfWeekFormat;
    private final JLabel timeLabel;
    private final JLabel dateLabel;
    private final JLabel dayOfWeekLabel;

    Clock() {
        //frame settings    -->
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("src/com/kuznetsov/clock/ClockIcon.png");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Clock");
        frame.setIconImage(icon.getImage());
        frame.setSize(400, 200);
        frame.getContentPane().setBackground(new Color(15, 15, 15));
        frame.setLayout(new GridLayout(3, 1));


        //time settings -->
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Impact", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(225, 0, 0));
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);


        //date settings -->
        dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
        dateLabel.setForeground(new Color(225, 225, 225));
        dateLabel.setVerticalAlignment(SwingConstants.CENTER);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);


        //day settings  -->
        dayOfWeekFormat = new SimpleDateFormat("EEEE");
        dayOfWeekLabel = new JLabel();
        dayOfWeekLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
        dayOfWeekLabel.setForeground(new Color(225, 225, 225));
        dayOfWeekLabel.setVerticalAlignment(SwingConstants.CENTER);
        dayOfWeekLabel.setHorizontalAlignment(SwingConstants.CENTER);


        //adding components to the frame    -->
        frame.add(timeLabel);
        frame.add(dateLabel);
        frame.add(dayOfWeekLabel);


        //frame settings    -->
        frame.setResizable(true);
        frame.setVisible(true);


        run();
    }

    private void run() {
        while (true) {
            update();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update() {
        timeLabel.setText(timeFormat.format(Calendar.getInstance().getTime()));
        dayOfWeekLabel.setText(dayOfWeekFormat.format(Calendar.getInstance().getTime()));
        dateLabel.setText(dateFormat.format(Calendar.getInstance().getTime()));
    }

}
