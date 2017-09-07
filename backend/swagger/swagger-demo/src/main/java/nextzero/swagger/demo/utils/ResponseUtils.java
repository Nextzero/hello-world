package nextzero.swagger.demo.utils;

import nextzero.swagger.demo.domain.BaseResponse;
import nextzero.swagger.demo.domain.BaseResponsePage;

import java.util.List;
import java.util.Map;

public class ResponseUtils {

    public static BaseResponse success(){
        BaseResponse response = new BaseResponse();
        response.setError(0);
        response.setMessage("SUCCESS");
        return response;
    }

    public static BaseResponse success(Map data){
        BaseResponse response = success();
        response.setData(data);
        return response;
    }

    public static BaseResponse success(List page, int total){
        BaseResponsePage responsePage = new BaseResponsePage();
        responsePage.setError(0);
        responsePage.setMessage("SUCCESS");
        responsePage.setData(page);
        responsePage.setTotal(total);
        return responsePage;
    }

    public static BaseResponse fail(int error, String message){
        BaseResponse response = new BaseResponse();
        response.setError(error);
        response.setMessage(message);
        return response;
    }


}
