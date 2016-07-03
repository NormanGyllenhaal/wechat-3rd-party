package site.lovecode.wechat.support.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/4/22.
 */
public class AutoReplyInfoBean {

	/**
	 * is_add_friend_reply_open : 1
	 * is_autoreply_open : 1
	 * add_friend_autoreply_info : {"type":"text","content":"Thanks for your attention!"}
	 * message_default_autoreply_info : {"type":"text","content":"Hello, this is autoreply!"}
	 * keyword_autoreply_info : {"list":[{"rule_name":"autoreply-news","create_time":1423028166,"reply_mode":"reply_all","keyword_list_info":[{"type":"text","match_mode":"contain","content":"news测试"}],"reply_list_info":[{"type":"news","news_info":{"list":[{"title":"it's news","author":"jim","digest":"it's digest","show_cover":1,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQH\n  euPKmFLK0ZQ/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=203929886&idx=1&sn=628f964cf0c6d84c026881b6959aea8b#rd","source_url":"http://www.url.com"}]}},{"type":"news","content":"KQb_w_Tiz-nSdVLoTV35Psmty8hGBulGhEdbb9SKs-o","news_info":{"list":[{"title":"MULTI_NEWS","author":"JIMZHENG","digest":"text","show_cover":0,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLv\nhTcm9sDA/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=1&sn=80ce6d9abcb832237bf86c87e50fda15#rd","source_url":""},{"title":"MULTI_NEWS4","author":"JIMZHENG","digest":"MULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULT","show_cover":1,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQ\nHeuPKmFLK0ZQ/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=5&sn=b4ef73a915e7c2265e437096582774af#rd","source_url":""}]}}]},{"rule_name":"autoreply-voice","create_time":1423027971,"reply_mode":"random_one","keyword_list_info":[{"type":"text","match_mode":"contain","content":"voice测试"}],"reply_list_info":[{"type":"voice","content":"NESsxgHEvAcg3egJTtYj4uG1PTL6iPhratdWKDLAXYErhN6oEEfMdVyblWtBY5vp"}]},{"rule_name":"autoreply-text","create_time":1423027926,"reply_mode":"random_one","keyword_list_info":[{"type":"text","match_mode":"contain","content":"text测试"}],"reply_list_info":[{"type":"text","content":"hello!text!"}]},{"rule_name":"autoreply-video","create_time":1423027801,"reply_mode":"random_one","keyword_list_info":[{"type":"text","match_mode":"equal","content":"video测试"}],"reply_list_info":[{"type":"video","content":"http://61.182.133.153/vweixinp.tc.qq.com/1007_114bcede9a2244eeb5ab7f76d951df5f.f10.mp4?vkey=7183E5C952B16C3AB1991BA8138673DE1037CB82A29801A504B64A77F691BF9DF7AD054A9B7FE683&sha=0&save=1"}]}]}
	 */

	@JSONField( name = "is_add_friend_reply_open" )
	private int isAddFriendReplyOpen;

	@JSONField( name = "is_autoreply_open" )
	private int isAutoreplyOpen;

	/**
	 * type : text
	 * content : Thanks for your attention!
	 */

	@JSONField( name = "add_friend_autoreply_info" )
	private AddFriendAutoreplyInfoBean addFriendAutoreplyInfo;

	/**
	 * type : text
	 * content : Hello, this is autoreply!
	 */

	@JSONField( name = "message_default_autoreply_info" )
	private MessageDefaultAutoreplyInfoBean messageDefaultAutoreplyInfo;

	@JSONField( name = "keyword_autoreply_info" )
	private KeywordAutoreplyInfoBean keywordAutoreplyInfo;


	public int getIsAddFriendReplyOpen() {
		return isAddFriendReplyOpen;
	}


	public void setIsAddFriendReplyOpen( int isAddFriendReplyOpen ) {
		this.isAddFriendReplyOpen = isAddFriendReplyOpen;
	}


	public int getIsAutoreplyOpen() {
		return isAutoreplyOpen;
	}


	public void setIsAutoreplyOpen( int isAutoreplyOpen ) {
		this.isAutoreplyOpen = isAutoreplyOpen;
	}


	public AddFriendAutoreplyInfoBean getAddFriendAutoreplyInfo() {
		return addFriendAutoreplyInfo;
	}


	public void setAddFriendAutoreplyInfo( AddFriendAutoreplyInfoBean addFriendAutoreplyInfo ) {
		this.addFriendAutoreplyInfo = addFriendAutoreplyInfo;
	}


	public MessageDefaultAutoreplyInfoBean getMessageDefaultAutoreplyInfo() {
		return messageDefaultAutoreplyInfo;
	}


	public void setMessageDefaultAutoreplyInfo( MessageDefaultAutoreplyInfoBean messageDefaultAutoreplyInfo ) {
		this.messageDefaultAutoreplyInfo = messageDefaultAutoreplyInfo;
	}


	public KeywordAutoreplyInfoBean getKeywordAutoreplyInfo() {
		return keywordAutoreplyInfo;
	}


	public void setKeywordAutoreplyInfo( KeywordAutoreplyInfoBean keywordAutoreplyInfo ) {
		this.keywordAutoreplyInfo = keywordAutoreplyInfo;
	}


	@Override
	public String toString() {
		return "AutoReplyInfoBean{"
				+ "isAddFriendReplyOpen=" + isAddFriendReplyOpen + ", isAutoreplyOpen=" + isAutoreplyOpen
				+ ", addFriendAutoreplyInfo=" + addFriendAutoreplyInfo + ", messageDefaultAutoreplyInfo="
				+ messageDefaultAutoreplyInfo + ", keywordAutoreplyInfo=" + keywordAutoreplyInfo + '}';
	}

	public static class AddFriendAutoreplyInfoBean {

		@JSONField( name = "type" )
		private String type;

		@JSONField( name = "content" )
		private String content;


		public String getType() {
			return type;
		}


		public void setType( String type ) {
			this.type = type;
		}


		public String getContent() {
			return content;
		}


		public void setContent( String content ) {
			this.content = content;
		}
	}

	public static class MessageDefaultAutoreplyInfoBean {

		@JSONField( name = "type" )
		private String type;

		@JSONField( name = "content" )
		private String content;


		public String getType() {
			return type;
		}


		public void setType( String type ) {
			this.type = type;
		}


		public String getContent() {
			return content;
		}


		public void setContent( String content ) {
			this.content = content;
		}
	}

	public static class KeywordAutoreplyInfoBean {

		/**
		 * rule_name : autoreply-news
		 * create_time : 1423028166
		 * reply_mode : reply_all
		 * keyword_list_info : [{"type":"text","match_mode":"contain","content":"news测试"}]
		 * reply_list_info : [{"type":"news","news_info":{"list":[{"title":"it's news","author":"jim","digest":"it's digest","show_cover":1,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQH\n  euPKmFLK0ZQ/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=203929886&idx=1&sn=628f964cf0c6d84c026881b6959aea8b#rd","source_url":"http://www.url.com"}]}},{"type":"news","content":"KQb_w_Tiz-nSdVLoTV35Psmty8hGBulGhEdbb9SKs-o","news_info":{"list":[{"title":"MULTI_NEWS","author":"JIMZHENG","digest":"text","show_cover":0,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLv\nhTcm9sDA/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=1&sn=80ce6d9abcb832237bf86c87e50fda15#rd","source_url":""},{"title":"MULTI_NEWS4","author":"JIMZHENG","digest":"MULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULT","show_cover":1,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQ\nHeuPKmFLK0ZQ/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=5&sn=b4ef73a915e7c2265e437096582774af#rd","source_url":""}]}}]
		 */

		@JSONField( name = "list" )
		private List<ListBean> list;


		public List<ListBean> getList() {
			return list;
		}


		public void setList( List<ListBean> list ) {
			this.list = list;
		}

		public static class ListBean {

			@JSONField( name = "rule_name" )
			private String ruleName;

			@JSONField( name = "create_time" )
			private Long createTime;

			@JSONField( name = "reply_mode" )
			private String replyMode;

			/**
			 * type : text
			 * match_mode : contain
			 * content : news测试
			 */

			@JSONField( name = "keyword_list_info" )
			private List<KeywordListInfoBean> keywordListInfo;

			/**
			 * type : news
			 * news_info : {"list":[{"title":"it's news","author":"jim","digest":"it's digest","show_cover":1,"cover_url":"http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQH\n  euPKmFLK0ZQ/0","content_url":"http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=203929886&idx=1&sn=628f964cf0c6d84c026881b6959aea8b#rd","source_url":"http://www.url.com"}]}
			 */

			@JSONField( name = "reply_list_info" )
			private List<ReplyListInfoBean> replyListInfo;


			public String getRuleName() {
				return ruleName;
			}


			public void setRuleName( String ruleName ) {
				this.ruleName = ruleName;
			}


			public Long getCreateTime() {
				return createTime;
			}


			public void setCreateTime( Long createTime ) {
				this.createTime = createTime;
			}


			public String getReplyMode() {
				return replyMode;
			}


			public void setReplyMode( String replyMode ) {
				this.replyMode = replyMode;
			}


			public List<KeywordListInfoBean> getKeywordListInfo() {
				return keywordListInfo;
			}


			public void setKeywordListInfo( List<KeywordListInfoBean> keywordListInfo ) {
				this.keywordListInfo = keywordListInfo;
			}


			public List<ReplyListInfoBean> getReplyListInfo() {
				return replyListInfo;
			}


			public void setReplyListInfo( List<ReplyListInfoBean> replyListInfo ) {
				this.replyListInfo = replyListInfo;
			}

			public static class KeywordListInfoBean {

				@JSONField( name = "type" )
				private String type;

				@JSONField( name = "match_mode" )
				private String matchMode;

				@JSONField( name = "content" )
				private String content;


				public String getType() {
					return type;
				}


				public void setType( String type ) {
					this.type = type;
				}


				public String getMatchMode() {
					return matchMode;
				}


				public void setMatchMode( String matchMode ) {
					this.matchMode = matchMode;
				}


				public String getContent() {
					return content;
				}


				public void setContent( String content ) {
					this.content = content;
				}
			}

			public static class ReplyListInfoBean {

				@JSONField( name = "type" )
				private String type;

				@JSONField( name = "news_info" )
				private NewsInfoBean newsInfo;

				private String content;


				public String getType() {
					return type;
				}


				public void setType( String type ) {
					this.type = type;
				}


				public NewsInfoBean getNewsInfo() {
					return newsInfo;
				}


				public void setNewsInfo( NewsInfoBean newsInfo ) {
					this.newsInfo = newsInfo;
				}


				public String getContent() {
					return content;
				}


				public void setContent( String content ) {
					this.content = content;
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

					@JSONField( name = "list" )
					private List<News> list;


					public List<News> getList() {
						return list;
					}


					public void setList( List<News> list ) {
						this.list = list;
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
			}
		}
	}
}
