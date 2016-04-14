/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/4/13 14:10:17                           */
/*==============================================================*/


drop index Index_authorizerAppid on WX_AUTHORIZER_INFO;

drop table if exists WX_AUTHORIZER_INFO;

drop table if exists WX_BUSINESS_INFO;

drop table if exists WX_COMPONENT_ACCESS_TOKEN;

drop table if exists WX_COMPONENT_VERIFY_TICKET;

drop table if exists WX_FUNC_INFO;

drop table if exists WX_PRE_AUTH_CODE;

drop index Index_authorizerAppid on WX_USER_ACCESS_TOKEN;

drop table if exists WX_USER_ACCESS_TOKEN;

drop table if exists WX_WECHAT_THIRD_PARTY_CONFIG;

/*==============================================================*/
/* Table: WX_AUTHORIZER_INFO                                    */
/*==============================================================*/
create table WX_AUTHORIZER_INFO
(
   id                   bigint not null comment '主键',
   authorizerAppid      varchar(50) not null default '' comment '授权方appid',
   nickName             varchar(50) not null default '' comment '授权方昵称',
   headImg              varchar(200) not null default '' comment '授权方头像',
   serviceTypeInfo      tinyint(4) not null comment '授权方公众号类型',
   verifyTypeInfo       tinyint(4) not null default 0 comment '授权方认证类型，-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证',
   userName             varchar(50) not null default '' comment '授权方公众号的原始ID',
   alias                varchar(50) not null default '' comment '授权方公众号所设置的微信号，可能为空',
   qrcodeUrl            varchar(200) not null default '' comment '二维码图片的URL，开发者最好自行也进行保存',
   createTime           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   authorizationStatus  tinyint(4) not null default 0 comment '授权状态,0为已授权,1为已取消授权',
   primary key (id)
);

alter table WX_AUTHORIZER_INFO comment '存储微信公众账号的基本信息';

/*==============================================================*/
/* Index: Index_authorizerAppid                                 */
/*==============================================================*/
create unique index Index_authorizerAppid on WX_AUTHORIZER_INFO
(
   authorizerAppid
);

/*==============================================================*/
/* Table: WX_BUSINESS_INFO                                      */
/*==============================================================*/
create table WX_BUSINESS_INFO
(
   id                   bigint not null comment '主键',
   authorizerInfoId     bigint not null comment '公众账号基本信息id',
   businessInfoName     tinyint(4) not null default 0 comment '商业功能名称',
   businessInfoStatus   tinyint(4) not null default 0 comment '商业功能开通状态',
   primary key (id)
);

alter table WX_BUSINESS_INFO comment '存储微信的商业功能开通情况';

/*==============================================================*/
/* Table: WX_COMPONENT_ACCESS_TOKEN                             */
/*==============================================================*/
create table WX_COMPONENT_ACCESS_TOKEN
(
   id                   bigint not null comment '主键',
   componentAppid       varchar(50) not null default '' comment 'componentAppid',
   componentAccessToken varchar(200) not null default '' comment '微信第三方component_access_token',
   expiresIn            int not null default 0 comment '有效时间',
   createTime           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   failureTime          timestamp not null default CURRENT_TIMESTAMP comment '失效时间',
   primary key (id)
);

alter table WX_COMPONENT_ACCESS_TOKEN comment '存储第三方平台的componentAccessToken';

/*==============================================================*/
/* Table: WX_COMPONENT_VERIFY_TICKET                            */
/*==============================================================*/
create table WX_COMPONENT_VERIFY_TICKET
(
   id                   bigint not null comment '主键',
   componentAppid       varchar(50) not null default '' comment '微信第三方componentAppid',
   componentVerifyTicket varchar(100) not null default '' comment '微信第三方component_verify_ticket',
   createTime           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   deadline             timestamp not null default CURRENT_TIMESTAMP comment '失效时间',
   primary key (id)
);

alter table WX_COMPONENT_VERIFY_TICKET comment '存储微信第三方平台component_verify_ticket信息';

/*==============================================================*/
/* Table: WX_FUNC_INFO                                          */
/*==============================================================*/
create table WX_FUNC_INFO
(
   id                   bigint not null comment 'zhujian',
   authorizerInfoId     bigint not null default 0 comment '微信授权方公众账号基本信息id,关联微信公众号基本信息表',
   funcName             int not null default 0 comment '权限的名称id',
   primary key (id)
);

alter table WX_FUNC_INFO comment '存储每个公众号的权限信息';

/*==============================================================*/
/* Table: WX_PRE_AUTH_CODE                                      */
/*==============================================================*/
create table WX_PRE_AUTH_CODE
(
   id                   bigint not null comment '主键',
   preAuthCode          varchar(100) not null default '' comment '微信预授权码',
   createTime           timestamp not null default CURRENT_TIMESTAMP,
   expiresIn            int default 0 comment '有效期',
   primary key (id)
);

alter table WX_PRE_AUTH_CODE comment '存储微信的预授权码';

/*==============================================================*/
/* Table: WX_USER_ACCESS_TOKEN                                  */
/*==============================================================*/
create table WX_USER_ACCESS_TOKEN
(
   id                   bigint not null comment '主键',
   authorizerInfoId     bigint not null comment '关联微信公众号基本信息id',
   authorizerAppid      varchar(50) not null default '' comment '授权方appid',
   authorizerAccessToken varchar(200) not null default '' comment '授权方令牌',
   expiresIn            int not null default 0 comment '有效期',
   authorizerRefreshToken varchar(200) not null default '' comment '接口调用凭据刷新令牌',
   createTime           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id)
);

alter table WX_USER_ACCESS_TOKEN comment '存储微信授权方的access_token和refresh_token';

/*==============================================================*/
/* Index: Index_authorizerAppid                                 */
/*==============================================================*/
create unique index Index_authorizerAppid on WX_USER_ACCESS_TOKEN
(
   authorizerAppid
);

/*==============================================================*/
/* Table: WX_WECHAT_THIRD_PARTY_CONFIG                          */
/*==============================================================*/
create table WX_WECHAT_THIRD_PARTY_CONFIG
(
   id                   bigint not null comment '主键',
   componentAppid       varchar(50) not null default '' comment '微信第三方component_appid',
   componentAppsecret   varchar(50) not null default '' comment '微信第三方component_appsecret',
   token                varchar(50) not null default '' comment '微信第三方token信息',
   encodeingAesKey      varchar(100) not null default '' comment '微信第三方加解密key',
   authorizationUrl     varchar(100) not null default '' comment '授权事件接收url',
   redirectUrl          varchar(100) not null default '' comment '授权事件跳转url',
   componentAccessToken varchar(200) not null default '' comment '第三方component_access_token',
   messgesUrl           varchar(100) not null default '' comment '公众号消息与事件接收URL',
   componentVerifyTicket varchar(200) not null default '' comment '微信第三方component_verfiy_ticket',
   createTime           timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   updateTime           timestamp not null default CURRENT_TIMESTAMP comment '更新时间',
   primary key (id)
);

alter table WX_WECHAT_THIRD_PARTY_CONFIG comment '存储微信第三方的配置信息';

