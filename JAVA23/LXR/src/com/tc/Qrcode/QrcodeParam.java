package com.tc.Qrcode;

import java.awt.image.BufferedImage;

/**
 * 对于Qrcode中传入参数相关类
 * 对于Qrcode相关的参数参考http://www.qrcode.com
 */
public class QrcodeParam {
    //纠错级别
    public char errorCorrect = CorrectErrorLevel.M.name().toCharArray()[0];
    //编码模式
    public char encodeMode = 'B';
    //版本号
    public int qrcodeVersion = 15;
    //宽度
    public int width = 235;
    //高度
    public int height = 235;
    //图片类型
    public int imgType = BufferedImage.TYPE_INT_RGB;
    //二维码内容
    public String content = "没有内容";

    public char getErrorCorrect() {
        return errorCorrect;
    }

    public void setErrorCorrect(char errorCorrect) {
        this.errorCorrect = errorCorrect;
    }

    public char getEncodeMode() {
        return encodeMode;
    }

    public void setEncodeMode(char encodeMode) {
        this.encodeMode = encodeMode;
    }

    public int getQrcodeVersion() {
        return qrcodeVersion;
    }

    public void setQrcodeVersion(int qrcodeVersion) {
        this.qrcodeVersion = qrcodeVersion;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getImgType() {
        return imgType;
    }

    public void setImgType(int imgType) {
        this.imgType = imgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
