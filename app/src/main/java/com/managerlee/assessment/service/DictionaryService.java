package com.managerlee.assessment.service;

import com.managerlee.assessment.bean.DictBean;
import com.managerlee.assessment.constant.URLConstant;
import com.managerlee.assessment.framework.http.data.ResponseData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 字典值服务
 * Created by anins on 2018/4/25.
 */

public interface DictionaryService {

    @GET(URLConstant.Dict_GetDictListByEnName)
    Observable<ResponseData<List<DictBean>>> getDictListByEnName(@Query("EnName") String enName);
}
