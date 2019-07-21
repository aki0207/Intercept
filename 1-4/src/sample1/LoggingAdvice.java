package sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        // target�̃��\�b�h�����擾
        String methodName = invocation.getMethod().getName();
        StopWatch sw = new StopWatch();
        //time(����)��}��
        sw.start(methodName);
        

        System.out.println("[LOG] METHOD: " + methodName + " is calling.");
        // target��MessageBeanImpl�N���X��sayHello()���Ă΂��ƁAsayHello()�����s�����O�ɂ��̃N���X��invoke���\�b�h�����s�����B
        // proceed���Ăяo�����ƁA�^�[�Q�b�g��sayHello()���\�b�h�����s�����B
        Object rtnObj = invocation.proceed();
        
        sw.stop();
        
        System.out.println("[LOG] METHOD: " + methodName + " was called.");
        System.out.println("[LOG] �������ԁF " + sw.getTotalTimeMillis() / 1000 + "�b");
        
        return rtnObj;
    }
}