## 介绍

使用Maven分模块开发，主要模块：

- pocket-shop-commons  工具
- pocket-shop-dependencies 依赖
- pocket-shop-domain  领域模型
- pocket-shop-external  外部文件
- pocket-shop-web-admin  后台
- pocket-shop-web-ui 门户
- pocket-shop-web-api  接口

共七个模块，可部署在多个服务器，使用HttpClient解决模块间的通信问题。

## 功能

后台主要实现了用户模块，内容模块，以及分类模块，前台对接实现登录功能，幻灯片，注册邮件发送等功能。

## 用到的技术

| 功能          | 技术                     |
| ------------- | ------------------------ |
| 前端          | AdminLTE                 |
| 后端          | Spring+SpringMVC+Mybatis |
| 数据库连接池D | Duid                     |
| 分页          | Jquery Tables            |
| 多选          | Jquery Icheck            |
| 前台验证      | Jquery Validation        |
| 后台验证      | Spring Validation        |
| 树形表格      | Jquery TreeTable         |
| 树形分类      | Jquery ZTree             |
| 图片上传      | Jquery DropZone          |
| 富文本编辑器  | WangEditor               |
| 模块通信      | HttpClient               |

## 前后台截图：

登录：

![image.png](http://img.ishangit.cn/images/2019/06/01/image.png)

首页：

![imagedd572276a7b0211e.png](http://img.ishangit.cn/images/2019/06/01/imagedd572276a7b0211e.png)

后台：

![imagee6e999e05f898958.png](http://img.ishangit.cn/images/2019/06/01/imagee6e999e05f898958.png)
