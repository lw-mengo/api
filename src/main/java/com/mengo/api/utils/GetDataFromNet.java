package com.mengo.api.utils;

import com.mengo.api.contansts.MyContansts;
import com.mengo.bean.DataBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDataFromNet {


    public DataBean getData() {
        DataBean dataBean =new DataBean();
        List<DataBean.Info> dataBeans = new ArrayList<>();
        try {
            Document document = Jsoup.connect(MyContansts.BASE_URL).timeout(6000).get();
            Elements elements = document.selectFirst("div.xing_vb").select("li").select("a");
            for (Element element : elements) {
                    DataBean.Info info = new DataBean.Info();
                    String title = element.text();
                    String url = element.attr("href");
                    info.setTitle(title);
                    info.setUrl(url);
                    dataBeans.add(info);
//                    System.out.println(title);
//                    System.out.println(url);
            }
            dataBean.setStatus("success");
            dataBean.setInfoList(dataBeans);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataBean;
    }
}
