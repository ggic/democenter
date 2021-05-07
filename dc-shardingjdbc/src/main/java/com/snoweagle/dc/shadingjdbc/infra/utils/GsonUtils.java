package com.snoweagle.dc.shadingjdbc.infra.utils;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class GsonUtils {
    public static final String TAG = GsonUtils.class.getSimpleName();

    private GsonUtils() {

    }

    private static Gson gson = null;


    private static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    static {
        if (gson == null) {
            gson = buildGson();
        }
    }

    /**
     * 默认的 GSON 初始化
     */
    public static Gson buildGson() {
        Gson gson = new Gson().newBuilder()
                .setDateFormat(DATE_FORMAT_DEFAULT)
                .create();
        return gson;
    }

    /**
     * 将对象转成json格式
     * Bean To Json
     *
     * @param object
     * @return String
     */
    public static String BeanToJson(Object object) {
        String jsonString = null;
        try {
            if (gson != null) {
                jsonString = gson.toJson(object);
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return jsonString;
    }


    public static <T> T JsonToBean(String jsonString, Class cls) {
        T t = null;
        try {
            if (gson != null) {
                t = (T) gson.fromJson(jsonString, cls);
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return t;
    }

    /**
     * json字符串转成list
     * 解决泛型问题
     * 备注：
     * List list=gson.fromJson(jsonString, new TypeToken<List>() {}.getType());
     * 该方法会报泛型类型擦除问题
     *
     * @param jsonString
     * @param cls
     * @param
     * @return
     */
    public static List JsonToList(String jsonString, Class cls) {
        List list = new ArrayList();
        try {
            if (gson != null) {
                JsonArray array = new JsonParser().parse(jsonString).getAsJsonArray();
                for (final JsonElement elem : array) {
                    list.add(gson.fromJson(elem, cls));
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return list;
    }


    public static <T> List<Map<String, T>> JsonToListMaps(String jsonString) {
        List<Map<String, T>> list = null;
        try {
            if (gson != null) {
                list = gson.fromJson(jsonString,
                        new TypeToken<List<Map<String, T>>>() {
                        }.getType());
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return list;
    }
    /**
     * json 字符串转成 map 的
     * Json To Map
     *
     * @param jsonString
     * @return
     */
    public static <T> Map<String, T> JsonToMaps(String jsonString) {
        Map<String, T> map = null;
        try {
            if (gson != null) {
                map = gson.fromJson(jsonString, new TypeToken<Map<String, T>>() {
                }.getType());
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return map;
    }
}
