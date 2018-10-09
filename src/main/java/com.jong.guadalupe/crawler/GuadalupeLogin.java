package com.jong.guadalupe.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;

public class GuadalupeLogin {
    public Connection.Response Login(String user, String pass){
        Connection.Response response = null;
        try {
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("email",user);
            hashMap.put("senha",pass);
            hashMap.put("AJAX", "1");
            response = Jsoup.connect("https://guadalupestore.appsisecommerce.com.br/login/")
                    .timeout(60*1000)
                    .validateTLSCertificates(false)
                    .data(hashMap)
                    .method(Connection.Method.POST)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
