package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/4/28.
 */
public class SelfMenuInfoBean {

	/**
	 * is_menu_open : 1
	 * selfmenu_info : {"button":[{"name":"button","sub_button":{"list":[{"type":"news","name":"news","value":"KQb_w_Tiz-nSdVLoTV35Psmty8hGBulGhEdbb9SKs-o","news_info":{"list":[{"title":"MULTI_NEWS","author":"JIMZHENG","digest":"text","show_cover":0,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLvhTcm9sDA/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=1&sn=80ce6d9abcb832237bf86c87e50fda15#rd","source_url":""},{"title":"MULTI_NEWS1","author":"JIMZHENG","digest":"MULTI_NEWS1","show_cover":1,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKnmnpXYgWmQD5gXUrEApIYBCgvh2yHsu3ic3anDUGtUCHwjiaEC5bicd7A/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=2&sn=8226843afb14ecdecb08d9ce46bc1d37#rd","source_url":""}]}}]}}]}
	 */

	@JSONField( name = "is_menu_open" )
	private int isMenuOpen;

	@JSONField( name = "selfmenu_info" )
	private SelfmenuInfoBean selfmenuInfo;


	public int getIsMenuOpen() {
		return isMenuOpen;
	}


	public void setIsMenuOpen( int isMenuOpen ) {
		this.isMenuOpen = isMenuOpen;
	}


	public SelfmenuInfoBean getSelfmenuInfo() {
		return selfmenuInfo;
	}


	public void setSelfmenuInfo( SelfmenuInfoBean selfmenuInfo ) {
		this.selfmenuInfo = selfmenuInfo;
	}

	public static class SelfmenuInfoBean {

		/**
		 * name : button
		 * sub_button : {"list":[{"type":"news","name":"news","value":"KQb_w_Tiz-nSdVLoTV35Psmty8hGBulGhEdbb9SKs-o","news_info":{"list":[{"title":"MULTI_NEWS","author":"JIMZHENG","digest":"text","show_cover":0,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLvhTcm9sDA/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=1&sn=80ce6d9abcb832237bf86c87e50fda15#rd","source_url":""},{"title":"MULTI_NEWS1","author":"JIMZHENG","digest":"MULTI_NEWS1","show_cover":1,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKnmnpXYgWmQD5gXUrEApIYBCgvh2yHsu3ic3anDUGtUCHwjiaEC5bicd7A/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=2&sn=8226843afb14ecdecb08d9ce46bc1d37#rd","source_url":""}]}}]}
		 */

		@JSONField( name = "button" )
		private List<ButtonBean> button;


		public List<ButtonBean> getButton() {
			return button;
		}


		public void setButton( List<ButtonBean> button ) {
			this.button = button;
		}

		public static class ButtonBean {

			@JSONField( name = "name" )
			private String name;

			@JSONField( name = "type" )
			private String type;

			@JSONField( name = "value" )
			private String value;

			@JSONField( name = "url" )
			private String url;

			@JSONField( name = "news_info" )
			private NewsInfoBean newsInfoBean;

			@JSONField( name = "sub_button" )
			private SubButtonBean subButton;


			public String getName() {
				return name;
			}


			public void setName( String name ) {
				this.name = name;
			}


			public SubButtonBean getSubButton() {
				return subButton;
			}


			public void setSubButton( SubButtonBean subButton ) {
				this.subButton = subButton;
			}


			public String getValue() {
				return value;
			}


			public void setValue( String value ) {
				this.value = value;
			}


			public String getType() {
				return type;
			}


			public void setType( String type ) {
				this.type = type;
			}


			public String getUrl() {
				return url;
			}


			public void setUrl( String url ) {
				this.url = url;
			}


			public static class NewsInfoBean {

				/**
				 * title : MULTI_NEWS
				 * author : JIMZHENG
				 * digest : text
				 * show_cover : 0
				 * cover_url : http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLvhTcm9sDA/0
				 * content_url : http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=1&sn=80ce6d9abcb832237bf86c87e50fda15#rd
				 * source_url :
				 */

				@JSONField( name = "list" )
				private List<News> newsList;


				public List<News> getNewsList() {
					return newsList;
				}


				public void setNewsList( List<News> newsList ) {
					this.newsList = newsList;
				}

				public static class News {

					@JSONField( name = "title" )
					private String title;

					@JSONField( name = "author" )
					private String author;

					@JSONField( name = "digest" )
					private String digest;

					@JSONField( name = "show_cover" )
					private int showCover;

					@JSONField( name = "cover_url" )
					private String coverUrl;

					@JSONField( name = "content_url" )
					private String contentUrl;

					@JSONField( name = "source_url" )
					private String sourceUrl;


					public String getTitle() {
						return title;
					}


					public void setTitle( String title ) {
						this.title = title;
					}


					public String getAuthor() {
						return author;
					}


					public void setAuthor( String author ) {
						this.author = author;
					}


					public String getDigest() {
						return digest;
					}


					public void setDigest( String digest ) {
						this.digest = digest;
					}


					public int getShowCover() {
						return showCover;
					}


					public void setShowCover( int showCover ) {
						this.showCover = showCover;
					}


					public String getCoverUrl() {
						return coverUrl;
					}


					public void setCoverUrl( String coverUrl ) {
						this.coverUrl = coverUrl;
					}


					public String getContentUrl() {
						return contentUrl;
					}


					public void setContentUrl( String contentUrl ) {
						this.contentUrl = contentUrl;
					}


					public String getSourceUrl() {
						return sourceUrl;
					}


					public void setSourceUrl( String sourceUrl ) {
						this.sourceUrl = sourceUrl;
					}
				}
			}


			public static class SubButtonBean {

				/**
				 * type : news
				 * name : news
				 * value : KQb_w_Tiz-nSdVLoTV35Psmty8hGBulGhEdbb9SKs-o
				 * news_info : {"list":[{"title":"MULTI_NEWS","author":"JIMZHENG","digest":"text","show_cover":0,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLvhTcm9sDA/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=1&sn=80ce6d9abcb832237bf86c87e50fda15#rd","source_url":""},{"title":"MULTI_NEWS1","author":"JIMZHENG","digest":"MULTI_NEWS1","show_cover":1,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKnmnpXYgWmQD5gXUrEApIYBCgvh2yHsu3ic3anDUGtUCHwjiaEC5bicd7A/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=2&sn=8226843afb14ecdecb08d9ce46bc1d37#rd","source_url":""}]}
				 */

				@JSONField( name = "list" )
				private List<ButtonBean> list;


				public List<ButtonBean> getList() {
					return list;
				}


				public void setList( List<ButtonBean> list ) {
					this.list = list;
				}
			}
		}
	}
}
