package com.jong.guadalupe.crawler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jong.guadalupe.entity.InfoSkus;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GuadalupeInfo {
    public void getInfo(String url, String user, String pass, String qnt){
        try {
            Connection.Response response = Jsoup.connect(url)
                    .timeout(60*1000)
                    .validateTLSCertificates(false)
                    .method(Connection.Method.GET)
                    .execute();

            Document document = response.parse();
            //document.body().select("body > script:nth-child(32)");
            int lastIndex = document.getElementsByAttribute("type").size();
            String vars[] = document.getElementsByAttribute("type").get(lastIndex-1).toString().split("\n");

            ObjectMapper mapper = new ObjectMapper();
            HashMap<String,HashMap<String,Object >> hashMap = new HashMap<>();
            hashMap = mapper.readValue(vars[5].replace("var infoSkus = ",""), new TypeReference<Map<Object, Object>>(){});
            hashMap.remove("atualizaInfoPreco");
            hashMap.remove("apresentacaoVariacao");
            hashMap.remove("atualizaInfoPeso");
            AtomicInteger atomicInteger = new AtomicInteger();
            atomicInteger.set(0);
            hashMap.forEach((k,f)->{
                if (atomicInteger.get() == 0) {
                    if ((Boolean)f.get("disponivel") == true) {
                        String id = f.get("id").toString();
                        String id_sku = f.get("id_sku").toString();
                        GuadalupeCart guadalupeCart = new GuadalupeCart();
                        guadalupeCart.addCart(user,pass,id,id_sku,qnt);
                        atomicInteger.set(1);
                    } else {
                        System.out.println("PRODUTO SOLD OUT: " + f.get("id_sku") + " " + f.get("id"));
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
