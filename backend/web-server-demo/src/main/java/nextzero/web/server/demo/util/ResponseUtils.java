package nextzero.web.server.demo.util;

import nextzero.web.server.demo.entity.BaseResponse;
import nextzero.web.server.demo.entity.BaseResponsePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ResponseUtils {
    public static Logger LOG = LoggerFactory.getLogger(ResponseUtils.class);
    public static final Map<Integer, String> ErrorInfo = new HashMap<>();

    /**
     * 加载错误码说明
     */
    static{
        synchronized (ResponseUtils.class){
            InputStreamReader in = null;
            try {
                in = new InputStreamReader(Object.class.getResourceAsStream("/error.info"), "UTF-8");
                Properties properties = new Properties();
                properties.load(in);

                Iterator<Object> iter = properties.keySet().iterator();
                while(iter.hasNext()){
                    String key = iter.next().toString();
                    Integer code = Integer.valueOf(key);
                    ErrorInfo.put(code, properties.getProperty(key));
                }
            } catch (IOException e) {
                LOG.error("", e);
            }finally {
                if(null != in){
                    try {
                        in.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    public static <T> BaseResponsePage<T> success(long total, List<T> data){
        BaseResponsePage response = new BaseResponsePage();
        response.setError(0);
        response.setMsg(errorInfo(0));
        response.setTotal(total);
        response.setData(data);
        return response;
    }

    public static <T> BaseResponse<T> success(T data){
        BaseResponse response = new BaseResponse ();
        response.setError(0);
        response.setMsg(errorInfo(0));
        response.setData(data);
        return response;
    }

    public static BaseResponse success(){
        BaseResponse response = new BaseResponse ();
        response.setError(0);
        response.setMsg(errorInfo(0));
        return response;
    }

    public static BaseResponse fail(int code){
        BaseResponse response = new BaseResponse ();
        response.setError(code);
        response.setMsg(errorInfo(code));
        return response;
    }

    public static BaseResponse fail(String msg){
        BaseResponse response = new BaseResponse ();
        response.setError(-1);
        response.setMsg(msg);
        return response;
    }

    public static String errorInfo(int code){
        if(ErrorInfo.containsKey(code)){
            return ErrorInfo.get(code);
        }else{
            return "未知错误";
        }
    }
}
