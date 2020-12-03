package com.example.mfsp.utility;



import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @ClassName: RequestUtil
 * @Description: checkObj
 * @Author
 * @Date 2020/12/01
 * @Version 1.0
 */


public class RequestUtil {

    /**
     * 禁止实例化
     */
    private RequestUtil() {}

    /**
     * 请求中至少有一个参数不为空
     *
     * @param t
     * @param resultNote
     * @param <T>
     */
//    public static <T> void mustHaveOneMoreParams(String resultNote, T t, String... ignoreParams) {
//        Class<?> tClass = t.getClass();
//        Field[] fields = tClass.getDeclaredFields();
//        List<String> ignoreList = Arrays.asList(ignoreParams);
//        int count = 0;
//        for (Field f : fields) {
//            f.setAccessible(true);
//            try {
//                Object o = f.get(t);
//                if (ignoreList.contains(f.getName())) {
//                    continue;
//                }
//                if (o == null) {
//                    continue;
//                }
//                if ("".equals(o.toString().trim())) {
//                    Annotation[] declaredAnnotations = f.getDeclaredAnnotations();
//                    if (declaredAnnotations.length > 0) {
//                        Class<? extends Annotation> aClass = declaredAnnotations[0].annotationType();
//                        if (aClass == NotBlank.class) {
//                            throw new ValidateException(ResultCodeConstant.PARAMS_ERROR, "该参数不能传入空字符串：" + f.getName());
//                        }
//                    }
//                }
//                count++;
//            } catch (IllegalAccessException e) {
//                Log.warn("参数错误：" + f.getName());
//            }finally {
//                f.setAccessible(true);
//            }
//        }
//        if (count == 0) {
//            throw new ValidateException(ResultCodeConstant.PARAMS_ERROR, resultNote);
//        }
//    }
//
//    /**
//     * 校验请求参数中是否至少有一个有效的参数
//     *
//     * @param t
//     * @param ignoreParams
//     * @param <T>
//     * @return
//     */
//    public static <T> boolean isHaveOneMoreParams(T t, String... ignoreParams) {
//        try {
//            mustHaveOneMoreParams(t, ignoreParams);
//        } catch (Exception e) {
//            Log.warn(e.getMessage());
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 请求参数中至少存在一个值不为空
//     *
//     * @param t
//     * @param <T>
//     */
//    public static <T> void mustHaveOneMoreParams(T t, String... ignoreParams) {
//        mustHaveOneMoreParams("至少传入一个有效参数！", t, ignoreParams);
//    }
//
//    /**
//     * 对get请求中的中文参数进行转码操作,默认编码转换 IS0_8859_1 -> UTF-8
//     *
//     * @param t 请求req类
//     * @param fixParams 需要转码的参数名
//     * @param <T> 泛型
//     */
//    public static <T> void chineseEncodingFix(T t, String... fixParams) {
//        Class<?> clazz = t.getClass();
//        List<String> fixParamList = Arrays.asList(fixParams);
//        fixParamList.forEach(x -> {
//            Field field =  null;
//            try {
//                field = clazz.getDeclaredField(x);
//                field.setAccessible(true);
//                Object o = field.get(t);
//                if(o != null) {
//                    o = new String(o.toString().getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
//                    field.set(t,o);
//                }
//            } catch (NoSuchFieldException | IllegalAccessException e) {
//                Log.error("",e);
//            } finally {
//                if (field != null) {
//                    field.setAccessible(false);
//                }
//            }
//        });
//    }
//
//    /**
//     * 标记是否可以为空串
//     */
//    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
//    @Retention(RUNTIME)
//    public @interface NotBlank {
//
//    }
}

