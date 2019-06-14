package com.tc.Qrcode;

import com.swetake.util.Qrcode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;

/**
 * Created by tangc on 2016/5/13.
 */
public class QrcodeFactory {
    private static QrcodeFactory qrcodeFactory;
    private QrcodeFactory(){}
    public static QrcodeFactory createFactory(){
        if (null == qrcodeFactory)
            qrcodeFactory = new QrcodeFactory();
        return qrcodeFactory;
    }
    public static void dispose(){
        qrcodeFactory = null;
    }

    /**
     * 创建二维码的true false分布图
     * @param qrcodeParam
     * @return
     */
    public boolean[][] createQrcodeDotPos(QrcodeParam qrcodeParam){
        Qrcode qrhand = new Qrcode();
        qrhand.setQrcodeVersion(qrcodeParam.getQrcodeVersion());
        qrhand.setQrcodeEncodeMode(qrcodeParam.getEncodeMode());
        qrhand.setQrcodeErrorCorrect(qrcodeParam.getErrorCorrect());

        byte[] contentBytes = new byte[0];
        try {
            if (null == qrcodeParam.getContent() || "".equals(qrcodeParam.getContent())) {
                contentBytes = "".getBytes("gbk");
            } else {
                contentBytes = qrcodeParam.getContent().getBytes("gbk");
            }
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return qrhand.calQrcode(contentBytes);
    }

    /**
     * 生成二维码图片
     * @param qrcodeParam
     * @return
     */
    public BufferedImage createQrcodeImage(QrcodeParam qrcodeParam){
        boolean[][] codeOut = createQrcodeDotPos(qrcodeParam);

        BufferedImage bufferedImage = new BufferedImage(qrcodeParam.getWidth(),
                qrcodeParam.getHeight(),
                qrcodeParam.getImgType());
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setBackground(Color.white);
        graphics.setColor(Color.black);
        graphics.clearRect(0, 0, qrcodeParam.getWidth(), qrcodeParam.getHeight());

        //生成二维码的图片的位图，有内容就是true，没有就是false
        //遍历二维数组，获取他的值，生成二维码图片。
        for (int i = 0; i < codeOut.length; i++) {
            for (int j = 0; j < codeOut[i].length; j++) {
                if (codeOut[i][j]){
                    graphics.fillRect(j*3+2,i*3+2,3,3);
                }
            }
        }
        //释放资源
        graphics.dispose();
        //刷新缓存
        bufferedImage.flush();

        return bufferedImage;
    }
}
