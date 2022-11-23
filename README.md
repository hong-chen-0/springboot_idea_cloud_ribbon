# springboot_idea_cloud
微服务标准范例（IDEA构建）

参考教程

https://blog.csdn.net/weixin_44009447/article/details/108273295

springboot_idea_cloud: 项目名

eureka_server：服务注册与发现子模块

provider：服务提供子模块

consumer：服务消费子模块

注意：

1. 微服务项目名不能有下划线，否则会无法发现服务

2. RestTemplate引用时需要加上@LoadBalanced注解，否则无法根据服务名找到服务

微服务pom管理规范

https://juejin.cn/post/7097221123040870407

maven常用标签

https://juejin.cn/post/7097633607946076197
