# 5/8 线下赛前讲座笔记

## 代码质量与规范

### Sonarqube

用于代码质量管理，有 web 页面和 IDE 插件

检查重点：
- 不遵循代码标准
- 潜在的缺陷
- 重复
- 注释不足或过多

检查插件 PMD, CheckStyle, Findbugs

预赛允许不同的编辑器，提供测试用例（不可更改），给定固定的类和需求报告，按照测试用例的要求进行实现

语句/分支覆盖率：需求导向型编程，要求每个语句/分支都至少被使用一次（即无冗余语句）

安装 Mooctest 的 Eclipse 插件

## Android 开发基础

网络框架：
- OkHttp：网络请求
- Fresco：图片加载

手机端抓包：
- Charles（在线）
- Fiddler（在线）
- tcpdump + wireshark（离线）

技巧：
- 开发调试阶段使用 http，线上接口使用 https
- Android 7.X 以上 https 抓包需要 root

服务端技术：
后端服务器：Python + Tornado
数据库：MySQL + Redis

服务端接口测试
- Postman