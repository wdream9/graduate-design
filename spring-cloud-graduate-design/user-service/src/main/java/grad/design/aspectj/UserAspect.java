package grad.design.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
//@Component
public class UserAspect {
//    @Pointcut("execution(public * com.example.demo.controller.HelloController.add*(..))")
    public void addAdvice(){}
    @Around("addAdvice()")
    public Object Interceptor(ProceedingJoinPoint pjp){
        Object result = null;
        Object[] args = pjp.getArgs();
        if(args != null && args.length >0) {
            String deviceId = (String) args[0];
            if(!"03".equals(deviceId)) {
                return "no anthorization";
            }
        }
        try {
            result =pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }
}
