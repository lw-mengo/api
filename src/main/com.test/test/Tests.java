package test;

import com.google.gson.Gson;
import com.mengo.api.utils.GetDataFromNet;
import com.mengo.bean.DataBean;
import com.mengo.bean.VideoBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class Tests {
    private ApplicationContext context = null;

    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testDataSource(){
        DataSource dataSource = context.getBean(DataSource.class);
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGetData(){
        Gson gson  = new Gson();

        GetDataFromNet getDataFromNet = new GetDataFromNet();
       VideoBean videoBean = getDataFromNet.getInfo("/?m=vod-detail-id-6454.html");
//        String temp1 = gson.toJson(videoBean,VideoBean.class);
//        System.out.println(temp1);
//        DataBean dataBean = getDataFromNet.getData();
//        String temp = gson.toJson(dataBean,DataBean.class);
//        System.out.println(temp);
    }

}
