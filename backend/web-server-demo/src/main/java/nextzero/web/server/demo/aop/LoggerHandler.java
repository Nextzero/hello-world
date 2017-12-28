package nextzero.web.server.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LoggerHandler {
    private final static Logger LOG = LoggerFactory.getLogger(LoggerHandler.class);

    @Before(value = "execution ( * nextzero.web.server.demo.controller..*.*(..)) && @annotation(requestMapping)")
    public void injectCreatorInfo(JoinPoint jp, RequestMapping requestMapping) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        LOG.info("\n");
        LOG.info("收到请求");
        LOG.info("请求接口为：{}", request.getPathInfo() == null ? request.getServletPath() : request.getPathInfo());
        LOG.info("参数为列表：");
        Object[] args = jp.getArgs();
        for(Object arg : args){
            LOG.info(arg.toString());
        }
        LOG.debug("\n");
    }
}
