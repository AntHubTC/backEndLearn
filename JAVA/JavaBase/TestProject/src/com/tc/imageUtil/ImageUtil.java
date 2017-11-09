package com.tc.imageUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by tangc on 2016/2/17.
 */
public class ImageUtil {

    public static BufferedImage resizeImage(InputStream is, int newWidth, int newHeight) throws IOException {
        BufferedImage prevImage = ImageIO.read(is);
        double width = prevImage.getWidth(),
            height = prevImage.getHeight();
        BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);
        Graphics graphics = image.createGraphics();
        graphics.drawImage(prevImage, 0, 0, newWidth, newHeight, null);
        is.close();
        return image;
    }
}
