package com.lsz.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description: map集合demo
 * map：
 * 1、map是一个双列结合，一个元素包括两个值 key，value
 * 2、key不允许重复，value可以重复
 * @author: Lishuzhen
 * @create: 2019-12-13 10:56
 */
public class TestMap {

    /**
     * HashMap 遍历
     * key-value 遍历
     * 需要遍历两次，
     * 第一次遍历 取出 key
     * 第二次遍历 通过 key 去 value
     * 效率低，不建议使用
     * Entry 遍历
     * 遍历一次，直接取出 Entry 键值对
     *
     * @param map
     */
    public static void hashMapTest(Map<String, Object> map) {

        /**
         * 第一种方式
         *  遍历先取出key，再通过key去value
         */
        Iterator iterator_key = map.keySet().iterator();
        while (iterator_key.hasNext()) {
            String key = (String) iterator_key.next();
            Object value = map.get(key);
            System.out.println("key = " + key + ",value = " + value.toString());
        }

        /**
         * 第二种方式 推荐
         *  一次遍历直接取出Entry
         */
        Iterator iterator_entry = map.entrySet().iterator();
        while (iterator_entry.hasNext()) {
            Map.Entry<String, Object> temp = (Map.Entry<String, Object>) iterator_entry.next();
            String key = temp.getKey();
            Object value = temp.getValue();
            System.out.println("key = " + key + ",value = " + value.toString());
        }
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("张三", "18");
        map.put("李四", "18");
        map.put("张三", "19");
        hashMapTest(map);
    }
}
