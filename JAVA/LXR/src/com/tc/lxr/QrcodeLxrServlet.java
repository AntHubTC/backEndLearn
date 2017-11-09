package com.tc.lxr;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

import com.swetake.util.Qrcode;
import com.tc.Qrcode.CorrectErrorLevel;
import com.tc.Qrcode.QrcodeFactory;
import com.tc.Qrcode.QrcodeParam;

/**
 * 联系人二维码生成servlet
 * 1.引入
 * 2.创建qrcode的句柄（工具）
 * 3.设置纠错级别
 * 4.设置编码模式、二进制
 * 5.设置版本1-40 version
 * 6.获取图片缓冲对象
 * 7.获取制图工具
 * 8.写入内容生成二维码图片
 * Created by tangc on 2016/5/13.
 */
public class QrcodeLxrServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String content = req.getParameter("content");//获取二维码内容
        String sessionId = req.getSession().getId();
        String uuid = UUID.randomUUID().toString();

        //生成二维码
        QrcodeFactory factory = QrcodeFactory.createFactory();
        QrcodeParam qrcodeParam = new QrcodeParam();
        qrcodeParam.setErrorCorrect(CorrectErrorLevel.H.name().charAt(0));
        qrcodeParam.setContent(content);
        BufferedImage qrcodeImage = factory.createQrcodeImage(qrcodeParam);
        factory.dispose();

        StringBuilder createPath = new StringBuilder();
        createPath.append("/");
        createPath.append(sessionId);
        createPath.append("/");
        createPath.append(uuid);
        createPath.append(".png");

        StringBuilder path = new StringBuilder();
        path.append(this.getServletContext().getRealPath("/images/qrcode"));
        path.append(createPath.toString());

        File outputFile = new File(path.toString());
        outputFile.getParentFile().mkdirs();
        ImageIO.write(qrcodeImage, "PNG", outputFile);

        PrintWriter writer = resp.getWriter();
        writer.print(createPath.toString());

        //存储要删除的文件路径
        ArrayList<File> files = (ArrayList<File>) req.getSession().getAttribute("qrCTempFile");
        if(null == files){
            files = new ArrayList<File>();
        }
        files.add(outputFile);
        req.getSession().setAttribute("qrCTempFile",files);

        //super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("servlet destory!");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("servlet init!");
        super.init();
    }
}
