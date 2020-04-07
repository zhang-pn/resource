## @NoArgsConstructor

`@NoArgsConstructor` 提供一个无参构造器

```java
@NoArgsConstructor
public class Node {
    private int data;
    private Node next;
}
```

 编译后

```java
public class Node {
    private int data;
    private Node next;

    public Node() {
    }
}
```

`@NoArgsConstructor(access = AccessLevel.PRIVATE)` 构造器私有化

`@NoArgsConstructor(force = true)` 强制初始化字段 0 / false / null [强制对未赋值的final字段初始化值]

`@NoArgsConstructor(onConstructor = @__(@Autowired))` 方法入参添加注解

`@NoArgsConstructor(staticName = "getNode")` 提供一个静态构造器,构造方法被私有化

## @RequiredArgsConstructor

`@RequiredArgsConstructor` 提供参数为带有@NonNull注解和final修饰的未经初始化的字段的构造器

## @AllArgsConstructor

`@AllArgsConstructor` 提供一个不包括已初始化的final字段全参数的构造方法