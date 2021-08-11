package com.lagou.conver;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DataConverter
 * @Author: CYJ
 * @Date: 2021-08-02 11:17:54
 * @Description: 类型转换器
 */

//将String类型的数据转换成Date类型
public class DataConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            if (s.contains("/")) {
                data = new Date(s);
                s = dateFormat.format(data);
            }
            data = dateFormat.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        String dateStr = "2021-12-01";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            if (dateStr.contains("/")) {
                Date date = new Date(dateStr);
                dateStr = dateFormat.format(date);
            }
            data = dateFormat.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(data);
    }
}
