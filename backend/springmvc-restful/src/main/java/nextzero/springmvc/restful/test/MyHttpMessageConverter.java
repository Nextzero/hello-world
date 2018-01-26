package nextzero.springmvc.restful.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import nextzero.springmvc.restful.test.entity.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyHttpMessageConverter extends AbstractHttpMessageConverter {

    public MyHttpMessageConverter() {
        super(new MediaType("application", "x-czhc", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        System.out.println("调用了自定义的MyHttpMessageConverter");
        Charset charset = getContentTypeCharset(inputMessage.getHeaders().getContentType());
        String body = StreamUtils.copyToString(inputMessage.getBody(), charset);
        User user = (User)JSONObject.parseObject(body, clazz);
        return user;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String json = JSON.toJSON(o).toString();
        outputMessage.getBody().write(json.getBytes(), 0, json.getBytes().length);
    }

    private Charset getContentTypeCharset(MediaType contentType) {
        if (contentType != null && contentType.getCharset() != null) {
            return contentType.getCharset();
        }
        else {
            return getDefaultCharset();
        }
    }
}
