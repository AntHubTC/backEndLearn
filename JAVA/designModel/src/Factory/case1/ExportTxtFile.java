package Factory.case1;

/**
 * 导出文本格式的对象
 * Author:tangc
 * Date:2016/8/9
 * Time:20:29
 * DESCR:
 */
public class ExportTxtFile implements ExportFileApi{
    @Override
    public boolean export(String data) {
        //简单示意一下，这里需要操作文件
        System.out.println("导出数据(" + data +")到文本文件");
        return true;
    }
}
