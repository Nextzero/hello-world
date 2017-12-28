package nextzero.web.server.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 参数工具
 */
public class ParamsUtils {
    protected static Logger LOG = LoggerFactory.getLogger(ParamsUtils.class);

    /**
     * 通过反射，将Bean的数据转换到Map
     * @param params
     * @return
     */
    public static Map<String, Object> convertBeanToMap(Object params){
        Map<String, Object> daoParams = new HashMap<>();
        try{
            Field[] userParams = params.getClass().getDeclaredFields();
            for(Field field : userParams){
                field.setAccessible(true);
                Object value = field.get(params);
                if(value != null){
                    daoParams.put(field.getName(), field.get(params));
                }
            }
        }catch (Exception e){
            LOG.error("", e);
        }
        return daoParams;
    }
}
