package Singleton.case5;

/**
 * 双重检查加锁
 * 这种方式既可以实现线程安全地创建实例，而又不会对性能造成太大的影响。
 * 它只是在第一次创建实例的时候同步，以后就不需要同步了，从而加快了速度。
 * 提示：
 *      由于volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率并不是很高。因此一般建议，
 *  没有特别的需要，不要使用。也就是说，虽然可以使用“双重检查加锁”机制来实现线程安全的单例，但不建议
 *  大量采用，可以根据情况来选用。
 * Author:tangc
 * Date:2016/6/20
 * Time:9:40
 * DESCR:
 */
public class Singleton {
    /**
     * 对保持实例的变量添加volatile
     */
    private volatile static Singleton instance = null;

    private Singleton(){}

    public static Singleton getInstance(){
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if(null == instance){
            //同步块，线程安全地创建实例
            synchronized (instance){
                //再次检查实例是否存在，如果不存在才真正地创建实例
                if (null == instance){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
