package com.jiawa.train.generator.server;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2024-03-04 12:51
 * @description: 代码生成器
 **/
public class ServeGenerator {

    static String toPath = "generator\\src\\main\\java\\com\\jiawa\\train\\generator\\";

    static String pomPath = "generator/pom.xml";

    static {
        new File(toPath).mkdirs();
    }

    public static void main(String[] args) throws Exception {
        SAXReader saxReader = new SAXReader();
        Map<String,String> map = new HashMap<>();
        map.put("pom","http://maven.apache.org/POM/4.0.0");
        saxReader.getDocumentFactory().setXPathNamespaceURIs(map);
        Document document = saxReader.read(pomPath);
        Node node = document.selectSingleNode("//pom:configurationFile");
        System.out.println(node.getText());

    }
}
