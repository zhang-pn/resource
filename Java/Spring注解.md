## @Configuration

```java
@Configuration
public class MainConfig {}
```

相当于`beans.xml`配置文件。

```java
@Configuration
public class MainConfig {
    @Bean
    public Student student() {
        Student student = new Student();
        student.setName("Apollo");
        return student;
    }
}
```

相当于往容器里注入student对象。

## @Bean

默认bean的id是方法名。通过`@Bean`改变默认名称。

```java
@Configuration
public class MainConfig {
    @Bean("object")
    public Student student() {
        Student student = new Student();
        student.setName("Apollo");
        return student;
    }
}
```

由原本的`student`改成`object`。


## @ComponentScan

```java
@Configuration
@ComponentScan("com.dear")
public class MainConfig {
}
```

Spring会扫描`com.dear`包下所有的组件（标注`@Controller`、`@Service`、`@Repository`、`@Component` ）。

```java
Filter[] excludeFilters() default {}; // 排除组件
Filter[] includeFilters() default {}; // 包含组件
```

```java
@Configuration
@ComponentScan(value = "com.dear", excludeFilters = {})
public class MainConfig {
}
```

`excludeFilters`排除类。

```java
@ComponentScan(value = "com.dear", includeFilters = {}, useDefaultFilters = false)
```

扫描时，只扫描哪些组件。需要将`useDefaultFilters`默认过滤器禁用。

## @ComponentScans

```java
@ComponentScans(value = {@ComponentScan("com.dear"), @ComponentScan("com.dear")})
```

可以包含多个`@ComponentScan`。

## @Filter

FilterType：`ANNOTATION`，`ASSIGNABLE_TYPE`，`ASPECTJ`，`REGEX`，`CUSTOM`。

常用：`ANNOTATION` = `注解`  `ASSIGNABLE_TYPE` = `类型`

CUSTOM : 自定义规则。写一个`FilterType`的实现类。重写`match`方法，返回`boolean`值。

`metadataReader` : 读取当前正在扫描的类的信息。

`metadataReaderFactory` : 可以获取其他任何类信息。

## @Scope

默认是单例模式`singleton`.还有`prototype`、`request`、`session`、`global session` 。

## @Lazy

懒加载，在调用该组件时才创建。

```java
@Configuration
public class MainConfig {
    @Lazy
    @Bean
    public Student student() {
        Student student = new Student();
        student.setName("Apollo");
        return student;
    }
}
```

## @Conditional

满足条件，注入组件。

```java
public class ConditionalOnOS implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}
```

实现Condition接口，完成matches方法。

```java
@Configuration
public class MainConfig {
    @Conditional(ConditionalOnOS.class)
    @Bean
    public Student student() {
        Student student = new Student();
        student.setName("Apollo");
        return student;
    }
}
```

添加`@Conditional(ConditionalOnOS.class)`注解。

## @Import

```java
@Configuration
@Import(Student.class)
public class MainConfig {
}
```

默认是组件的全类名。

## 生命周期

### @Bean

```java
@Bean(initMethod = "方法名", destroyMethod = "方法名")
```

### InitializingBean/DisposableBean接口

```java
public class Student implements InitializingBean, DisposableBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void destroy() throws Exception {
        // TODO 销毁
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO 初始化
    }
}
```

### @PostConstruct和@PreDestroy

标注在方法上。

### BeanPostProcessor

```java
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
```

## @Value

给属性注入值，可使用SpEL表达式。

## @PropertySource

```java
@PropertySource(value = {"classpath:/student.properties"})
```

加载外部配置文件的值。

## @Autowired

自动装配 : 可以放在构造器、参数、字段、方法上。

当构造器只有一个参数时，可以省略`@Autowired`。

## @Qualifier

自动装配指定同一类具体某一对象。

## @Primary

自动装配时，默认使用首选的bean。

## `Aware`接口

### ApplicationContextAware

### BeanNameAware

### EmbeddedValueResolverAware

## AOP相关注解

### @EnableAspectAutoProxy

### @Aspect

### @PointCut

### @Before

### @After

### @AfterReturning

### @AfterThrowing

### @Around

