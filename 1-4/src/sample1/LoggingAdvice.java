package sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        // targetのメソッド名を取得
        String methodName = invocation.getMethod().getName();
        StopWatch sw = new StopWatch();
        //time(時間)を図る
        sw.start(methodName);
        

        System.out.println("[LOG] METHOD: " + methodName + " is calling.");
        // targetのMessageBeanImplクラスのsayHello()が呼ばれると、sayHello()が実行される前にこのクラスのinvokeメソッドが実行される。
        // proceedが呼び出されると、ターゲットのsayHello()メソッドが実行される。
        Object rtnObj = invocation.proceed();
        
        sw.stop();
        
        System.out.println("[LOG] METHOD: " + methodName + " was called.");
        System.out.println("[LOG] 処理時間： " + sw.getTotalTimeMillis() / 1000 + "秒");
        
        return rtnObj;
    }
}