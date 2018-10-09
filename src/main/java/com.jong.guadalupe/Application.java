package com.jong.guadalupe;

import com.jong.guadalupe.crawler.GuadalupeCart;
import org.jsoup.nodes.Document;

import java.util.Base64;

public class Application {
    public static void main(String[] args) {
        GuadalupeCart guadalupeCart = new GuadalupeCart();
        String user = "jhl1254@gmail.com";
        byte[] decodedBytes = Base64.getDecoder().decode("am9uZzEyMzQ=");
        String decodedString = new String(decodedBytes);
        String pass = decodedString;
        String id = "1144";
        String sku = "7491";
        String qnt = "1";
        Document document = guadalupeCart.addCart(user,pass,id,sku,qnt);
        System.out.println(document.toString());
    }
}
