# SonarQube安装记录

## 0. SonarQube为什么装起来这么麻烦

1. 因为它由三个部分组成：![sonar](https://github.com/SimpleLonely/all_jedi_but_me/blob/master/docs/img/1557456468367.png)

2. 因为它放弃了对Mysql的支持，目前可用版本是5.6-5.7

   1. 在Mysql官网总是找不到正确的要下载的包

## 1. 安装服务端和数据库（windows+mysql)

   1. 主要过程参见：<https://juejin.im/post/5c3447dc51882525ec20070a>

   2. 但是如果你本机的Mysql是8.0的，就要参照 <https://blog.csdn.net/Ali_nie/article/details/84402406#commentBox> 这篇博文在3307端口开一个mysql5.7,**正确的应该下载的包是**<https://dev.mysql.com/downloads/mysql/5.7.html#downloads> 这一页的![mysql](https://github.com/SimpleLonely/all_jedi_but_me/blob/master/docs/img/1557456865610.png)
  的这俩之一。msi自测装不了，可能和已安装8.0有关。

   3. 补充：**安装mysql过程中要用管理员身份打开cmd.**

   4. 记得在sonar的conf/sonar.properties里把端口改成**3307**

## 2. 安装客户端

1. 在eclipse中安装SonarLint插件，eclipse->Help->Eclipse Marketplace搜索SonarLint 即可

2. 使用方法参见<https://segmentfault.com/a/1190000008459269>

         

