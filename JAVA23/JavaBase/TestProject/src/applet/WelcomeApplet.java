package applet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tangc on 2016/2/17.
 */
public class WelcomeApplet extends JApplet{

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void init(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLayout(new BorderLayout());
                JLabel label = new JLabel(getParameter("greeting"),SwingConstants.CENTER);
                label.setFont(new Font("Serif", Font.BOLD, 18));
                add(label, BorderLayout.CENTER);
                JPanel panel = new JPanel();

                JButton button = new JButton("百度");
                button.addActionListener(makeAction("http://www.baidu.com"));
                panel.add(button);

                JButton button1 = new JButton("淘宝");
                button1.addActionListener(makeAction("http://www.taobao.com"));
                panel.add(button1);

                add(panel, BorderLayout.SOUTH);
            }
        });
    }

    private ActionListener makeAction(final String urlString){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getAppletContext().showDocument(new URL(urlString));
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }
}
