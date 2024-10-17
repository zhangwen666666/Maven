![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710725958637-11b67a75-8e60-4ebb-bfc4-a2ac2a15076d.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=uf03e9ac5&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ub232915b-479f-417e-a15c-6fcabc35af1&title=&width=1400)
# 什么是Maven
## Maven的概念
Maven 是一个一键式的自动化构建工具。

Maven 是 Apache 软件基金会组织维护的一款自动化构建工具，**专注服务于 Java 平台的项目构建和依赖管理**。Maven 这个单词的本意是：专家，内行。

Maven 是目前最流行的自动化构建工具，对于生产环境下多框架、多模块整合开发有重要作用，Maven 是一款在大型项目开发过程中不可或缺的重要工具。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710725987781-ad1c5556-d664-4a3f-a987-e837d5d622df.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=dOTjk&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u9f025afb-8cd7-4304-8672-5b6e8749aa6&title=&width=1400)
## 为什么要使用Maven
我们知道，项目开发不仅仅是写写代码而已，期间会伴随着各种必不可少的事情要做，例如：

1. 我们需要引用各种 jar 包，尤其是比较大的工程，引用的 jar 包往往有几十个乃至上百个，每个都要到不同的官网去下载，而且每次用到的 jar 包，都需要手动引入工程目录，而且经常遇到各种让人抓狂的 jar 包冲突，版本冲突，**Maven可以自动下载jar包及依赖包添加到项目中**，大大减轻了工作负担。
2. 我们开发的 Java 文件，都是需要将它编译成二进制字节码文件。好在这项工作可以由各种集成开发工具帮我们完成，Eclipse、IDEA 等都可以将代码即时编译。但有时候我们需要**多个模块同时编译**，就必须要借助于Maven工具了。
3. 每个项目或模块开发过程中都会有 bug，因此写完了代码，我们还要写一些单元测试，然后一个个的运行来检验代码质量，**Maven提供了专门的测试插件来实施测试。**
4. 再优雅的代码也是要出来卖的。我们后面还需要**把代码与各种配置文件、资源整合到一起**，定型打包，如果是 web项目，还需要将之发布到服务器进行调用，这些都可以通过Maven轻松搞定。

总之，Maven是项目开发必须不可少的工具。

类似自动化构建工具还有：Gant,  Gradle。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710725991117-6f6efb29-596e-489b-942c-319c50b8c517.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u16326ffb&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u52cef47b-998d-47e0-92b8-0b44511900b&title=&width=1400)
## 项目构建过程
构建(build)是面向过程的(从开始到结尾的多个步骤)，涉及到多个环节的协同工作。
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710165876773-51d81f3a-ae16-4c71-ad03-2a128472fe5e.png#averageHue=%23c8ccbe&clientId=u2edacb95-b01a-4&from=paste&height=112&id=u84707db8&originHeight=120&originWidth=831&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=399725&status=done&style=none&taskId=u4e3a6e56-a9b4-4ad1-80fe-669ef75495c&title=&width=774)
构建过程的几个主要环节

1. 清理：删除以前的编译结果，为重新编译做好准备。
2. 编译：将Java源程序编译为字节码文件。
3. 测试：针对项目中的关键点进行测试，确保项目在迭代开发过程中关键点的正确性。
4. 报告：在每一次测试后以标准的格式记录和展示测试结果。
5. 打包：将一个包含诸多文件的工程封装为一个压缩文件用于安装或部署。Java 工程对应 jar 包，Web 工程对应war包。
6. 安装：在Maven环境下特指将jar包安装到本地仓库中。这样该项目就可以被其他的maven项目通过依赖的方式引入。
7. 部署：将jar包部署到私服上。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710725995072-f0e3a218-0532-4b4a-9389-08e8405ed4b4.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u661a4fd2&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=uba703b99-4b8b-4b15-a902-187fc3b62fe&title=&width=1400)
## Maven的两大核心功能（重点）
### 项目构建
对项目进行编译，测试，打包，部署等构建。
### 依赖管理
对jar包的统一管理，Maven提供中央仓库，私服，本地仓库解决jar包的依赖和相关依赖的下载。
如下图所示：包括蓝、黄两个部分分别对应着[**依赖关系**](https://www.zhihu.com/search?q=%E4%BE%9D%E8%B5%96%E5%85%B3%E7%B3%BB&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra=%7B%22sourceType%22%3A%22answer%22%2C%22sourceId%22%3A2811089619%7D)**和项目构建**两大核心功能。
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710167507407-a3db57eb-0be4-45df-b304-a170351d10b5.png#averageHue=%23f0e1ba&clientId=u2edacb95-b01a-4&from=paste&height=391&id=uef3966fd&originHeight=587&originWidth=1007&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=355052&status=done&style=none&taskId=uc21d13e0-70d1-4a82-a676-89305c8dc12&title=&width=671.3333333333334)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726002296-ca615277-385b-4037-a60d-289be4f5cf3e.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u9094f27f&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u3c1a6af9-a81d-482d-9238-3c5b14574d0&title=&width=1400)
# Maven的核心概念
## 什么是POM
POM(Project Object Model)项目对象模型，它是Maven的核心组件。它是Maven中的基本工作单元。它是一个xml文件，以pom.xml驻留在项目的根目录中。POM不仅包含有关项目的信息及Maven用于构建项目的各种配置的详细信息，还包含目标和插件。

pom.xml文件示例：
```xml
<!--添加父工程的引用-->
<parent>
  <groupId>com.bjpowernode.xiaomi</groupId>
  <artifactId>xiaomi-parent</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</parent>

<!--本项目的身份证号gav-->
<groupId>com.bjpowernode</groupId>
<artifactId>springmvc_006_ssm</artifactId>	  
<version>1.0.0</version>
<!--打包方式-->
<packaging>war</packaging>

<!--集中定义依赖版本号,使用属性-->
<properties>
  <!--mysql驱动的依赖-->
  <mysql.version>5.1.32</mysql.version>
</properties>

<!--添加依赖-->
<dependencies>
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>${mysql.version}</version>
  </dependency>	    
</dependencies>

<build>
  
  <!--聚合工程-->
  <modules>
    <module>xiaomi-manager-pojo</module>
    <module>xiaomi-manager-mapper</module>
    <module>xiaomi-manager-service</module>
    <module>xiaomi-manager-web</module>
  </modules>
  
  <!--插件配置-->
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <configuration>
        <source>17</source>
        <target>17</target>
        <encoding>UTF-8</encoding>
      </configuration>
    </plugin>
  </plugins>
  
  <!--指定配置文件识别路径-->
  <resources>
    <resource>
      <directory>src/main/java</directory>
      <includes>
        <include>**/*.properties</include>
        <include>**/*.xml</include>
      </includes>
    </resource>
    <resource>
      <directory>src/main/resources</directory>
      <includes>
        <include>**/*.properties</include>
        <include>**/*.xml</include>
      </includes>
    </resource>
  </resources>
</build>
```

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726007252-65fcbed3-f1f5-46e1-903f-88d180a5f3fa.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u73548aa3&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u936c3c44-7e05-4cff-a5b7-e88040ec00a&title=&width=1400)
## 什么是约定的目录结构
会有**预先约定好的目录结构，必须要遵循的规范，所有的Maven项目都依照这个规范**。主要的目的是将项目的源码文件，测试代码，资源文件完全分开，便于项目管理和扩展。

**放在resources目录下的文件就相当于放在了类的根路径下**

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710225813568-68f6bedb-6772-43b7-a474-7cff8fcd2c15.png#averageHue=%23faf9f9&clientId=u2edacb95-b01a-4&from=paste&height=496&id=u2fc4f7a9&originHeight=744&originWidth=1806&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=67081&status=done&style=none&taskId=u105d78b0-d8b9-4453-a5ab-5acfdf72d06&title=&width=1204)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726017457-ced53f44-89a4-4cc9-a2e5-cf0924842332.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u63a1a121&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u3980a5f1-5e30-4b11-ba33-6518d25d555&title=&width=1400)
## 什么是坐标GAV
也称为gav定位。使用三个标签来唯一定位jar资源。项目的唯一的名称，创建项目时定义gav名称，引用项目时使用gav名称。相当于项目的身份证号。坐标就是资源的唯一定位。创建项目时使用坐标拟定一个名称，访问资源时通过坐标找到资源

1. groupId:	组织名称,一般是公司域名的倒写  com.bjpowernode
2. artifactId:	项目名称   springmvc_006_ssm
3. version: 	版本编号 1.0-SNAPSHOT(开发时的临时版本号）  5.2.5.RELEASE（发布版本）

定义项目
```xml
<groupId>com.bjpowernode</groupId>
<artifactId>springmvc_006_ssm</artifactId>	  
<version>1.0.0</version>
```

引用项目
```xml
<dependency>
  <groupId>com.bjpowernode</groupId>
  <artifactId>springmvc_006_ssm</artifactId>	  
  <version>1.0.0</version>
</dependency>
```

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726023181-08c3d098-59ee-47dd-9043-7de64500d492.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=uf44d5ced&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ufae05d8f-d484-4096-8242-04d3324b970&title=&width=1400)
## 什么是仓库
存放jar包的位置 。**Maven中所有的jar包都在仓库中**。**仓库分为本地仓库和远程仓库。**

我们依赖的jar包它从哪儿获取呢？有同学说已经安装了，在它的安装包里啊，大家可以看一下maven下载下来才8M，我们需要的jar包有时候都几百兆甚至几个G，它从哪儿弄去呢？ 其实，maven有仓库的概念。在Maven中，任何一个依赖、插件或者项目构建的输出，都可以称之为构件。Maven 核心程序仅仅定义了自动化构建项目的生命周期，但具体的构建工作是由特定的构件完成的。而且为了提高构建的效率和构件复用，maven把所有的构件统一存储在某一个位置，这个位置就叫做仓库。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726026426-7124f4d1-eb3a-42b7-973e-fc8d2615ebf9.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u7a56683c&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ue6bffadd-427c-4f7f-a7d4-dac901dec96&title=&width=1400)
### 本地仓库
本地仓库，存在于当前电脑上，默认存放在~\.m2\repository中,为本机上所有的Maven工程服务。你也可以通过Maven的配置文件Maven_home/conf/settings.xml中修改本地仓库所在的目录。~ 是用户的主目录，windows系统中是 c:/user/登录系统的用户名

我课程里是存放在本机上的某个磁盘的位置(一定是没有中文的路径).    D:\repository

秘密:  gav就是仓库中一级一级的目录名称

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726030375-95a1c1ab-75e3-4fe3-aabf-48bbc42753b8.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=uab89dc5f&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u3d6be77e-e2cd-4c66-9caf-254d7962612&title=&width=1400)
### 远程仓库
远程仓库，分为为全世界范围内的开发人员提供服务的中央仓库、为全世界范围内某些特定的用户提供服务的中央仓库镜像、为本公司提供服务自己架设的私服。

中央仓库是maven默认的远程仓库，其地址是[:h](http://repo.maven.apache.org/maven2/)t[tp://repo.maven.apache.org/maven2/](http://repo.maven.apache.org/maven2/)，中央仓库包含了绝大多数流行的开源Java构件，以及源码、作者信息、许可证信息等。一般来说，简单的Java项目依赖的构件都可以在这里下载得到。

私服是一种特殊的远程仓库，它是架设在局域网内的仓库服务，私服代理广域网上的远程仓库，供局域网内的Maven用户使用。当Maven需要下载构件的时候，它从私服请求，如果私服上不存在该构件，则从外部的远程仓库下载，缓存在私服上之后，再为Maven的下载请求提供服务。我们还可以把一些无法从外部仓库下载到的构件上传到私服上。
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710230075376-f389cdfa-9d95-4cce-9771-e717cae4dd48.png#averageHue=%23fcfcf8&clientId=u2edacb95-b01a-4&from=paste&height=135&id=ud87b2d1b&originHeight=202&originWidth=949&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=768309&status=done&style=none&taskId=uea684a8d-8510-4571-a895-448d2954317&title=&width=632.6666666666666)

**程序员常用的一个仓库:**
[**http://mvnrepository.com/**](http://mvnrepository.com/)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710230122267-f7fc65cb-47fd-49e7-a5e4-dd78391a329a.png#averageHue=%23f8f7f7&clientId=u2edacb95-b01a-4&from=paste&height=649&id=u73398b2b&originHeight=974&originWidth=1852&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=323216&status=done&style=none&taskId=uf1df6884-54ab-4866-8d5a-bf25a13c375&title=&width=1234.6666666666667)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726037141-3564a72e-1cb2-4551-9aec-2b9d75bfc033.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u6850271f&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ub6bdfa1d-a713-4f37-bc59-766b479478a&title=&width=1400)
## 什么是依赖
一个Maven 项目正常运行需要其它项目的支持，Maven 会根据坐标自动到本地仓库中进行查找。对于程序员自己的 Maven 项目需要进行安装，才能保存到仓库中。不用maven 的时候所有的 jar 都不是你的，需要去各个地方下载拷贝，用了 maven 所有的 jar 包都是你的，想用谁，叫谁的名字就行。maven 帮你下载。

除了管理当前要使用的jar包，并且同时管理与其有依赖关系的jar包，自动去下载，并添加到当前的仓库，并给项目添加引用。是通过<dependencies>大标签中的子标签<dependency>，使用gav添加依赖。
```xml
<dependencies>
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.11</version>
  </dependency>
</dependencies>
```

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726050193-e8daaba3-d3e4-4448-9a8a-44935d9303a2.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u59e52db8&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u74162eee-7808-4f3c-90cf-d1adea7359e&title=&width=1400)
## 什么是生命周期
对项目的构建是建立在生命周期模型上的，它明确定义项目生命周期各个阶段，并且对于每一个阶段提供相对应的命令，对开发者而言仅仅需要掌握一小堆的命令就可以完成项目各个阶段的构建工作。

构建项目时按照生命周期顺序构建，每一个阶段都有特定的插件来完成。不论现在要执行生命周期中的哪个阶段，都是从这个生命周期的最初阶段开始的。

对于我们程序员而言，无论我们要进行哪个阶段的构建，直接执行相应的命令即可，无需担心它前边阶段是否构建，Maven 都会自动构建。这也就是 Maven 这种自动化构建工具给我们带来的好处。

使用idea后，生命周期要调用的命令被集成化一些按钮，只需要双击即可调用相应的插件来运行。
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710230536719-09afed3c-fe6b-4923-ba37-52686b407cc0.png#averageHue=%233a3f42&clientId=u2edacb95-b01a-4&from=paste&height=212&id=u4c24fe5b&originHeight=318&originWidth=591&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=753361&status=done&style=none&taskId=ucf96402c-8a54-4db4-ab62-d8dd3314460&title=&width=394)

生命周期对应的Maven命令(了解）：

1. mvn clean 清理(会删除原来编译和测试的目录，即 target 目录，但是已经 install 到仓库里的包不会删除) 
2. mvn compile  编译主程序(会在当前目录下生成一个 target,里边存放编译主程序之后生成的字节码文件)
3. mvn test-compile  编译测试程序(会在当前目录下生成一个 target,里边存放编译测试程序之后生成的字节码文件)
4. mvn test  测试(会生成一个目录surefire-reports，保存测试结果) 
5. mvn package  打包主程序(会编译、编译测试、测试、并且按照 pom.xml 配置把主程序打包生成 jar 包或者 war 包)
6. mvn install 安装主程序(会把本工程打包，并且按照本工程的坐标保存到本地仓库中)
7. mvn deploy 部署主程序(部署到私服仓库中）。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726054751-b244720d-187b-4a6c-81a5-aad097344b61.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u3015dd55&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u9691393a-f46c-45bc-8f77-a412c9f6a82&title=&width=1400)
## 什么是插件
Maven本质上是一个插件框架，它的核心并不执行任何具体的构建任务，所有这些任务都交给插件来完成，例如编译源代码是由maven- compiler-plugin完成的。进一步说，每个任务对应了一个插件目标（goal），每个插件会有一个或者多个目标，例如maven- compiler-plugin的compile目标用来编译位于src/main/java/目录下的主源码，testCompile目标用来编译位于src/test/java/目录下的测试源码。

Maven支持极简化的插件添加.使用<plugins>大标签中添加<plugin>子标签引用插件.
```xml
<plugins>
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
      <source>17</source>
      <target>17</target>
      <encoding>UTF-8</encoding>
    </configuration>
  </plugin>
</plugins>
```

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726058890-166f2f4c-8fa4-4903-a185-4c6066df1b93.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u84d021d1&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u5dea8f95-e5fa-4e36-b8ed-44ec6e8e5ff&title=&width=1400)
# Maven的应用
## 下载Maven
官网：[http://maven.apache.org/](http://maven.apache.org/)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710207605997-5488cc1d-1e4b-426d-94c5-be14f0499e2b.png#averageHue=%23f4f2f1&clientId=u2edacb95-b01a-4&from=paste&height=511&id=u1dedc3b9&originHeight=766&originWidth=1874&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=270109&status=done&style=shadow&taskId=udad52ba6-2e8f-482a-be86-ef58dc3182d&title=&width=1249.3333333333333)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710208724973-df375112-b2cc-4990-8ce7-4979212e72bb.png#averageHue=%23faf8f8&clientId=u2edacb95-b01a-4&from=paste&height=533&id=u5e5afe90&originHeight=799&originWidth=1873&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=252564&status=done&style=shadow&taskId=u902e6114-6e9c-4505-bf32-8bddeb05b7a&title=&width=1248.6666666666667)

我们使用的是最新apache-maven-3.9.6的版本，idea使用的是2023.1的版本。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726062820-a80ae67b-64b9-4caa-a374-75ba9f180f0b.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u51184fdc&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ube1675b7-fb09-432e-9f4b-5f14973c7cc&title=&width=1400)
## 配置Maven
要点：一定要将Maven工具解压到一个没有中文的路径下！
### 配置环境变量
必须要配置JAVA_HOME和MAVEN_HOME的环境变量。在Maven工具的bin目录下的mvn文件中多次使用这两个环境变量。

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710211770207-3a3021c2-6dfa-44ef-b9f5-ed4e92ce5104.png#averageHue=%23f9f6f5&clientId=u2edacb95-b01a-4&from=paste&height=359&id=uecb437db&originHeight=926&originWidth=1894&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=318022&status=done&style=none&taskId=u901b4c86-2443-402a-a636-fccda939ce2&title=&width=733.65625)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726068049-b6800ab9-a016-4cac-91e0-1eab8dda4758.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u5de58bf2&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=uecd56c95-b551-4ab7-9305-2e1c6b9394a&title=&width=1400)

配置步骤：

1. 我的电脑--->右键属性--->高级系统设置--->环境变量--->系统变量
2. 点新建--->
   1. 创建JAVA_HOME环境变量
      1. 变量名:  JAVA_HOME
      2. 变量值:  C:\Program Files\Java\jdk-17
   2. 创建MAVEN_HOME环境变量
      1. 变量名:  MAVEN_HOME
      2. 变量值:  D:\apache-maven-3.9.6  (Maven工具所在的目录，bin的上一级目录）    
3. 点path--->编辑--->新建
   1. %JAVA_HOME%\bin
   2. %MAVEN_HOME%\bin
   3. --->确定--->确定--->确定
4. 打开cmd窗口,输入  mvn -v

Apache Maven 3.9.6 (c9616018c7a021c1c39be70fb2843d6f5f9b8a1c)
Maven home: D:\apache-maven-3.9.6
Java version: 17.0.6, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-17
Default locale: zh_CN, platform encoding: GBK
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
有以上输出则表明配置环境变量成功。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726072718-dc24d395-b804-4629-9fea-441319466cd3.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=ue5c0d9ac&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u3ef4d1b1-ef7d-4e71-b224-2964d3e20bb&title=&width=1400)
### 配置Maven工具参数
打开D:\apache-maven-3.9.6\conf\settings.xml文件，进行本地仓库，远程仓库和JDK参数设置。

1. 配置本地仓库，将注释中53行的代码提取出注释，放置在第55行，设置本地仓库的地址路径。如果已有本地仓库则直接指定地址，如果没有本地仓库则指定一个目录，在idea配置后会自动生成目录。

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710222022190-7d23106a-01e4-4dc3-9c1f-558e4cb3fba8.png#averageHue=%23fdfbfa&clientId=u2edacb95-b01a-4&from=paste&height=501&id=u39b3489b&originHeight=751&originWidth=1859&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=237919&status=done&style=none&taskId=u9d8fc137-82eb-4e0c-86a8-6f338cef6cf&title=&width=1239.3333333333333)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726078941-7fbda798-46c0-4c51-8062-205db199eff3.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u575eaf0e&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u2f589e1b-888f-4f99-b1dd-e7f921fdbec&title=&width=1400)

2. 配置远程仓库

找到</mirrors>结束标签，将以下代码贴在其前面。
```xml
<!--配置阿里远程仓库-->
<mirror>
  <id>alimaven</id>
  <name>aliyun maven</name>
  <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
  <mirrorOf>central</mirrorOf>        
</mirror>
```

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710222406864-0ca53cb9-5b19-40ca-b5aa-6224835e99a7.png#averageHue=%23fdf9f8&clientId=u2edacb95-b01a-4&from=paste&height=467&id=iqsQ0&originHeight=701&originWidth=1859&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=202059&status=done&style=shadow&taskId=u1677f5db-35bf-4529-a85f-961167cc250&title=&width=1239.3333333333333)
远程仓库配置后，经常出现以下bug，连网去点try...就行，如果还是出现try...，就需要到本地仓库中，搜索last*，将出现的所有文件都删除后，再来点try...就行。
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710230234589-504260b6-d7ea-420a-ac3c-4a311f32fa1b.png#averageHue=%23302c2c&clientId=u2edacb95-b01a-4&from=paste&height=145&id=uc2963f98&originHeight=218&originWidth=830&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=725228&status=done&style=none&taskId=uabb3d539-ee09-44a1-abc0-2b6b2edc7eb&title=&width=553.3333333333334)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726084792-f31fe4db-54a6-4483-b284-bfa8dec98f5d.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u476afbaa&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=uade644f1-bef3-4d39-99a5-ec3144accb4&title=&width=1400)

3. 配置JDK属性

在<profiles>标签中进行配置，一定要小心，找到</profiles>结束标签，在其前面配置以下代码。因为在<profiles></profiles>标签中全部是注释，粘到哪里都在注释中，只有找到结束标签</profiles>前才是注释外的，配置才会生效。
```xml
<profile>
  <id>jdk17</id>
  <activation>
    <activeByDefault>true</activeByDefault>
    <jdk>17</jdk>
  </activation>
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <maven.compiler.compilerVersion>17</maven.compiler.compilerVersion>
  </properties>
</profile>
```

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726089085-ad574219-ca3c-4caa-9ad3-18258bc7cbd9.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u7ac59d87&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u322ee4ea-3c09-4ad3-8f8e-3893fe7766a&title=&width=1400)
### 为Idea2023当前打开的工作区集成maven
打开idea2023,具体步骤如下：

1. File--->settings--->Build,Execution,Depolyment--->Build Tools--->Maven

 Maven home path(Maven工具所在的目录,bin的上一级目录):   D:\apache-maven-3.9.6
勾选Override选项
User settings file(Maven工具的核心配置文件):  D:\apache-maven-3.9.2\conf\settings.xml
Local repository(本地仓库,antlr的上一级目录):  D:\repository

2. Maven--->Importing--->配置JDK的版本
3. Runner

VM Options:-DarchetypeCatalog=internal  (在新建模块时使用本地模板)
JRE: 17

4. Repositories(刷新本地仓库的索引):  选中本地仓库,点Update

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726092866-73df16d2-03bf-41f7-ad7a-86cfa00c1167.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u7a1dd665&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ucb57b601-89aa-4649-b300-1eef731ff39&title=&width=1400)
### 为Idea2023新建项目集成Maven

1. File--->New Projects Setup--->Settings for New Project
2. 同3.2.2的步骤再来一遍
## 基于Maven开发JavaSE的项目

1. File--->new--->Project--->Empty Project

Location:D:\course\10-Maven\code
Name:mavenall
--->Create

2. ctrl+alt+shift+s:打开项目结构窗口

Project:设置JDK版本为17

3. Modules:

+ ---> New Module 
Build system: Maven

4. Advanced Settings 

GroupId:com.bjpowernode
ArtifactId:maven_001_javase
--->Create

5. 观察Sources和Dependcies选项的JDK版本，都为17

--->ok

6. 补齐目录

在test目录上右键--->new Directory--->resouces

7. 修改pom.xml文件

添加单元测试的依赖
```xml
<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```
切记:点M刷新依赖 

8. 开发Hello.java类 
```java
public class Hello {
    //加法运算
    public int sum(int num1,int num2){
       return num1 + num2;
    }
    //乘法运算
    public int mul(int num1,int num2){
        return num1 * num2;
    }
}
```

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726102220-74404439-b124-4c22-a614-3e08384df78f.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=ua1f98768&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u442d91b7-a50a-42a0-af82-0dbe3c4ce55&title=&width=1400)

9. 开发测试类 
```java
public class MyTest {
    /**
     * 测试功能由测试方法来实现
     * 测试方法的规范
     * 1)访问权限是public
     * 2)方法没有返回值void
     * 3)方法名称自 定义,推荐以test开头
     * 4)方法没有参数
     * 5)使用@Test注解声明是测试方法
     */
    @Test
    public void testSum(){
        Hello  hello = new Hello();
        System.out.println(hello.sum(3,6));
    }
    @Test
    public void testMul(){
        Hello  hello = new Hello();
        System.out.println(hello.mul(3,6));
    }
}
```

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726107279-60d6713a-a461-4025-b9b1-04a72190036f.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u41c094bf&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u185866da-0481-4da8-9c99-4da4a54fdb1&title=&width=1400)
## 基于Maven开发JavaWeb的项目

1. 删除maven_001_javaSE.iml文件(如果此文件位于项目目录下，则必须删除，如果在本模块目录下，就不需要删除）
2. ctrl+alt+shift+s:打开结构窗口

Modules选项上---> + --->new Module 
Maven Archetype选项
Archetype: maven-archetype-webapp

3. Advanced Settings 选项卡

GroupId:	com.bjpowernode
ArtifactId:	maven_002_javaweb
Version:	1.0.0
--->Create

4. 观察Sources和Dependcies选项的JDK版本

--->ok

5. 修改目录

补齐缺失的所有目录
添加package: com.bjpowernode.controller

6. 修改pom.xml文件
   1. 删除远程访问的名称
```xml
<name>maven_002_javaweb Maven Webapp</name>
<url>http://maven.apache.org</url>
```

   2. 添加依赖
```xml
<!--添加Servlet的依赖-->
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>4.0.1</version>
</dependency>
```

   3. 删除项目构建名称
```xml
<build>
  <finalName>maven_002_javaweb</finalName>
</build>
```
    切记: 点M刷新按钮

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726112623-681671e8-9d28-4ae9-9aa7-f8ce0b270af8.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u3963e5c6&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=uc391fe25-98e3-4e3f-a51b-0b2d9cdb6aa&title=&width=1400)

7. 修改web.xml文件

ctrl+alt+shift+s:打开结构窗口
点web ---> - --->yes ---> Apply 

+ --->web.xml --->ok  --->ok

  ![image-20241012094213345](C:\Users\PC\AppData\Roaming\Typora\typora-user-images\image-20241012094213345.png)

8. 修改jsp页面

删除index.jsp页面
在webapp目录下新建index.jsp和main.jsp
开发index.jsp页面   <a href="/demo">访问服务器</a>

9. 开发Servlet     
```
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我来过.........");
        //跳 回 main.jsp
        request.getRequestDispatcher("/main.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

```

10. 添加tomcat测试运行

部署长名称的项目.

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726121320-c56e386c-488e-4e37-ae72-288ed0258d93.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=uaaad8a0a&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u8f6a4067-e8a0-42a7-ae2e-f43b7a2e664&title=&width=1400)
## 导入Maven的项目

1. 拷贝一个现有的Maven项目maven_002_javaweb,改名为 maven_002_javawebnew
2. 进入到maven_002_javawebnew项目中删除target目录和.gitignore文件
3. 打开pom.xml文件,更改artifactId的名称为maven_002_javawebnew.
4. ctrl+alt+shift+s:打开项目结构窗口

+ --->Import Moudle --->选中要导入的项目---> ok
选中  Import module from external model 
Maven
---> Create ---> ok

5. 部署运行测试功能 

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726124964-767841b0-1ac0-4955-9722-617004229996.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u722d1aa4&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=uca756447-3a1e-42a5-8500-4cc1bf50037&title=&width=1400)
# Maven的依赖管理
在JAVA开发中,项目的依赖管理是一项重要任务。通过合理管理项目的依赖关系，我们可以有效的管理第三方库，模块的引用及版本控制。而Maven作为一个强大的构建工具和依赖管理工具，为我们提供了便捷的方式来管理项目的依赖。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726129355-2eb182d3-0bdc-4cd9-ad1b-b534e96e5022.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u2cff6c70&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u4bf68fae-cbd6-489a-a6b1-3a123f335a6&title=&width=1400)
## 什么是依赖范围
Maven的依赖构件包含一个依赖范围的属性。这个属性描述的是三套classpath的控制，即编译、测试、运行。这说白了就是添加的jar包起作用的范围。  maven提供了以下几种依赖范围:compile,test,provided.runtime,system。
分别介绍如下：

1. compile

编译依赖范围，如果没有指定，**默认使用该依赖范围**，对于编译、测试、运行3种classpath都有效。
```xml
<dependencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.24</version>
    <scope>compile</scope>
  </dependency>
</dependencies>
```

2. test

**测试依赖范围**，使用此依赖范围的maven依赖，只对编译测试、运行测试的classpath有效，在编译主代码、运行项目时无法使用此类依赖。比如junit，它只有在编译测试代码及运行测试的时候才需要。

```xml
<dependencies>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726133829-f8291418-2baf-4c7f-b428-7c959ca92071.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=uf28f7676&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u469e4180-56d2-4066-8e17-9ff918cee7d&title=&width=1400)

3. provided

**已提供依赖范围**。表示项目的运行环境中已经提供了所需要的构件，对于此依赖范围的maven依赖，对于编译源码、编译测试、运行测试中classpath有效，但在运行时无效。比如上面说到的servlet-api，这个在编译和测试的时候需要用到，但是在运行的时候，web容器已经提供了，就不需要maven帮忙引入了。

```xml
<dependencies>
  <dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

4. runtime

**运行时依赖范围**，使用此依赖范围的maven依赖，对于测试和运行项目的classpath有效，但在编译时无效，比如jdbc驱动实现，项目代码编译的时候只需要提供JDK提供的JDBC接口，运行的时候才需要具体的jdbc驱动实现。

```xml
<dependencies>
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.32</version>
    <scope>runtime</scope>
  </dependency>
</dependencies>
```

5. system

**系统依赖范围**，该依赖与3中classpath的关系，和provided依赖范围完全一致。但是，使用system范围的依赖时必须通过systemPath元素显示第指定依赖文件的路径。这种依赖直接依赖于本地路径中的构件，可能每个开发者机器中构件的路径不一致，所以如果使用这种写法，你的机器中可能没有问题，别人的机器中就会有问题，所以建议谨慎使用。

```xml
<dependencies>
  <dependency>
    <groupId>com.bjpowernode</groupId>
    <artifactId>maven_001_javase</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>system</scope>
    <systemPath>D:/repository/com/bjpowernode/maven_001_javase/1.0-SNAPSHOT/maven_001_javase-1.0-SNAPSHOT.jar</systemPath>
  </dependency>
</dependencies>
```

总结如下图：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710426633024-11f9ac91-9875-43ef-959d-331e5205f7bf.png#averageHue=%23ddecc9&clientId=uf8dfabdd-913b-4&from=paste&height=224&id=uc599f887&originHeight=336&originWidth=1726&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=35504&status=done&style=none&taskId=u3acd4bdd-6563-481a-9985-9f7bbcbc19b&title=&width=1150.6666666666667)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726140665-c4bb2880-440f-4c98-a159-ef6939d6adb9.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=ua561d6df&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ufd902493-4acf-46db-a638-4992de2f52b&title=&width=1400)
## 什么是依赖传递
依赖具有传递性。 Maven 的依赖传递机制是指：不管 Maven 项目存在多少间接依赖，POM 中都只需要定义其直接依赖，不必定义任何间接依赖，这在一定程序上简化 了POM 的配置。  
假项目A依赖项目B，项目B依赖项目C，则A----->直接依赖B，B----->直接依赖C，A----->间接依赖C。
直接依赖和间接依赖是一个相对的概念。直接在项目中配置的依赖称为直接依赖，通过添加依赖关联进来的依赖称为间接依赖。1是项目的直接依赖，2是1的直接依赖，2是项目的间接依赖，以此类推。如图

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710728233920-00b543b8-d8af-4ba6-b69d-6a4904f6ad27.png#averageHue=%23fcf8f2&clientId=u79148803-46e9-4&from=paste&height=315&id=u15a4cdb7&originHeight=473&originWidth=950&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=112470&status=done&style=none&taskId=uc055825a-8f20-4bbf-880e-dbbb3cdc881&title=&width=633.3333333333334)![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726147057-6968da41-3864-4b53-969e-c4ff3bc83af7.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u72dffbd4&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u55ff2c8b-4f65-4d92-9803-59362caf6ed&title=&width=1400)
### 依赖范围对依赖传递的影响
B 是 A 的直接依赖，C 是 A 的间接依赖，根据 Maven 的依赖传递机制，间接依赖 C 会以传递性依赖的形式引入到 A 中，但这种引入并不是无条件的，它会受到依赖范围的影响。 
图示依赖传递关系:
![](https://cdn.nlark.com/yuque/0/2024/jpeg/21376908/1711074416600-67aa7a6a-5c6f-42f7-bed1-4a40f9a49bf7.jpeg)
规范化依赖传递的结果:
![image.png](https://cdn.nlark.com/yuque/0/2024/png/21376908/1711068902261-aac2a782-7ab4-4d0e-ac07-1e41d858df20.png#averageHue=%23d2e8c3&clientId=ub3ead04e-97ce-4&from=paste&height=289&id=uba9b2c63&originHeight=289&originWidth=1113&originalType=binary&ratio=1&rotation=0&showTitle=false&size=160801&status=done&style=none&taskId=u95686958-734a-4c4b-9f8b-84017faee34&title=&width=1113)
交叉部分的单元格的取值为传递性依赖的依赖范围，若交叉单元格取值为 “-”，则表示该传递性依赖不能被传递。  
通过上表，可以总结出以下规律：

1. 当间接依赖的范围是 compile 时，与直接依赖的范围一致；
2. 当间接依赖的范围是 test 或 provided时，传递性依赖不会被传递；
3. 当间接依赖的范围是 runtime 时，传递性依赖的范围与直接依赖的范围一致，但 compile 例外，此时传递性依赖的范围为 runtime。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726151630-053457ca-97b1-49c6-95cd-e0178889b19f.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u0f9ee06e&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ucf0d16ad-dd7c-44f4-9204-2a19bbe9f20&title=&width=1400)
## 依赖冲突
### 什么是依赖冲突
在 Maven 项目中，依赖通常被定义在项目的 pom.xml 文件中。当多个依赖项引入了不同版本的相同库时，就会发生依赖冲突。这可能是因为项目的直接依赖和间接依赖导致了同一库的多个版本存在于类路径中。每个显式声明的类包都会依赖于一些其它的隐式类包，这些隐式的类包会被maven间接引入进来，从而造成类包冲突。
### 依赖冲突的解决方案
Maven可以通过以下途径解决依赖冲突。
#### 版本锁定
在父工程中使用dependencyManagement 进行版本锁定，dependencyManagement可以统一管理整个项目的版本号，确保应用的各个项目的依赖和版本一致。 dependencyManagement只是声明依赖，并不自动实现引入，因此子项目需要显示的声明需要用的依赖，便可以忽略版本号。如果排斥父工程中定义的版本号，可以显示的进行版本号声明。 

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726158298-928235af-31a2-4ea2-ac4a-ff316086c546.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u78d01a34&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u28434974-1ff0-40b3-9436-ef85b9d3aad&title=&width=1400)

1. 子工程使用父工程锁定的版本号

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710472491980-a4cb3914-0f05-4e7e-947f-a4d23cf4132a.png#averageHue=%236d6b45&clientId=uf8dfabdd-913b-4&from=paste&height=510&id=u586a6155&originHeight=765&originWidth=1801&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=216895&status=done&style=none&taskId=u4e0260b6-6f2f-43fd-8b9e-7a4668c7155&title=&width=1200.6666666666667)

2. 子工程使用自定义的版本号，只要重新声明即可

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710472812417-b7aaabf0-6aed-422b-8af0-c34f9cc6eeaf.png#averageHue=%23616641&clientId=uf8dfabdd-913b-4&from=paste&height=484&id=u4cd8bbd0&originHeight=726&originWidth=1797&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=216624&status=done&style=none&taskId=ub65a5674-fdf4-4a39-85a1-0cb762f6a74&title=&width=1198)

3. 父工程不使用<dependencyManagement>标签，则子工程跟父工程完全保持一致。子工程不需要显示依赖任何jar包。(**这种情况子工程会将父工程中所有的依赖都继承下来，有可能子工程并不需要这么多依赖，因此这种方式会导致子工程臃肿，一般采用<dependencyManagement>标签**)

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710477128261-8cf15234-7b59-49ce-8b7b-ad886d26c96f.png#averageHue=%23595a40&clientId=u025dd473-afbf-4&from=paste&height=567&id=u21f3da53&originHeight=851&originWidth=1793&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=221919&status=done&style=none&taskId=u36730a68-5767-49e4-a519-8e06e99f79f&title=&width=1195.3333333333333)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726162625-cc6a0908-4861-4713-9581-6704bc557c5e.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=ude1c4ae3&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ub9907bfa-c6ae-4c92-bdbd-a3945acb523&title=&width=1400)
#### 短路径优先
 引入路径短者优先，顾名思义，当一个间接依赖存在多条引入路径时，引入路径短的会被解析使用。如图  
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710728799160-11ddc3d2-3034-4017-b98e-2413564afc3e.png#averageHue=%23fbfbf7&clientId=u79148803-46e9-4&from=paste&height=269&id=uf0e22108&originHeight=404&originWidth=1092&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=50378&status=done&style=none&taskId=udc01de3c-4476-4c5c-a9b1-eb7f676fedf&title=&width=728)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710479263151-463ae45f-d9d0-4dd9-a628-8876b5c9283a.png#averageHue=%236d845e&clientId=u025dd473-afbf-4&from=paste&height=553&id=u4571d8e5&originHeight=830&originWidth=1787&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=158021&status=done&style=none&taskId=u18285b54-012e-49f6-8c48-10b933f1798&title=&width=1191.3333333333333)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726166796-cbdbfffe-56af-432b-8606-fd9951d18b78.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u24b0acca&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u404a1aa2-a2e0-4c4b-8601-491ad00934d&title=&width=1400)
#### 声明优先
如果存在短路径，则优先选择短路径，如果路径相同的情况下，先声明者优先，POM 文件中依赖声明的顺序决定了间接依赖会不会被解析使用，顺序靠前的优先使用。如图。 
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710729281326-826998e7-b535-41de-855e-8a1e8c9f30ed.png#averageHue=%23fbfbf9&clientId=u79148803-46e9-4&from=paste&height=307&id=ua5ddbbb3&originHeight=460&originWidth=1079&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=53195&status=done&style=none&taskId=u8c48804b-461e-43ad-ba01-a8a2d45b880&title=&width=719.3333333333334)
 代码示例：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710482843035-b311f9f4-b84f-4bed-b1c3-1b32e5f60284.png#averageHue=%2364885f&clientId=u025dd473-afbf-4&from=paste&height=548&id=u1adb2ae8&originHeight=897&originWidth=1853&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=222712&status=done&style=none&taskId=u0bd7bc44-2cd5-464a-95f9-8d5ebb3c773&title=&width=1131.328125)
注意去掉<scope>标签，否则会因为依赖范围的影响导致效果无法显示。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726170611-4e7a6e5b-8bc3-4b31-b0dc-58bed442b923.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=ubdb0940b&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u515b9713-2f1a-4556-bcc8-a844681966a&title=&width=1400)
#### 特殊优先（后来者居上）
同一个pom.xml文件中进行了多次依赖jar包不同版本的配置，后面的覆盖前面的配置。这种情况比较少见。
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710483308764-afdb1d47-5ec9-441b-8415-8fe486434e56.png#averageHue=%2367815c&clientId=u025dd473-afbf-4&from=paste&height=529&id=ud67ea724&originHeight=794&originWidth=1822&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=184278&status=done&style=none&taskId=u385f954c-9b5d-4e4b-99bf-fb70e24b5d2&title=&width=1214.6666666666667)
#### 可选依赖
maven_03项目可选择是否传递间接依赖junit_4.13，主动权在当前项目maven_03中。如果当前项目被依赖到其它项目中，当前项目可以拒绝交出间接依赖项。例如maven_02添加了maven_03的依赖，maven_03可以自主设置其依赖项junit_4.13是否被间接传递。<optional>true</optional> 为不传递间接依赖，那么在maven_02项目中就没有junit_4.13的依赖。默认是false，是传递间接依赖。
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710730202393-a9a5d910-a341-4f7a-8156-04ed947a1561.png#averageHue=%23f9f3e1&clientId=u79148803-46e9-4&from=paste&height=439&id=u8518855a&originHeight=659&originWidth=1074&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=59524&status=done&style=none&taskId=u24b7beaa-124e-415c-b1b3-dc0692b25cd&title=&width=716)
代码示例：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710490003130-4d3bf144-25b8-43af-afe1-ce94b0a8fede.png#averageHue=%234a574b&clientId=u025dd473-afbf-4&from=paste&height=573&id=Uba5X&originHeight=860&originWidth=1853&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=209465&status=done&style=none&taskId=ue9a55df1-cbb4-4e78-a23e-509e29919a3&title=&width=1235.3333333333333)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726175065-90318db8-ee20-4a23-8c0e-3bd0b1687bd6.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u4b6a0752&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ua178c5c5-d002-4543-84b4-1747244f84b&title=&width=1400)
#### 排除依赖
是当前项目是否主动断开其依赖项目的间接依赖。也就是控制当前项目是否使用其直接依赖传递下来的接间依赖。在maven_02项目中添加maven_03项目的依赖，但不要maven_03项目中的junit_4.13的依赖，可以选择排除依赖。这样可以保证当前项目依赖的纯净性。
排除依赖使用 exclusions 元素排除依赖，说明如下：

1. exclusions 元素下可以包含若干个 exclusion 子元素，用于排除若干个间接依赖，该元素包含两个子元素：groupId 和 artifactId，用来确定需要排除的间接依赖的坐标信息
2. exclusion 元素中只需要设置 groupId 和 artifactId 就可以确定需要排除的依赖，无需指定版本version

      如图
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710730881718-cb19d958-ec83-4438-9103-7ed17ce68fc3.png#averageHue=%23e5f3cc&clientId=u79148803-46e9-4&from=paste&height=448&id=u4b90e72e&originHeight=672&originWidth=1102&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=65464&status=done&style=none&taskId=ua8e89451-26d7-47b2-a086-7fbe89388a3&title=&width=734.6666666666666)

代码示例：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710493895419-a8364fcc-5682-419d-b289-7af55e21ea03.png#averageHue=%233d4244&clientId=u025dd473-afbf-4&from=paste&height=581&id=ub2b2b8f3&originHeight=872&originWidth=1849&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=199769&status=done&style=none&taskId=uc3b718ce-4441-401c-b604-99209dd2634&title=&width=1232.6666666666667)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726179002-ed63d6ee-ea8e-4581-bb30-c9fb2f24870f.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u056791c2&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u7c5fbb64-06c9-438f-bf26-4e3a667ca46&title=&width=1400)
#### 可选依赖和排除依赖的区别
排除依赖和可选依赖都能在项目中将间接依赖排除在外，但两者实现机制却完全不一样。

1. 可选依赖是自己决定是否向外提供间接依赖（maven_03设置拒绝提供间接依赖junit）
2. 排除依赖是主动拒绝添加直接依赖关联的间接依赖（maven_02项目设置排除maven_03的junit依赖）
3. 可选依赖的优先级高于排除依赖
4. 若对于同一个间接依赖同时使用排除依赖和可选依赖进行设置，那么可选依赖的取值必须为 false，否则排除依赖无法生效。

如果用一个生活中的例子可能更易懂一些。
国民党（maven_02)抓住了共产党人（依赖了maven_03）,要求供出联系人名单（maven_03中依赖的junit_4.13)，最终结果是没有得到联系人名单（不依赖jjunit_4.13)。
可选依赖：是maven_03共产党人死活不说联系人的名单junit_4.13（可选，我选择不说）。
排除依赖：是maven_02国民党不要共产党人提供的联系人名单（排除，我就是不要你的名单,  估计你是乱说的）。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726184332-9f8950f4-bc9b-44ce-88ac-20ecadfb499c.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=ube884ce6&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=uc70cf3fa-5ebb-4fc8-9cc7-5626aa98bee&title=&width=1400)
## 刷新依赖的8种方式
在idea中有时候会出现刷新延时的情况，那么需要进行手工刷新依赖。

1. 点击M刷新按钮。
2. 点Maven窗口的Reload All Maven Projects。
3. Build--->ReBuild Project 重新构建项目的同时刷新所有依赖。
4. 点击本项目的pom.xml文件--->右键--->Maven--->Reload Project 刷新本项目的依赖。
5. 打开pom.xml文件,全选,拷贝,删除,关闭,打开,粘贴.物理刷新pom.xml文件 。
6. Invalidate Caches--->全选--->Invalidate and Restart 清空idea的缓存并重启idea刷新依赖。
7. **打开本地仓库，搜索last，全选删除,点Maven的刷新全部依赖的按钮。**
8. **在7的步骤后执行File--->settings--->Build,Execution,Deployment--->Build Tools--->Maven--->Repositories--->选中本地仓库--->update--->ok。**
##  资源文件的指定
src/main/java 和 src/test/java 这两个目录中的所有*.java 文件会分别在 comile 和 test-comiple 阶段被编译，编译结果分别放到了 target/classes 和 targe/test-classes 目录中，但是这两个目录中的其他文件(后缀是.properties或.xml等文件)都会被忽略掉(编译后丢失)，如果需要把 src 目录下的除.java之外的文件包放到 target/classes 目录，作为输出的 jar 一部分。需要指定资源文件位置。以下内容放到<build>标签中。简单来说就是在resources目录下的*.properties文件和*.xml文件编译时不丢失,但resources目录外的*.properties文件和*.xml文件会丢失,所以要指定位置,保证编译后文件都在.
代码示例:
![image.png](https://cdn.nlark.com/yuque/0/2024/png/21376908/1710992850165-0a554516-fc4f-4904-90bb-1111061d530a.png#averageHue=%237b977c&clientId=uf81e72cb-f421-4&from=paste&height=671&id=u9b00b7e9&originHeight=671&originWidth=1673&originalType=binary&ratio=1&rotation=0&showTitle=false&size=128778&status=done&style=none&taskId=u58c5828a-46a0-4fc9-b7ac-dcb79e1f0ed&title=&width=1673)
添加指定后:
![image.png](https://cdn.nlark.com/yuque/0/2024/png/21376908/1710993017431-84d8491f-5bdd-4f9f-892c-3fba02c8dfc8.png#averageHue=%23bbc334&clientId=uf81e72cb-f421-4&from=paste&height=903&id=u3fd4eaa3&originHeight=903&originWidth=1506&originalType=binary&ratio=1&rotation=0&showTitle=false&size=177535&status=done&style=none&taskId=u40c894b5-a939-4007-b720-a51cab27fca&title=&width=1506)
指定代码:
```xml
<build>
        <resources>
            <resource>
                <!--指定java目录下的所有路径下的所有文件-->
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.properties</include>
                </includes>
            </resource>
            <resource>
                <!--指定resources目录下的所有路径下的所有文件-->
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.properties</include>
                </includes>
            </resource>
        </resources>
    </build>
```
一般情况下,会两个目录都指定.

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726188659-5dd227f8-a6ca-4ccd-8c0e-a1667ee26861.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u9c35523c&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=udd0a371e-ea3e-4b89-a688-36b9435bc5b&title=&width=1400)
# Maven的继承和聚合
## 什么是继承
Maven 的依赖传递机制可以一定程度上简化 POM 的配置，但这仅限于存在依赖关系的项目或模块中。当一个项目的多个模块都依赖于相同 jar 包的相同版本，且这些模块之间不存在依赖关系，这就导致同一个依赖需要在多个模块中重复声明，这显然是不可取的，大量的前人经验告诉我们，**重复往往意味着更多的劳动和更高的潜在风险**。

![](https://cdn.nlark.com/yuque/0/2024/jpeg/21376908/1711167422290-65970d94-bdc7-4f20-a0d9-288fd247daa9.jpeg)

在 Java 面向对象中，我们可以建立一种类的父子结构，然后在父类中声明一些字段和方法供子类继承，这样就可以一定程度上消除重复，做到 “一处声明，多处使用”。在 Maven 的世界中，也有类似的机制，它就是 POM 继承。

Maven 在设计时，借鉴了 Java 面向对象中的继承思想，提出了 POM 继承思想。当一个项目包含多个模块时，可以在该项目中再创建一个父模块，并在其 POM 中声明依赖，其他模块的 POM 可通过继承父模块的 POM 来获得对相关依赖的声明。
对于父模块而言，其目的是为了消除子模块 POM 中的重复配置，其中不包含有任何实际代码，因此父模块 POM 的打包类型（packaging）必须是 pom。
如图所示:
![image.png](https://cdn.nlark.com/yuque/0/2024/png/21376908/1711168327611-f6e0f1ca-02ff-47d3-a093-7e9863e3d716.png#averageHue=%23f2ead9&clientId=u9a461781-37a9-4&from=paste&height=630&id=uf5bcaaf1&originHeight=630&originWidth=1195&originalType=binary&ratio=1&rotation=0&showTitle=false&size=88175&status=done&style=none&taskId=u49cd9269-d205-407a-b028-1cdebbded86&title=&width=1195)
子工程可以继承的父工程的元素：

| **元素** | **描述** |
| --- | --- |
| groupId | 项目组 ID，项目坐标的核心元素 |
| version | 项目版本，项目坐标的核心元素 |
| description | 项目的描述信息 |
| organization | 项目的组织信息 |
| inceptionYear | 项目的创始年份 |
| url | 项目的 URL 地址 |
| developers | 项目的开发者信息 |
| contributors | 项目的贡献者信息 |
| distributionManagement | 项目的部署配置 |
| issueManagement | 项目的缺陷跟踪系统信息 |
| ciManagement | 项目的持续集成系统信息 |
| scm | 项目的版本控制系统信息 |
| mailingLists | 项目的邮件列表信息 |
| properties | 自定义的 Maven 属性 |
| dependencies | 项目的依赖配置 |
| dependencyManagement | 项目的依赖管理配置 |
| repositories | 项目的仓库配置 |
| build | 包括项目的源码目录配置、输出目录配置、插件配置、插件管理配置等 |
| reporting | 包括项目的报告输出目录配置、报告插件配置等 |


![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726198954-0e269d8f-bf17-442e-ac26-a46978dd2cd6.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u59ba7ddc&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ucc198690-89ff-44d0-a646-f809e0d218b&title=&width=1400)

父工程示例：
```xml
<modelVersion>4.0.0</modelVersion>
<groupId>com.bjpowernode</groupId>
<artifactId>maven_parent</artifactId>
<version>1.0-SNAPSHOT</version>
<!--打包方式必须是pom,声明是父工程-->
<packaging>pom</packaging>

<!--聚合子模块-->
<modules>
  <module>maven_son</module>
  <module>maven_web</module>
</modules>

<properties>
  <!--定义属性，便于版本的管理-->
  <spring-version>5.3.24</spring-version>
  <servlet-version>4.0.1</servlet-version>
</properties>

<!--只是定义，并没有真正的添加依赖，子工程根据需要有选择的添加依赖-->
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <!--引用定义好的属性-->
      <version>${spring-version}</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>${servlet-version}</version>
      <scope>provided</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<build>
  <pluginManagement>
    <plugins>
      <!--只定义Tomcat插件 -->
      <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
        <configuration>
          <port>8089</port>
          <url>/</url>
        </configuration>
      </plugin>
    </plugins>
  </pluginManagement>
</build>
```

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726203316-d075d1bc-5cd5-4b43-8e61-1e270be1e2fa.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=ubaf501fe&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u5b508af7-ce6c-4e1b-85bf-b834c3ff72c&title=&width=1400)

子工程示例：
```xml
<modelVersion>4.0.0</modelVersion>
<parent>
  <groupId>com.bjpowernode</groupId>
  <artifactId>maven_parent</artifactId>
  <version>1.0-SNAPSHOT</version>
</parent>
<!--可以省略groupId和version，因为与父工程保持一致-->
<artifactId>maven_web</artifactId>
<packaging>war</packaging>

<!--需要什么依赖，添加什么依赖，可以省略版本号，版本由父工程统一管理 -->
<dependencies>
  <dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  </dependency>
  <dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  </dependency>
</dependencies>

<build>
  <plugins>
    <!--配置Tomcat插件 -->
    <plugin>
      <groupId>org.apache.tomcat.maven</groupId>
      <artifactId>tomcat7-maven-plugin</artifactId>
      <version>2.2</version>
      <!--子工程可以自定义端口号，不自定义使用父工程的-->
      <configuration>
        <port>8060</port>
        <url>/</url>
      </configuration>
    </plugin>
  </plugins>
</build>
```

总结：一句话，通过继承可以实现子工程沿用父工程的配置。大大减少重复设置。 

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726207891-29d97bae-1ef4-4be3-8399-9b2090620793.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u17c0f677&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ud7864f26-1acc-4112-8538-90131d40b3a&title=&width=1400)
## 什么是聚合
使用 Maven 聚合功能对项目进行构建时，需要在该项目中额外创建一个的聚合模块，然后通过这个模块构建整个项目的所有模块。聚合模块仅仅是帮助聚合其他模块的工具，其本身并无任何实质内容，因此聚合模块中只有一个 POM 文件，不包含 src 等目录。

与父模块相似，聚合模块的打包方式（packaging）也是 pom，用户可以在其 POM 中通过 modules 下的 module 子元素来添加需要聚合的模块的目录路径。父模块的 pom.xml 文件的 <modules> 把子模块聚集起来. 

项目结构：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710519085353-11678e58-1ffe-44da-9273-3cc1155c6641.png#averageHue=%23738b62&clientId=u025dd473-afbf-4&from=paste&height=507&id=u20dbc733&originHeight=760&originWidth=1830&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=210256&status=done&style=none&taskId=u885d2d10-90be-4ff1-83d2-afbc1d60e7b&title=&width=1220)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726300911-fadafc2a-8ddd-49e8-9b4d-1af6a3e3a148.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u16e988df&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ud9aa734f-76c2-4f19-ace4-a07fa3514a1&title=&width=1400)

代码示例：
```xml
<modelVersion>4.0.0</modelVersion>

<groupId>com.bjpowernode</groupId>
<artifactId>maven_ju</artifactId>
<version>1.0-SNAPSHOT</version>
<packaging>pom</packaging>

<modules>
  <module>../maven_02</module>
  <module>../maven_03</module>
  <module>../maven_01</module>
  <module>../maven_parent</module>
</modules>
```

代码结构：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710519366819-5cd7d949-baf7-43bb-b7ae-e1c8384d1e58.png#averageHue=%234a6248&clientId=u025dd473-afbf-4&from=paste&height=530&id=u7fcceff2&originHeight=795&originWidth=1772&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=199207&status=done&style=none&taskId=u4baccee2-a70a-4726-9a28-b7362766cc1&title=&width=1181.3333333333333)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726305308-feae7c1d-f4ff-415d-a098-109efc582f0a.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=uf8322a45&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u42bf2301-3820-45e7-9b83-322fdc848bc&title=&width=1400)

运行结果示例：
```
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO] 
[INFO] maven_03                                                           [jar]
[INFO] maven_02                                                           [jar]
[INFO] maven_01                                                           [jar]
[INFO] maven_parent                                                       [pom]
[INFO] maven_son                                                          [jar]
[INFO] maven_web                                                          [war]
[INFO] maven_ju                                                           [pom]
[INFO] 
......
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ maven_03 ---
[INFO] Surefire report directory: E:\BJ2310\10-Maven\04_project\mavenall\maven_03\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running test.MyTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.068 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ maven_03 ---
[INFO] Building jar: E:\BJ2310\10-Maven\04_project\mavenall\maven_03\target\maven_03-1.0-SNAPSHOT.jar
[INFO] 
[INFO] ----------------------< com.bjpowernode:maven_02 >----------------------
[INFO] Building maven_02 1.0-SNAPSHOT                                     [2/7]
[INFO]   from ..\maven_02\pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ maven_02 ---
......
Running test.MyTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.055 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ maven_02 ---
[INFO] Building jar: E:\BJ2310\10-Maven\04_project\mavenall\maven_02\target\maven_02-1.0-SNAPSHOT.jar
[INFO] 
[INFO] ----------------------< com.bjpowernode:maven_01 >----------------------
[INFO] Building maven_01 1.0-SNAPSHOT                                     [3/7]
[INFO]   from ..\maven_01\pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ maven_01 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] 
.......
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ maven_01 ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ maven_01 ---
[INFO] Building jar: E:\BJ2310\10-Maven\04_project\mavenall\maven_01\target\maven_01-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --------------------< com.bjpowernode:maven_parent >--------------------
[INFO] Building maven_parent 1.0-SNAPSHOT                                 [4/7]
[INFO]   from ..\maven_parent\pom.xml
[INFO] --------------------------------[ pom ]---------------------------------
[INFO] 
[INFO] ---------------------< com.bjpowernode:maven_son >----------------------
[INFO] Building maven_son 1.0-SNAPSHOT                                    [5/7]
[INFO]   from ..\maven_parent\maven_son\pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
......
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ maven_son ---
[INFO] Building jar: E:\BJ2310\10-Maven\04_project\mavenall\maven_parent\maven_son\target\maven_son-1.0-SNAPSHOT.jar
[INFO] 
[INFO] ---------------------< com.bjpowernode:maven_web >----------------------
[INFO] Building maven_web 1.0-SNAPSHOT                                    [6/7]
[INFO]   from ..\maven_parent\maven_web\pom.xml
[INFO] --------------------------------[ war ]---------------------------------
[INFO] 
.......
[INFO] ----------------------< com.bjpowernode:maven_ju >----------------------
[INFO] Building maven_ju 1.0-SNAPSHOT                                     [7/7]
[INFO]   from pom.xml
[INFO] --------------------------------[ pom ]---------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for maven_ju 1.0-SNAPSHOT:
[INFO] 
[INFO] maven_03 ........................................... SUCCESS [  2.506 s]
[INFO] maven_02 ........................................... SUCCESS [  0.609 s]
[INFO] maven_01 ........................................... SUCCESS [  0.083 s]
[INFO] maven_parent ....................................... SUCCESS [  0.000 s]
[INFO] maven_son .......................................... SUCCESS [  0.127 s]
[INFO] maven_web .......................................... SUCCESS [  1.043 s]
[INFO] maven_ju ........................................... SUCCESS [  0.002 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.543 s
[INFO] Finished at: 2024-03-16T00:07:25+08:00
[INFO] ------------------------------------------------------------------------
```

总结：一句话，聚合就是集中构建项目的。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726311129-d4bf577a-8ef1-4d1b-aba3-fcc863f41d83.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u89771d13&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u2d924de1-7a53-402e-8c4e-b3da7007ad9&title=&width=1400)
# Maven的私服
## 什么是私服
Maven 私服是一种特殊的远程仓库，它是架设在局域网内的仓库服务，用来代理位于外部的远程仓库（中央仓库、其他远程公共仓库）。一些无法从外部仓库下载到的构件，也能从本地上传到私服供其他人使用。

Maven 私服其实并不是 Maven 的核心概念，它仅仅是一种衍生出来的特殊的仓库，但这并不代表它不重要，相反由于私服具有降低中央仓库负荷、节省外网带宽、以及提高项目稳定性等优点，使得私服在实际开发过程中得到了相当普遍地使用。建立了 Maven 私服后，当局域网内的用户需要某个构件时，会先请求本地仓库，若本地仓库不存在所需构件，则请求 Maven 私服，将所需构件下载到本地仓库，若私服中不存在所需构件，再去请求外部的远程仓库，将所需构件下载并缓存到 Maven 私服，若外部远程仓库不存在所需构件，则 Maven 直接报错。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726314952-864958e4-f13f-4aa4-b775-de041d0cc3f2.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u2a91ba7c&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=ucbd4bbc3-d494-4e7d-a5bc-0f8a4596121&title=&width=1400)
## Maven仓库管理器Nexus
### 什么是Nexus
Nexus 是 Sonatype 公司发布的一款仓库（Repository）管理软件，常用来搭建 Maven 私服，所以也有人将 Nexus 称为“Maven仓库管理器”。 Sonatype Nexus 是当前最流行，使用最广泛的 Maven 仓库管理器。Nexus 分为开源版和专业版，其中开源版足以满足大部分 Maven 用户的需求。

### Nexus仓库的类型
Nexus默认内置了很多仓库，这些仓库可以划分为3种类型，每种类型的仓库用于存放特定的jar包，具体说明如下：

1. hosted：宿主仓库，部署自己的jar包到这个类型的仓库中，包括Releases和Snapshots两部分，Releases为公司内部发行版本仓库，Snapshots为公司内部测试版本仓库。
2. proxy：  代理仓库，用于代理远程的公共仓库，如Maven中央仓库，用户连接私服，私服自动去中央仓库下载Jar包或者插件。
3. group：仓库组，用来合并多个hosted/proxy仓库，通常用于配置自己的Maven连接仓库组。当我们下载jar包时，从仓库组中的每个仓库找一遍，找到后下载。

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710725573245-a25c98e8-302b-4461-95cc-aacd2e49191a.png#averageHue=%23eeebd5&clientId=u1450a208-3265-4&from=paste&height=480&id=ub9859d8b&originHeight=480&originWidth=683&originalType=binary&ratio=1&rotation=0&showTitle=false&size=44407&status=done&style=shadow&taskId=u7906d8c9-de81-4042-b9bc-0dc267363e1&title=&width=683)![](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710586648632-8430fc88-b320-4e83-a6ee-1167d069029b.png?x-oss-process=image%2Fformat%2Cwebp%2Fresize%2Cw_1240%2Climit_0#averageHue=%23dad6d6&from=url&height=294&id=wF09Z&originHeight=474&originWidth=1240&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=&width=770)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726317988-f62a1be7-7eb0-4201-8e72-5d39f9848a32.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=uf12eee2e&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u92fab0f8-57e3-4886-ab2d-7e83a66e4af&title=&width=1400)
### 如何搭建私服

1. 下载Nexus

官网地址：[https://help.sonatype.com/repomanager3/download](https://help.sonatype.com/repomanager3/download)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710570372422-d6d1a018-13fd-4cb2-be32-2fa1cde58784.png#averageHue=%23f8f8e3&clientId=u025dd473-afbf-4&from=paste&height=463&id=u9aa5a333&originHeight=695&originWidth=1886&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=165154&status=done&style=none&taskId=udc3599b3-61c7-48f7-bf88-9e98e0411b6&title=&width=1257.3333333333333)

2. 安装Nexus

下载后解压到一个没有中文的路径下：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710577090494-cce93c84-89cb-4b7d-8b53-18fadcf1e9c7.png#averageHue=%23fbfbfa&clientId=u025dd473-afbf-4&from=paste&height=177&id=u22e4d8df&originHeight=265&originWidth=1309&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=30272&status=done&style=shadow&taskId=u4b362181-830b-4f70-80e3-124b47d61e3&title=&width=872.6666666666666)

进入到D:\nexus-3.66.0-02\bin目录下：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710575432440-e583f4cd-0a9c-4788-9d64-9deb1f53484d.png#averageHue=%23fbfbfa&clientId=u025dd473-afbf-4&from=paste&height=221&id=u0714eefb&originHeight=332&originWidth=1316&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=33549&status=done&style=none&taskId=u80e78590-a350-48cf-9a9a-88101a8f328&title=&width=877.3333333333334)

双击nexus.exe没有反应，需要以管理员身份打开cmd窗口，输入命令： nexus   /run    回车，需要等待一段时间，直到出现Started Sonatype Nexus OSS 3.66.0-02说明安装成功。
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710577414248-c6b97c6a-2997-453b-8020-4a1d05259d79.png#averageHue=%23292624&clientId=u025dd473-afbf-4&from=paste&height=506&id=u5ac3b6a8&originHeight=759&originWidth=1463&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=142584&status=done&style=none&taskId=u28f905c2-51a4-4d49-832f-b974d857378&title=&width=975.3333333333334)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726323394-fc7658e0-bb1a-416e-8999-1d7812f37357.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u2596afa4&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u2da06b9f-0b41-4c80-be32-74d4d13e91c&title=&width=1400)

3. 访问Nexus

访问地址：http://localhost:8081
端口号可以改变，在D:\nexus-3.66.0-02\etc目录下的nexus-default.properties文件中进行修改。
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710577791900-90da1d1f-9a7f-4af2-800c-f4a0f1d8e868.png#averageHue=%23f6f4f4&clientId=u025dd473-afbf-4&from=paste&height=573&id=u977664c0&originHeight=860&originWidth=1574&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=204222&status=done&style=none&taskId=u90489ce0-5b47-4cc5-a812-de39d017f0f&title=&width=1049.3333333333333)
注意：如果浏览器访问一直转圈打不开页面，则在cmd窗口ctrl+c唤醒一下就可以打开了。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726326509-afe309c6-5d25-49ca-b7a5-017c7e5d7d1d.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=uddb223cb&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u60fb9eca-3fe2-4788-b336-bde7a03fdda&title=&width=1400)
## Nexus私服的应用
### 登录
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710578382883-2473002b-8a8c-49aa-9ff6-8f2f43b4368c.png#averageHue=%23ccaf85&clientId=u025dd473-afbf-4&from=paste&height=359&id=ubd976bfc&originHeight=538&originWidth=1864&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=87721&status=done&style=none&taskId=ue5fc4f41-9538-4d10-9f66-6f43d980f5c&title=&width=1242.6666666666667)
密码所在的文件：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710578676893-c70852d1-a697-4173-91cd-0d54965ef7cd.png#averageHue=%23f5f3f2&clientId=u025dd473-afbf-4&from=paste&height=513&id=ubb0fbe29&originHeight=770&originWidth=1320&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=114192&status=done&style=none&taskId=u207f8331-ad1b-4b0c-b2df-8895e61ad46&title=&width=880)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710578745174-adf07074-2ee6-4ccc-adfd-e1cbe23234b5.png#averageHue=%23b29a75&clientId=u025dd473-afbf-4&from=paste&height=477&id=u1b3efa36&originHeight=716&originWidth=1848&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=102068&status=done&style=none&taskId=u47d2efbf-e5d1-49b3-9cab-0227dd07dde&title=&width=1232)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710578912244-f8fdbcb4-0064-4628-b06a-5b39548c7d7e.png#averageHue=%23b8b7b7&clientId=u025dd473-afbf-4&from=paste&height=505&id=u4fb49c57&originHeight=758&originWidth=1783&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=93505&status=done&style=none&taskId=u04851639-4937-40ff-a649-08ceb0d2b10&title=&width=1188.6666666666667)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710579554576-5fc530bd-605c-4a1d-92d4-e3292de9b05a.png#averageHue=%23c3c49c&clientId=u025dd473-afbf-4&from=paste&height=475&id=ucce9bfce&originHeight=713&originWidth=1911&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=94018&status=done&style=none&taskId=u3e4945ee-89d2-4186-9e7f-ff9f84f623e&title=&width=1274)
点Browse观察
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710586648632-8430fc88-b320-4e83-a6ee-1167d069029b.png#averageHue=%23dad6d6&clientId=u025dd473-afbf-4&from=paste&height=474&id=uf1a90efe&originHeight=711&originWidth=1860&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=157627&status=done&style=none&taskId=u708042fa-8f81-496d-be9c-7146bdc63f9&title=&width=1240)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726332170-2850f85f-528c-44bd-b437-4ec88fb01135.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=ua9b87dbe&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=uce64b8ca-791b-4f9b-926e-d0ac8c89023&title=&width=1400)

### 设置仓库

1. 创建仓库

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710589583924-8d28f532-f702-4c48-8a59-e7cbf2f9e5fc.png#averageHue=%23b8b6b5&clientId=u025dd473-afbf-4&from=paste&height=181&id=u17ded29a&originHeight=271&originWidth=1842&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=71118&status=done&style=none&taskId=u6cd2be1b-e7ca-4688-8e05-63c2735cedf&title=&width=1228)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710589678658-e5e35527-830d-4341-89bd-1ab34fe6910d.png#averageHue=%23d6d4d4&clientId=u025dd473-afbf-4&from=paste&height=394&id=u6b032ae7&originHeight=591&originWidth=1843&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=129384&status=done&style=none&taskId=u08f2b726-939f-4694-b68d-0be6e891a26&title=&width=1228.6666666666667)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710589889744-af161de3-c9a3-4601-97c2-0829604d7056.png#averageHue=%23e2e1e1&clientId=u025dd473-afbf-4&from=paste&height=602&id=u3fdc5574&originHeight=903&originWidth=1849&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=142247&status=done&style=none&taskId=ue04b4937-f6b9-41d9-af46-afae6c7063a&title=&width=1232.6666666666667)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710590255782-e59dc0bb-e821-4485-b55d-ac85f35204ad.png#averageHue=%23dad9d8&clientId=u025dd473-afbf-4&from=paste&height=419&id=u97c637b5&originHeight=629&originWidth=1850&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=130507&status=done&style=none&taskId=ud18a7ffa-f8e6-4d27-a73f-abb8d2a3cd7&title=&width=1233.3333333333333)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710589981642-18af2fb7-4e16-4b60-8823-14c3a2517ee1.png#averageHue=%23d3d1d0&clientId=u025dd473-afbf-4&from=paste&height=381&id=ufd4e8fc7&originHeight=572&originWidth=1852&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=163035&status=done&style=none&taskId=u13efa02d-0348-4560-b7ca-4fe4631f2e8&title=&width=1234.6666666666667)

2. 将创建好的仓库添加到public组中。

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710590564218-94fda846-3c68-46cf-b75a-d289e4c87bde.png#averageHue=%23d8d7d6&clientId=u025dd473-afbf-4&from=paste&height=499&id=u4be7ef8f&originHeight=749&originWidth=1855&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=208210&status=done&style=none&taskId=ud909667b-0229-449e-8764-7fbce96fb21&title=&width=1236.6666666666667)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710590619703-91ef96bd-b119-4744-b860-523e62d36e04.png#averageHue=%23e2e1e1&clientId=u025dd473-afbf-4&from=paste&height=581&id=u95101d6f&originHeight=871&originWidth=1808&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=138766&status=done&style=none&taskId=ua9a43b06-b054-4ac4-91a5-dda7420a57d&title=&width=1205.3333333333333)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710590666393-688daeb6-4bc0-4982-ad3b-be23a9333687.png#averageHue=%23e1e0e0&clientId=u025dd473-afbf-4&from=paste&height=576&id=ua02d0d80&originHeight=864&originWidth=1851&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=137614&status=done&style=none&taskId=u0b273ef4-0c86-427f-8ebf-b82fefb5428&title=&width=1234)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726336997-278c1a20-f874-4061-b7b3-c5c48c9f48b8.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u23ab9b07&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u467aebaf-2da5-4ee6-8c04-8f30fa58693&title=&width=1400)
### 使用Nexus下载jar包
创建一个新的本地仓库，用来接收Nexus下载下来的jar包。
因为要使用Maven工具访问私服，所以settings.xml文件要修改。

1. 本地仓库地址修改为新地址
```xml
<localRepository>E:\repository_nexus</localRepository>
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710595705585-36ca7718-4754-4725-95c6-e1df8b9fab14.png#averageHue=%23f8f6f5&clientId=u025dd473-afbf-4&from=paste&height=371&id=qaZvg&originHeight=556&originWidth=1397&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=165706&status=done&style=none&taskId=ud9b3b741-ba7f-41de-92fc-ed5bdb22d5b&title=&width=931.3333333333334)

2. 设置<mirror>标签为Nexus的maven-public库地址（仓库组）
```xml
<mirror>
  <id>dljd-nexus</id>
  <mirrorOf>central</mirrorOf>
  <name>mynexus</name>
  <url>http://localhost:8081/repository/maven-public/</url>
</mirror>
```
其中<url>标签的地址复制maven-public库的地址。这个地址取代了中央仓库地址。我们所有的jar包下载都是从这个地址里找。它包含宿主库和代理库的所有地址。
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710595526378-d59c4cf0-1b13-41e0-9298-70ddb75cc971.png#averageHue=%23a6a4a3&clientId=u025dd473-afbf-4&from=paste&height=525&id=ud954b07b&originHeight=788&originWidth=1821&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=173601&status=done&style=none&taskId=u07e61d5c-9365-4240-89b4-f6ff56e70e0&title=&width=1214)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726342406-4777a8ce-9a6c-4d52-90db-8b7b9da9c90f.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u056111b3&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u94377579-ee9f-4778-bd4e-91e64d88245&title=&width=1400)

3. 设置每次访问Nexus的用户名和密码，修改settings.xml文件中的<server>标签
```xml
<server>
  <id>dljd-nexus</id>
  <username>admin</username>
  <password>admin</password>
</server>
```
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710596219243-d9bfdb91-472d-492c-96f2-0e4c2e6df2f3.png#averageHue=%23f8f4f3&clientId=u025dd473-afbf-4&from=paste&height=344&id=j0Ph6&originHeight=516&originWidth=1388&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=144015&status=done&style=shadow&taskId=ufa9123f9-7bd7-4580-8f3e-02449b2d5ae&title=&width=925.3333333333334)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726345194-0250f8f0-725e-439d-b4e0-4a5fc29da710.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u07c57e0f&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u341dd43c-75b0-4f39-9a9e-b56ed2c53f7&title=&width=1400)

4. 打开Idea2023，确定是新的本地仓库地址

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710596742497-f977c201-2556-465b-8415-0b2a2b716953.png#averageHue=%233e4247&clientId=u025dd473-afbf-4&from=paste&height=673&id=u8aa42ee8&originHeight=1010&originWidth=1474&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=107535&status=done&style=none&taskId=u4a7bc7bd-b10d-4b8c-9aa3-3b9e6a7bd48&title=&width=982.6666666666666)
选择一个项目maven_01执行clean操作。![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710597060668-9657312a-3d1b-46e2-a339-919b75baff80.png#averageHue=%23455947&clientId=u025dd473-afbf-4&from=paste&height=673&id=u6267674e&originHeight=1010&originWidth=1900&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=292301&status=done&style=none&taskId=u5b7d5d7a-8c18-4ad6-bc13-a9f61e79e69&title=&width=1266.6666666666667)
观察本地仓库：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710597467794-be84dd2e-0633-4408-a494-e8e2bf671095.png#averageHue=%23fbf9f8&clientId=u025dd473-afbf-4&from=paste&height=186&id=ua9659baa&originHeight=279&originWidth=1265&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=33099&status=done&style=none&taskId=u06cdc023-5126-4ae1-b564-a34bde729cf&title=&width=843.3333333333334)
观察私服Nexus上的maven-public组
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710597430739-fc2a2304-03af-48f6-8e3d-e3e0e3620110.png#averageHue=%23cdcbcb&clientId=u025dd473-afbf-4&from=paste&height=269&id=uf339e316&originHeight=404&originWidth=1850&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=77138&status=done&style=none&taskId=u16a39d7d-635c-4e8a-a307-6cc9500d606&title=&width=1233.3333333333333)

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726350164-9966f8cf-fdc9-4227-9086-d492b4b2dc66.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=ub3025dc4&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u1e024626-dfa7-4782-9f08-b7d56d9c74b&title=&width=1400)

### 使用Idea部署jar包到Nexus私服
私服Nexus是部署在局域网的，是全公司共享的仓库地址，每个团队都可以将已完成的功能或测试版本发布到私服供别人来使用。

1. 打开要部署的项目的pom.xml文件，设置上传路径
```xml
<distributionManagement>
  <repository>
    <id>dljd-nexus</id>
    <url>http://localhost:8081/repository/dljd-release/</url>
  </repository>
  <snapshotRepository>
    <id>dljd-nexus</id>
    <url>http://localhost:8081/repository/dljd-snapshot/</url>
  </snapshotRepository>
</distributionManagement>
```

其中<url>路径来自于私服dljd-snapshot.
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710601782311-d10b3ebb-b91c-4e07-a5db-b1af1ed34d78.png#averageHue=%23a5a4a3&clientId=ue6a5b10a-4711-4&from=paste&height=588&id=u068366a5&originHeight=882&originWidth=1837&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=181842&status=done&style=none&taskId=u5f983d50-71f3-4d1b-8f71-99da93392c9&title=&width=1224.6666666666667)
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710599781490-0ae738c8-f2a5-426a-b1fa-4f3b03ebb710.png#averageHue=%23a6a4a4&clientId=ue6a5b10a-4711-4&from=paste&height=564&id=u0e64ecca&originHeight=846&originWidth=1838&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=178991&status=done&style=none&taskId=u9e3adfd2-b6ce-45e9-acac-f1507d9949b&title=&width=1225.3333333333333)

2. 运行deploy部署命令

![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710601913346-5d734890-c6bb-478c-99b3-0b8620053c3e.png#averageHue=%235d7577&clientId=ue6a5b10a-4711-4&from=paste&height=673&id=u3fb54899&originHeight=1010&originWidth=1900&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=273512&status=done&style=none&taskId=u4045d62d-5ed0-4dde-8205-d8b1d7c3ceb&title=&width=1266.6666666666667)

3. 观察私服对应仓库变化

release项目部署
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710602004568-db363d8f-ecc7-414c-b432-9a79bbf88191.png#averageHue=%23d5d4d3&clientId=ue6a5b10a-4711-4&from=paste&height=341&id=u95028ca3&originHeight=511&originWidth=1838&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=97536&status=done&style=none&taskId=u6974d175-4489-4a3e-bee6-e84e97405e4&title=&width=1225.3333333333333)
snapshot项目部署
![image.png](https://cdn.nlark.com/yuque/0/2024/png/42995594/1710602043184-441c9483-a596-41b5-b0b1-221b8d82ca0c.png#averageHue=%23d5d5d5&clientId=ue6a5b10a-4711-4&from=paste&height=348&id=u4c40e9fe&originHeight=522&originWidth=1841&originalType=binary&ratio=1.5&rotation=0&showTitle=false&size=96729&status=done&style=none&taskId=ufc2c7061-36cd-48ab-8d46-5065710ffe9&title=&width=1227.3333333333333)
总结：整个Maven工具的应用就讲完了。其中一二三章是基础应用，四五六章是高级应用，工作时遇到的问题四五六章有解决方案，到时候再看也来得及。

![标头.jpg](https://cdn.nlark.com/yuque/0/2024/jpeg/42995594/1710726356059-c0a22862-6b43-476e-bf05-7b2a2d0074ad.jpeg#averageHue=%23f9f8f8&clientId=u1450a208-3265-4&from=paste&height=78&id=u091cc52d&originHeight=78&originWidth=1400&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5764&status=done&style=none&taskId=u09f096b2-1d10-49ab-9445-841fbf7fbe9&title=&width=1400)

## Maven的坑

### 1.缓存文件清理

在本地仓库中将.lastUpdate结尾的文件删除干净，重新搭建。
