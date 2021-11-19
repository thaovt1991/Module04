package com.codegym.model;

import java.util.Map;
import java.util.TreeMap;

public class Dictionary {
    Map<String,String> treeTranslate = new TreeMap<>() ;

   public Dictionary(){
       treeTranslate.put("Hello","Xin chao");
       treeTranslate.put("Hi","Xin chao");
       treeTranslate.put("World","The gioi");
       treeTranslate.put("Success","Thanh cong");
   }

    public Map<String, String> getTreeTranslate() {
        return treeTranslate;
    }
}
