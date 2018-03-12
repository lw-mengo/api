package com.mengo.api.utils;

import com.mengo.api.contansts.MyContansts;
import com.mengo.bean.DataBean;
import com.mengo.bean.VideoBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDataFromNet {


    public DataBean getData(int pageNo) {
        DataBean dataBean = new DataBean();
        List<DataBean.Info> dataBeans = new ArrayList<>();
        String url;
        if (pageNo == 1) {
            url = MyContansts.BASE_URL;
        } else {
            url = MyContansts.BASE_URL + "-pg-" + pageNo;
        }
        try {
            Document document = Jsoup.connect(url).timeout(6000).get();
            Elements elements = document.selectFirst("div.xing_vb").select("li").select("a");
            for (Element element : elements) {
                DataBean.Info info = new DataBean.Info();
                String title = element.text();
                String uri = element.attr("href");
                if (title.length() > 3) {
                    info.setTitle(title);
                    info.setUrl(uri);
                    dataBeans.add(info);
                }

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


    public VideoBean getInfo(String s) {
//        System.out.println(s);
        List<VideoBean.VideoEpisode> videoEpisodes = new ArrayList<>();
        VideoBean videoBean = new VideoBean();
        String url = MyContansts.BASE + s;
//        System.out.println(url);
            try {
                Document document = Jsoup.connect(url).timeout(6000).get();
                String title = document.selectFirst("div.vodh").select("h2").text();
                Elements elements = document.select("#2").select("li");
                for (Element element : elements) {
                    String temp = element.text();
//                    System.out.println(temp);
                    String[] ss = temp.split("\\$");
                    String episode = ss[0];
                    String videoUri = ss[1];
                    VideoBean.VideoEpisode videoEpisode = new VideoBean.VideoEpisode();
                    videoEpisode.setEpisode(episode);
                    videoEpisode.setVideoLink(videoUri);
                    videoEpisodes.add(videoEpisode);
//                    System.out.println(episode + "---->" + videoUri);
                }
                videoBean.setUrl(s);
                videoBean.setTitle(title);
                videoBean.setStatus("success");
                videoBean.setEpisodeList(videoEpisodes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return videoBean;
        }
}
