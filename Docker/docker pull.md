```bash
docker pull [OPTIONS] NAME[:TAG|@DIGEST]
```

示例：

```bash
docker pull java  # 默认是拉取tagged为latest版本的镜像
```

**-a :**拉取所有 tagged 镜像

```bash
docker pull -a java
```

**--disable-content-trust :**忽略镜像的校验,默认开启