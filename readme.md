## weixin-tool 微信第三方平台介绍
 微信第三方平台使用使用java8开发，使用了较多的java8的新特性，如lambda表达式和stream api，该项目使用了 [weixin-java-tools](https://github.com/chanjarster/weixin-java-tools)已经实现的功能，在其上又做了扩展，使其具备了微信第三方平台的功能，并增加数据持久化支持和简单的界面，使用它可以快速搭建一个微信的第三方平台,项目功能将不断增加完善，非常欢迎对本项目发起Pull Request
 ---
 * 已经使用的技术列表
    * java8
    * spring framework 4.2.5.RELEASE https://github.com/spring-projects/spring-framework
    * orm框架 mybatis 3.2.8 https://github.com/mybatis/mybatis-3
    * 模板引擎 velocity 
    * 数据库 mysql 5.6
    * 内存数据库 redis 3.2
    * json处理 fastjson https://github.com/alibaba/fastjson
    * 构建工具 gradle  https://github.com/gradle/gradle
    * 数据库连接池 druid 1.0.18  https://github.com/alibaba/druid
    * 微信sdk weixin-java-mp  https://github.com/chanjarster/weixin-java-tools
    * mybatis工具 mybatis-mapper  https://github.com/abel533/Mapper
    * web server jetty9
    * 开发工具 IntelliJ IDEA 15
    * 前端框架 Bootstrap angluarJS
    * 数据建模 powerdesgin
 * 项目结构
    db 数据字典和sql执行文件
 * 项目关键类说明
    - 微信所有接口都在site.lovecode.client包下
    * WechatClient 微信公众号接口
    * WechatThridPartyClient 微信第三方平台接口
    * WechatFactory 微信公众号工厂类
 * 项目实现的功能
    * 微信第三方平台授权绑定 手动绑定和授权绑定
    * 微信消息自动回复设置
    * 公众号数据统计
    * 自定义菜单管理
    * 素材管理
    * 用户管理
 * 项目部署说明
    * 首先执行db文件夹中的sql，创建数据库
    * 启动redis
    * 启动jetty，运行项目
   
    
 