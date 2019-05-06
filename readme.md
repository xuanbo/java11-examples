# java11-examples

![java11](https://img.shields.io/badge/java-11-green.svg)

## 模块化

从Java 9开始引入了模块化的概念，因此使用Java11也需要以模块化的方式进行项目的构建和编译。

### 已有的Maven项目

为了将项目迁移到最新的Java版本11，强烈建议尽可能多地更新插件和依赖项到最新的稳定版本。
如果使用旧版本，许多插件（如编译器插件，`surefire`或`failsafe`）与Java 9不兼容。
此外，许多库在不迁移到最新版本的情况下也不兼容。

确保你在主POM中配置了版本插件：

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>versions-maven-plugin</artifactId>
    <version>2.5</version>
    <configuration>
        <generateBackupPoms>false</generateBackupPoms>
    </configuration>
</plugin>
```

此插件有助于查找模块的最新插件或依赖版本，打开终端并执行此命令以查找你必须更新的插件版本：

```shell
mvn versions:display-plugin-updates
```

### Maven项目支持

Java 11最重要的插件是编译器插件，surefire（用于单元测试）和failsafe （用于集成测试）。

启用Java11语言支持：

```xml
<properties>
    <java.version>11</java.version>
    <maven.compiler.source>${java.version}</maven.compiler.source>
    <maven.compiler.target>${java.version}</maven.compiler.target>
</properties>
```

为了能够使用Java 9的模块系统，`maven-compiler-plugin`版本`3.6.1`或更高版本是必需的。

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.0</version>
    <configuration>
        <release>11</release>
    </configuration>
</plugin>
```

请`release`配置添加到编译器插件中，这是一个新的编译器参数，用于替换`source`和`target`版本参数：

对于`surefire`和`failsafe`插件，我们添加了一个额外的参数，`--illegal-access=permit`以允许第三方库的所有反射访问：

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.0</version>
    <configuration>
        <argLine>
            --illegal-access=permit
        </argLine>
    </configuration>
</plugin>
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-failsafe-plugin</artifactId>
    <version>2.22.0</version>
    <configuration>
        <argLine>
            --illegal-access=permit
        </argLine>
    </configuration>
</plugin>
```

只有在依赖项大量使用反射时才需要这样做，如果你不确定是否需要这个，如果你的测试遇到麻烦，可以添加配置argLine选项。

### Spring Boot项目支持

对于Spring Boot项目，`spring boot`版本更新到`2.1.0`或更高版本是必需的。

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>${spring.boot.version}</version>
</dependency>
```

### 更新依赖

接下来需要更新不兼容的依赖了。

## 参考

* [将Maven项目迁移到Java 11](https://www.jdon.com/49937)
* [Migrate Maven Projects to Java 11](https://winterbe.com/posts/2018/08/29/migrate-maven-projects-to-java-11-jigsaw/)