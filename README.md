# springboot_idea_cloud
微服务标准范例（IDEA构建）

⭐项目结构：

---springboot_idea_cloud: 项目名

---eureka_server：服务注册与发现子模块()

---provider：服务提供子模块()

---consumer：服务消费子模块()

---zuul：服务消费子模块()

⭐基础配置+Eureka：

https://blog.csdn.net/weixin_44009447/article/details/108273295

1. 创建project-maven，项目名springboot_idea_cloud，删除src，只留.idea、pom、iml，pom建立子模块关联

2. 创建module-spring assistant，项目名eureka_server，java8，勾选Eureka Server，pom建立父模块关联

3. 创建module-spring assistant，项目名provider，java8，勾选Eureka Discovery Client，pom建立父模块关联

4. 创建module-spring assistant，项目名consumer，java8，勾选Eureka Discovery Client，pom建立父模块关联

5. eureka-server子模块加上@EnableEurekaServer注解，声明为注册中心

6. provider子模块加上@EnableEurekaClient注解，声明为注册服务

7. consumer子模块加上@EnableEurekaClient注解，声明为注册服务；

8. consumer子模块service类使用RestTemplate调用注册子模块接口方法

9. consumer子模块启动类加入@LoadBalanced

---------------------------------------

⭐Ribbon负载均衡和Hystrix熔断器：

https://blog.csdn.net/lhmyy521125/article/details/102657359

1. consumer子模块pom加上spring-cloud-starter-netflix-hystrix的起步依赖

2. consumer子模块启动类加入@EnableHystrix 开启熔断器

3. consumer子模块service类加入@HystrixCommand(fallbackMethod = "xxx" )注解，并创建xxx方法，编辑报错时返回的内容

---------------------------------------

⭐Zuul微服务网关

http://www.ityouknow.com/springcloud/2017/06/01/gateway-service-zuul.html

1. 创建module-spring assistant，项目名zuul，java8，勾选Eureka Discovery Client，pom建立父模块关联

2. zuul子模块pom添加zuul依赖，yml配置模块名、端口、eureka，无需特别配置zuul，zuul会自动发现注册在注册中心的所有服务

3. http://localhost:8899/service-provider/test/getName 进行访问

注意：

1. 微服务项目名不能有下划线，否则会无法发现服务

2. RestTemplate引用时需要加上@LoadBalanced注解，否则无法根据服务名找到服务

微服务pom管理规范

https://juejin.cn/post/7097221123040870407

maven常用标签

https://juejin.cn/post/7097633607946076197

maven操作时archetypeCatalog=internal报错，解决方法

Settings---Build---Maven---Runner----VM Options的设置改为

-DarchetypeCatalog=internal
