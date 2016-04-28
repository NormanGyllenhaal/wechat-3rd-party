package site.lovecode.support.bean.json;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/4/28.
 */
public class MenuBean {

    /**
     * type : click
     * name : 今日歌曲
     * key : V1001_TODAY_MUSIC
     */
    @JSONField(name = "button")
    private List<ButtonBean> button;

    public List<ButtonBean> getButton() {
        return button;
    }

    public void setButton(List<ButtonBean> button) {
        this.button = button;
    }


    public static class ButtonBean {

        @JSONField(name = "type")
        private String type;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "key")
        private String key;
        @JSONField(name="url")
        private String url;
        @JSONField(name="sub_button")
        private List<ButtonBean> subButton;
        @JSONField(name="news_info")
        private NewsInfoBean newsInfoBean;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public List<ButtonBean> getSubButton() {
            return subButton;
        }
        public void setSubButton(List<ButtonBean> subButton) {
            this.subButton = subButton;
        }


        public static class NewsInfoBean {
            /**
             * title : it's news
             * author : jim
             * digest : it's digest
             * show_cover : 1
             * cover_url : http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQH
             euPKmFLK0ZQ/0
             * content_url : http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=203929886&idx=1&sn=628f964cf0c6d84c026881b6959aea8b#rd
             * source_url : http://www.url.com
             */

            @JSONField(name = "list")
            private List<News> list;

            public List<News> getList() {
                return list;
            }

            public void setList(List<News> list) {
                this.list = list;
            }

            public static class News {
                @JSONField(name = "title")
                private String title;
                @JSONField(name = "author")
                private String author;
                @JSONField(name = "digest")
                private String digest;
                @JSONField(name = "show_cover")
                private int showCover;
                @JSONField(name = "cover_url")
                private String coverUrl;
                @JSONField(name = "content_url")
                private String contentUrl;
                @JSONField(name = "source_url")
                private String sourceUrl;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public String getDigest() {
                    return digest;
                }

                public void setDigest(String digest) {
                    this.digest = digest;
                }

                public int getShowCover() {
                    return showCover;
                }

                public void setShowCover(int showCover) {
                    this.showCover = showCover;
                }

                public String getCoverUrl() {
                    return coverUrl;
                }

                public void setCoverUrl(String coverUrl) {
                    this.coverUrl = coverUrl;
                }

                public String getContentUrl() {
                    return contentUrl;
                }

                public void setContentUrl(String contentUrl) {
                    this.contentUrl = contentUrl;
                }

                public String getSourceUrl() {
                    return sourceUrl;
                }

                public void setSourceUrl(String sourceUrl) {
                    this.sourceUrl = sourceUrl;
                }
            }
        }
    }


}
