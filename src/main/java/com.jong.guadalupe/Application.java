package com.jong.guadalupe;

import com.jong.guadalupe.crawler.GuadalupeCart;
import com.jong.guadalupe.crawler.GuadalupeInfo;
import org.jsoup.nodes.Document;

import java.util.Base64;

public class Application {
    public static void main(String[] args) {

//        String user = "jhl1254@gmail.com";
        String user = "seungyooncho@gmail.com";
//        byte[] decodedBytes = Base64.getDecoder().decode("am9uZzEyMzQ=");
//        String decodedString = new String(decodedBytes);
//        String pass = decodedString;
        String pass = "didrlrks";
        String qnt = "1";

        //String id = "1146";
        //String sku = "7507";
        //GuadalupeCart guadalupeCart = new GuadalupeCart();
        //guadalupeCart.addCart(user,pass,id,sku,qnt);
        GuadalupeInfo guadalupeInfo = new GuadalupeInfo();
        guadalupeInfo.getInfo("http://guadalupestore.com.br/produto/zx-500-rm-son-goku/1146",
                user,pass,qnt);

        System.out.println("FINISH ");
    }
}
