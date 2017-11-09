package Singleton.case3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 读取应用配置文件，单例实现
 * Author:tangc
 * Date:2016/6/18
 * Time:17:29
 * DESCR:
 */
public class AppConfig {
    private static AppConfig instance = new AppConfig();

    private AppConfig(){
        readConfig();//读取配置文件
    }

    public static AppConfig getInstance(){
        return instance;
    }

    private String paramA;
    private String paramB;

    public String getParamA() {
        return paramA;
    }

    public void setParamA(String paramA) {
        this.paramA = paramA;
    }

    public String getParamB() {
        return paramB;
    }

    public void setParamB(String paramB) {
        this.paramB = paramB;
    }

    /**
     * 读取配置文件，把配置文件中的内容读取出来设置到属性上
     */
    private void readConfig(){
        Properties prop = new Properties();
        InputStream in = null;
        in = AppConfig.class.getResourceAsStream("AppConfig.properties");
        try {
            prop.load(new InputStreamReader(in,"UTF-8"));
            setParamA(prop.getProperty("paramA"));
            setParamB(prop.getProperty("paramB"));
        } catch (IOException e) {
            System.out.println("装载配置文件出错，具体堆栈信息如下：");
            e.printStackTrace();
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
