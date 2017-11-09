package com.tc.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by tangc on 2016/5/14.
 */
public class httpSessionListenerHandler extends httpSessionListenerAdapter{
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ArrayList<File> files = (ArrayList<File>) session.getAttribute("qrCTempFile");
        if(null != files){
            for (File file : files) {
                file.delete();
                file.getParentFile().delete();
            }
        }

        super.sessionDestroyed(httpSessionEvent);
    }
}
