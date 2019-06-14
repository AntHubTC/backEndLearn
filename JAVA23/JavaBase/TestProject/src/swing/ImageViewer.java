package swing;

import com.tc.imageUtil.ImageUtil;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 图片浏览
 * Created by tangc on 2016/2/17.
 */
public class ImageViewer {
    public static void main(String[] args){
        ImageViewerFrame imageViewerFrame = new ImageViewerFrame();
        imageViewerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageViewerFrame.setVisible(true);
    }
}

class ImageViewerFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    private JFileChooser chooser;

    public ImageViewerFrame() {
        setTitle("图片浏览器");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        label = new JLabel();
        label.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(label);

        chooser = new JFileChooser();
        chooser.setApproveButtonText("选择");
        chooser.setDialogTitle("选择图片");
        FileFilter fileFilter = new FileNameExtensionFilter("imge file","jpg","png");
        chooser.addChoosableFileFilter(fileFilter);
        chooser.setCurrentDirectory(new File("."));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openitem = new JMenuItem("Open");
        menu.add(openitem);
        openitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = chooser.showOpenDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    String name = chooser.getSelectedFile().getPath();
                    try {
                        BufferedImage image = ImageUtil.resizeImage(new FileInputStream(new File(name)), DEFAULT_WIDTH, DEFAULT_HEIGHT);
                        ImageIcon imageIcon = new ImageIcon();
                        imageIcon.setImage(image);
                        label.setIcon(imageIcon);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        JMenuItem exitItem = new JMenuItem("exit");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
