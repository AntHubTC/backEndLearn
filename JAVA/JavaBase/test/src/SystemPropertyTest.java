
public class SystemPropertyTest {

	public static void main(String[] args) {
		System.out.println("��ǰϵͳ����"+System.getProperty("os.name"));
		System.out.println("��ǰϵͳ�汾��"+System.getProperty("os.version"));
		System.out.println("��ǰ�û�����"+System.getProperty("user.name"));
		System.out.println("�û�����Ŀ¼��"+System.getProperty("user.home"));
		System.out.println("�û��Ĺ���Ŀ¼��"+System.getProperty("user.dir"));
		System.out.println("JRE�汾�ţ�"+System.getProperty("java.version"));
		System.out.println("JRE��װĿ¼��"+System.getProperty("java.home"));
		System.out.println("��ʱ�ļ��İ�װĿ¼��"+System.getProperty("java.io.tmpdir"));
		System.out.println("��ǰ����·���б�"+System.getProperty("java.home"));
		System.out.println("��ǰϵͳ�Ļ��з���"+System.getProperty("Line.separator"));
		System.out.println("��ǰϵͳ�ļ�·���ָ�����"+System.getProperty("file.separator"));
		System.out.println("��ǰϵͳ���ļ����뷽ʽ��"+System.getProperty("file.encoding"));
		System.out.println("ϵͳ�������� PATH:\r\n"+System.getenv("PATH"));
		System.out.println("ϵͳ�������� CLASSPATH:"+System.getenv("CLASSPATH"));
		System.out.println("��JVM���õ�CPU��Ŀ��"+Runtime.getRuntime().availableProcessors());
		System.out.println("��JVM���õ�����ڴ�����");
		Runtime.getRuntime().gc();
	}

}
