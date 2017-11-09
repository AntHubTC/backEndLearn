package Factory.case1;

/**
 * Author:tangc
 * Date:2016/8/9
 * Time:20:44
 * DESCR:
 */
public class Client {
    public static void main(String args[]){
        //创建需要使用的Creator对象
        ExportOperate operate = new ExportDBOperate();
        //调用输出数据的功能方法
        operate.export("测试数据");
    }
}
