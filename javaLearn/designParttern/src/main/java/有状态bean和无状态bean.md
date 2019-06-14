内容摘自https://blog.csdn.net/bingjing12345/article/details/9794945 (写得挺不错的)
## 有状态bean和无状态bean
http://www.iteye.com/topic/959751


http://www.iteye.com/topic/960532


一个类的内部状态创建后，在整个生命期间都不会发生变化时，就是不变类。这种使用不变类的做法叫做不变模式。

不变模式有两种形式：一种是弱不变模式，另一种是强不变模式。

弱不变模式：
一个类的实例的状态是不可变化的，但是这个类的引用的实例具有可能会变化的状态。这样的类符合弱不变模式的定义。要实现弱不变模式，一个类必须满足如下条件：

    第一，对象没有任何方法会修改对象的状态，当对象的构造函数对对象的状态初始化之后，对象的状态便不再改变。

    第二，所有的属性都应当是私有的，以防客户端对象直接修改任何的内部状态。

    第三，这个对象所引用的对象如果是可变对象的话，必须设法限制外界对这个对象的访问，以防止对这些对象的修改。如果可能应该尽量在不变对象的内部来初始化。

    弱不变模式的缺点是：
一个弱不变对象引用的实例变量可以是可变对象，可能会通过外界修改父对象的状态，这是一个显著的缺点。可以在初始化可变对象时，先进行clone。

代码演示：
Java代码  收藏代码

    /** 
     * @author Peter Wei 
     *  
     */  
    public class User {  
      
        private String name;  
      
        public String getName() {  
            return name;  
        }  
      
        public void setName(String name) {  
            this.name = name;  
        }  
      
    }  
      
    /** 
     * 弱不变模式 
     *  
     * @author Peter Wei 
     *  
     */  
    public class WeakImmutable {  
      
        // 属性私有，满足条件2  
        private int state;  
        // 属性私有，满足条件2  
        private User user;  
      
        private Integer age;  
      
        public WeakImmutable(int state, User user, Integer age) {  
            this.state = state;  
            this.user = user;  
            this.age = age;  
        }  
      
        public int getState() {  
            return this.state;  
        }  
      
        public User getUser() {  
            return this.user;  
        }  
      
        public Integer getAge() {  
            return this.age;  
        }  
      
        public void setState() {  
            // 对象没有任何方法修改对象的状态,满足条件1  
            // do nothing.  
        }  
      
        public static void main(String[] args) {  
            int state = 0;  
            User u = new User();  
            Integer age = 100;  
            u.setName("yes");  
            WeakImmutable weak = new WeakImmutable(state, u, age);  
            System.out.println("原始值：" + weak.getState() + ","  
                    + weak.getUser().getName() + "," + weak.getAge());  
            // 修改引用后  
            state = 5;  
            // User由于是可变对象引用，所以有影响  
            u.setName("no");  
            age = 200;  
            System.out.println("修改引用后：" + weak.getState() + ","  
                    + weak.getUser().getName() + "," + weak.getAge());  
        }  
    }  

结果：可以看到user的名字会改变。
原始值：0,yes,100
修改引用后：0,no,100

我们再引伸一个不可变类的例子:
在时间截止时，我们需要一一检查队列成员是不是vip,如果是可以去USA.假设是多线程环境,并且users数组是多线程共享,那么另外的线程通过users去修改users[n],这时就会把users[n]绕过时间检查而去USA.

Java代码  收藏代码

    /** 
     * 不变模式之clone 
     *  
     * @author Peter Wei 
     *  
     */  
    public class WeakImmutableClone {  
      
        public static void main(String[] args) {  
      
            User[] users = new User[3];  
            users[0] = new User();  
            users[0].setName("peterwei");  
            users[1] = new User();  
            users[1].setName("Tomssssss");  
            users[2] = new User();  
            users[2].setName("peterwei88");  
      
            time4Check();  
            /* 
             * 时间到，我们需要一一检查队列成员是不是vip,如果是可以去USA.假设是多线程环境,并且users数组是多线程共享, 
             * 那么另外的线程通过users去修改users[n],这时就会把users[n]绕过时间检查而去USA. 
             */  
            goUSA(users);  
      
        }  
      
        public static void goUSA(User[] users) {  
      
            // User[] tmp = new User[users.length];  
            // System.arraycopy(users, 0, tmp, 0, users.length);  
      
            for (User u : users) {  
                if (checkVip(u)) {  
                    System.out.println("You can go!");  
                } else {  
                    System.out.println("go away!");  
                }  
      
            }  
        }  
      
        public static boolean checkVip(User user) {  
            if (user.getName().startsWith("peterwei")) {  
                return true;  
            }  
            return false;  
        }  
      
        public static void time4Check() {  
            // 假设时间期限到，要检查上万人以上的队列。  
        }  
    }  


解决方法：
在事务处理及数据大批量入库的多线程环境中，应该也会有类似的问题。所以对于这样的传入参数及上例中的不变对象引用可变对象,我们可以将其在相关构造函数及方法中复制为本地变量(数组),及使用它的深度clone,阻止相关数据与外部线程的联系。

Java代码  收藏代码

    public static void goUSA(User[] users) {  
      
        User[] tmp = new User[users.length];  
        System.arraycopy(users, 0, tmp, 0, users.length);  
      
        for (User u : tmp) {  
            if (checkVip(u)) {  
                System.out.println("You can go!");  
            } else {  
                System.out.println("go away!");  
            }  
      
        }  
    }  


强不变模式：

    一个类的实例的状态不会改变，同时它的子类的实例也具有不可变化的状态。这样的类符合强不变模式。要实现强不变模式，一个类必须首先满足弱不变模式所要求的所有条件，并且还要满足下面条件之一：
    第一，所考虑的类所有的方法都应当是final，这样这个类的子类不能够置换掉此类的方法。
    第二，这个类本身就是final的，那么这个类就不可能会有子类，从而也就不可能有被子类修改的问题。

不变模式在Java中的应用
如String类
Java代码  收藏代码

    String a = "123" ;  
    String a1 = "123" ;  
    String a2 = "123" ;  
    String a3 = "1234" ;  


java虚拟机只会创建一个字符串实例，a,a1,a2对象共享一个值。遇到不同的字符串，java虚拟机会再创建一个String对象，如a3。如果程序所处理的字串有频繁的内容变化，就不宜使用String类型，而应当使用StringBuffer类型，如果需要对字串做大量的循环查询，也不宜使用String类型，应当考虑使用byte或char数组.

其它不变类：
The Integer,String, Float, Double, Byte, Long, Short, Boolean, and Character classes are all examples of an immutable class. By definition, you may not alter the value of an immutable object after its construction.In Java, a class such as Integer acts as a simple wrapper around its primitive counterpart -- in this case, int. The wrappers found in java.lang allow us to treat the primitives as if they were objects. So, for example, you could not put an int into a Vector without wrapping it。

优缺点：
不变模式可增强对象的健壮性。不变模式允许多个对象共享某一对象，降低了对该对象进行并发访问时的同步化开销。唯一缺点是一旦需要修改一个不变对象的状态，就只好创建一个新的同类对象，在需要频繁修改不变对象的环境里，会有大量的不变对象作为中间结果被创建出来，再被Java的垃圾收集器收走，这是一种资源的浪费。

总结：
不变模式的核心就是对象不变，从而引伸出对象复用共享的思想。如无状态的单例模式，享元(Flyweight)模式及原型模式(Prototype)都可以认为是不变模式的应用。其它如线程池，缓存等的实现也一定程度上是使用不变模式。还有EJB的Stateless Session Bean(无状态会话bean),Spring对Service层、Dao层bean的默认单例实现，我认为都是沿用了不变模式中共享的思想。





基本概念：

有状态就是有数据存储功能。有状态对象(Stateful Bean)，就是有实例变量的对象，可以保存数据，是非线程安全的。在不同方法调用间不保留任何状态。

无状态就是一次操作，不能保存数据。无状态对象(Stateless Bean)，就是没有实例变量的对象.不能保存数据，是不变类，是线程安全的。

代码更好理解：

Java代码  收藏代码

    /** 
     * 有状态bean,有state,user等属性，并且user有存偖功能，是可变的。 
     *  
     * @author Peter Wei 
     *  
     */  
    public class StatefulBean {  
      
        public int state;  
        // 由于多线程环境下，user是引用对象，是非线程安全的  
        public User user;  
      
        public int getState() {  
            return state;  
        }  
      
        public void setState(int state) {  
            this.state = state;  
        }  
      
        public User getUser() {  
            return user;  
        }  
      
        public void setUser(User user) {  
            this.user = user;  
        }  
    }  
      
    /** 
     * 无状态bean,不能存偖数据。因为没有任何属性，所以是不可变的。只有一系统的方法操作。 
     *  
     * @author Peter Wei 
     *  
     */  
    public class StatelessBeanService {  
      
        // 虽然有billDao属性，但billDao是没有状态信息的，是Stateless Bean.  
        BillDao billDao;  
      
        public BillDao getBillDao() {  
            return billDao;  
        }  
      
        public void setBillDao(BillDao billDao) {  
            this.billDao = billDao;  
        }  
      
        public List<User> findUser(String Id) {  
    return null;  
        }  
    }  


单例模式中的有状态和无状态:
单例类可以是有状态的（stateful），一个有状态的单例对象一般也是可变（mutable）单例对象。有状态的可变的单例对象常常当做状态库（repositary）使用。比如一个单例对象TaskCache（Spring中配为singleton）可以持有一个AtomicLong类型的属性，用来给一个系统提供一个数值惟一的序列号码，作为任务通迅管理的ID生成器。同时，一个单例类也可以持有一个聚集，从而允许存储多个状态，如示例中的ExpiringMap缓存任务列表。
代码示例：
Java代码  收藏代码

    import java.util.concurrent.atomic.AtomicLong;  
      
    import org.apache.mina.util.ExpiringMap;  
      
    /** 
     * Description: 内存中缓存的实时控制端任务列表.示例有状态的单例类 
     *  
     * @author Peter Wei 
     * @version 1.0 Dec 2, 2008 
     */  
    public class TaskCache {  
      
        // 请求超时  
        private short requestTimeout;  
      
        // 这个缓存Map是线程安全,并且有定时超时功能  
        private ExpiringMap<String, Object> tasksMap = new ExpiringMap<String, Object>();  
      
        // 线程安全的原子类,示例有状态的单例类  
        private static AtomicLong seqNo = new AtomicLong(1);  
      
        // 示例有状态的单例类  
        public Long nextSeqNo() {  
            return seqNo.getAndIncrement();  
        }  
      
        public void setRequestTimeout(short requestTimeout) {  
            this.requestTimeout = requestTimeout;  
        }  
      
        // 启动过期检测  
        public void startExpiring() {  
            tasksMap.getExpirer().setTimeToLive(requestTimeout);  
            tasksMap.getExpirer().startExpiringIfNotStarted();  
        }  
      
        // 停止过期检测  
        public void stopExpiring() {  
            tasksMap.getExpirer().stopExpiring();  
        }  
      
        // 取任务列表.  
        public Object getTasks(String key) {  
            return tasksMap.get(key);  
        }  
      
        // 去除任务列表.  
        public Object removeTasks(String key) {  
            return tasksMap.remove(key);  
        }  
      
        // 添加任务列表.  
        public void addTasks(String key, Object value) {  
            tasksMap.put(key, value);  
        }  
    }  



单例类也可以是没有状态的（stateless），仅用做提供工具性函数的对象。既然是为了提供工具性函数，也就没有必要创建多个实例，因此使用单例模式很合适。平常的单例类都是没有状态的，这里就不示例了。一个没有状态的单例类也就是不变（Immutable）单例类。关于不变模式，请参考http://www.iteye.com/topic/959751

EJB中的有状态与无状态：

1.Stateful session bean的每个用户都有自己的一个实例，所以两者对stateful session bean的操作不会影响对方。另外注意：如果后面需要操作某个用户的实例，你必须在客户端缓存Bean的Stub对象（JSP通常的做法是用Session缓存），这样在后面每次调用中，容器才知道要提供相同的bean实例。

2.Stateless Session Bean不负责记录使用者状态，Stateless Session Bean一旦实例化就被加进会话池中，各个用户都可以共用。如果它有自己的属性（变量），那么这些变量就会受到所有调用它的用户的影响。

3.从内存方面来看，Stateful Session Bean与Stateless Session Bean比较，Stateful Session Bean会消耗J2EE Server 较多的内存，然而Stateful Session Bean的优势却在于他可以维持使用者的状态。

Spring中的有状态(Stateful)和无状态(Stateless)

1.通过上面的分析，相信大家已经对有状态和无状态有了一定的理解。无状态的Bean适合用不变模式，技术就是单例模式，这样可以共享实例，提高性能。有状态的Bean，多线程环境下不安全，那么适合用Prototype原型模式。Prototype: 每次对bean的请求都会创建一个新的bean实例。

2.默认情况下，从Spring bean工厂所取得的实例为singleton（scope属性为singleton）,容器只存在一个共享的bean实例。

3.理解了两者的关系，那么scope选择的原则就很容易了：有状态的bean都使用prototype作用域，而对无状态的bean则应该使用singleton作用域。

4.如Service层、Dao层用默认singleton就行，虽然Service类也有dao这样的属性，但dao这些类都是没有状态信息的，也就是相当于不变(immutable)类，所以不影响。Struts2中的Action因为会有User、BizEntity这样的实例对象，是有状态信息的，在多线程环境下是不安全的，所以Struts2默认的实现是Prototype模式。在Spring中，Struts2的Action中，scope要配成prototype作用域。

Servlet、Struts中的有状态和无状态:

1.Servlet体系结构是建立在Java多线程机制之上的，它的生命周期是由Web 容器负责的。一个Servlet类在Application中只有一个实例存在，也就是有多个线程在使用这个实例。这是单例模式的应用。无状态的单例是线程安全的，但我们如果在Servlet里用了实例变量，那么就变成有状态了，是非线程安全的。如下面的用法就是不安全的,因为user,out都是有状态信息的。
Java代码  收藏代码

    /** 
     * 非线程安全的Servlet。 
     * @author Peter Wei 
     * 
     */  
    public class UnSafeServlet HttpServlet{  
          
        User user;  
        PrintWriter out;  
          
        public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{  
            //do something...  
        }  
    }  


Out,Request,Response,Session,Config,Page,PageContext是线程安全的,Application在整个系统内被使用,所以不是线程安全的.

2.Struts1也是基于单例模式实现，也就是只有一个Action实例供多线程使用。默认的模式是前台页面数据通过actionForm传入，在action中的excute方法接收，这样action是无状态的，所以一般情况下Strunts1是线程安全的。如果Action中用了实例变量，那么就变成有状态了，同样是非线程安全的。像下面这样就是线程不安全的。
Java代码  收藏代码

    /** 
     * 非线程安全的Struts1示例 
     *  
     * @author Peter Wei 
     *  
     */  
    public class UnSafeAction1 extends Action {  
      
        // 因为Struts1是单例实现，有状态情况下，对象引用是非线程安全的  
        User user;  
      
        public void execute() {  
            // do something...  
        }  
      
        public User getUser() {  
            return user;  
        }  
      
        public void setUser(User user) {  
            this.user = user;  
        }  
    }    



3.Struts2默认的实现是Prototype模式。也就是每个请求都新生成一个Action实例，所以不存在线程安全问题。需要注意的是，如果由Spring管理action的生命周期， scope要配成prototype作用域。

4.如何解决Servlet和Struts1的线程安全问题，当我们能比较好的理解有状态和无状态的原理，自然很容易得出结论：不要使用有状态的bean,也就是不要用实例变量。如果用，就要用prototype模式。Struts1 user guide里有： Only Use Local Variables - The most important principle that aids in thread-safe coding is to use only local variables, not instance variables , in your Action class.

总结：
Stateless无状态用单例Singleton模式，Stateful有状态就用原型Prototype模式。
Stateful 有状态是多线程编码的天敌，所以在开发中尽量用Stateless无状态，无状态是不变(immutable)模式的应用，有很多优点：不用管线程和同步的问题，如果值是不可变的，程序不用担心多个线程改变共享状态，所以可以避免线程竞争的bugs. 因为没有竞争，就不用用locks等机制，所以无状态的不变机制，也可以避免产生死锁现象。