基于spring boot创建 eureka的注册中心

1.引入依赖包
<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>Edgware.RELEASE</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<version>RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-web</artifactId>
			<version>4.3.8.RELEASE</version>
		</dependency>

		<!-- eureka-->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka-server</artifactId>
			<version>1.2.6.RELEASE</version>
		</dependency>

	</dependencies>

2.用@EnableEurekaServer注解启动一个服务注册中心
    @EnableEurekaServer // eureka 启动一个服务注册中你提供给其他应用进行对话
    @SpringBootApplication
    public class SpringCloudDemoApplication {

        public static void main(String[] args) {
            SpringApplication.run(SpringCloudDemoApplication.class, args);
        }
    }

3.禁用客户端注册行为
    server.port=8000

    eureka.instance.hostname=localhost
    eureka.client.register-with-eureka=false
    eureka.client.fetch-registry=false
    eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/

    说明：
    eureka.client.register-with-eureka=false 不向注册中心注册自己
    eureka.client.fetch-registry 注册中心不需要去检索服务，所以设置为false

4.启动服务
    启动SpringCloudDemoApplication.java
    访问 http://localhost:8000/ 显示spring eureka 注册中心。