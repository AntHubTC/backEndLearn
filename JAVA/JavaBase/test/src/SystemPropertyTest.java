
public class SystemPropertyTest {

	public static void main(String[] args) {
		System.out.println("当前系统名："+System.getProperty("os.name"));
		System.out.println("当前系统版本："+System.getProperty("os.version"));
		System.out.println("当前用户名："+System.getProperty("user.name"));
		System.out.println("用户的主目录："+System.getProperty("user.home"));
		System.out.println("用户的工作目录："+System.getProperty("user.dir"));
		System.out.println("JRE版本号："+System.getProperty("java.version"));
		System.out.println("JRE安装目录："+System.getProperty("java.home"));
		System.out.println("临时文件的安装目录："+System.getProperty("java.io.tmpdir"));
		System.out.println("当前的类路径列表："+System.getProperty("java.home"));
		System.out.println("当前系统的换行符："+System.getProperty("Line.separator"));
		System.out.println("当前系统文件路径分隔符："+System.getProperty("file.separator"));
		System.out.println("当前系统的文件编码方式："+System.getProperty("file.encoding"));
		System.out.println("系统环境变量 PATH:\r\n"+System.getenv("PATH"));
		System.out.println("系统环境变量 CLASSPATH:"+System.getenv("CLASSPATH"));
		System.out.println("本JVM可用的CPU数目："+Runtime.getRuntime().availableProcessors());
		System.out.println("本JVM可用的最大内存量：");
		Runtime.getRuntime().gc();
	}

}
