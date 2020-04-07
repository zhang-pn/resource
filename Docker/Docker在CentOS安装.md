##### 安装所需的包

> `yum-utils`提供了`yum-config-manager` 效用，并`device-mapper-persistent-data`和`lvm2`由需要 `devicemapper`存储驱动程序。



```bash
yum install -y yum-utils device-mapper-persistent-data lvm2
```

##### 添加repo仓库

```bash
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
```

##### 安装最新版

```bash
yum install -y docker-ce docker-ce-cli containerd.io
```

