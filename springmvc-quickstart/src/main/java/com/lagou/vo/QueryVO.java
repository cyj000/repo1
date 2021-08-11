package com.lagou.vo;

import com.lagou.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: QueryVO
 * @Author: CYJ
 * @Date: 2021-08-02 10:01:35
 * @Description:
 */
public class QueryVO {
    private String keyWord;
    private String[] nameArray;
    private List<User> userList;
    private Map<String,User> userMap;

    @Override
    public String toString() {
        return "QueryVO{" +
                "keyWord='" + keyWord + '\'' +
                ", nameArray=" + Arrays.toString(nameArray) +
                ", userList=" + userList +
                ", userMap=" + userMap +
                '}';
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String[] getNameArray() {
        return nameArray;
    }

    public void setNameArray(String[] nameArray) {
        this.nameArray = nameArray;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }
}
