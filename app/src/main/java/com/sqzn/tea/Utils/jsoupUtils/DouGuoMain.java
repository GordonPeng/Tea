package com.sqzn.tea.Utils.jsoupUtils;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Create By Pengli
 * @On 2019/1/11 14:37
 * @org www.fictime.com  ( 湖北思勤智能装备有限公司)
 * @describe 类描述：豆果美食首页解析
 **/
public class DouGuoMain {

    //    public String url = "https://www.douguo.com/cookbook/2024088.html";
    public String url = "https://www.douguo.com";
    public Document doc;

    public DouGuoMain() {
        try {
            doc = Jsoup.connect(url).get();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 获得推荐食谱的id
     *
     * @return
     */
    public List<String> getcookbookId() {
        List<String> list = new ArrayList<>();
        // 获取id
        Elements select = doc.select("[class=recipe-list clearfix]");
        Elements item = select.select("[class=item]");
        Elements a = item.select("[class=cover br8]");
        for (int i = 0; i < a.size(); i++) {
            String href = a.get(i).attr("href");
            Log.d(">>>", href);
            String cookbookId = href.replaceAll("[^(0-9)]", "");
//        String cookbookId ="";
            Log.d(">>>", cookbookId + "  ");
            list.add(cookbookId);
        }

        return list;

    }

    /**
     * 获得推荐食谱的名称
     *
     * @return
     */
    public List<String> getcookbookTitle() {
        List<String> list = new ArrayList<>();
        // 获取id
        Elements select = doc.select("[class=recipe-list clearfix]");
        Elements item = select.select("[class=item]");
        Elements title = item.select("div>a[href]");
        for (int i = 0; i < title.size(); i++) {
            list.add(title.get(i).text());
        }
        return list;
    }

    /**
     * 获得推荐食谱的作者
     *
     * @return
     */
    public List<String> getcookbookAuthor() {
        List<String> list = new ArrayList<>();
        // 获取id
        Elements p = doc.select("[class=author text-lips]");
        Elements a = p.select("a[href^=/u/u]");

        for (int i = 0; i < a.size(); i++) {
                list.add(a.get(i).text());
        }
        return list;
    }

    /**
     * 获得推荐食谱的封面照片url
     *
     * @return
     */
    public List<String> getcookbookImgUrl() {
        List<String> list = new ArrayList<>();
        // 获取id
        Elements select = doc.select("[class=recipe-list clearfix]");
        Elements item = select.select("[class=item]");
        Elements a = item.select("[class=cover br8]").select("img");
        for (int i = 0; i < a.size(); i++) {
            String src = a.get(i).attr("src");
            Log.d(">>>",src);

            list.add(src);
        }
        return list;
    }



}
