package com.jong.guadalupe.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;

public class GuadalupeCart {
    public Document addCart(String user, String pass, String id, String sku, String qnt) {
        GuadalupeLogin guadalupeLogin = new GuadalupeLogin();
        Connection.Response login = guadalupeLogin.Login(user, pass);
        Connection.Response response = null;
        Document document = null;
        try {
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("id_produto",id);
            hashMap.put("id_sku", sku);
            hashMap.put("nome","");
            hashMap.put("email","");
            hashMap.put("quantidade",qnt);
            hashMap.put("cep","");
            hashMap.put("AJAX","1");

            response = Jsoup.connect("http://guadalupestore.com.br/carrinho/")
                    .timeout(60*1000)
                    .cookies(login.cookies())
                    //.headers(login.headers())
                    .data(hashMap)
                    .validateTLSCertificates(false)
                    .method(Connection.Method.POST)
                    .execute();
             document = response.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
