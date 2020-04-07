`mysql.com/`                                                                              点击`DOWNLOADS`

`mysql.com/downloads/`                                                         点击`MySQL Community (GPL) Downloads »`

`dev.mysql.com/downloads/`                                                 点击Download Archives

`downloads.mysql.com/archives/`                                       点击[MySQL Community Server](https://downloads.mysql.com/archives/community/)

`downloads.mysql.com/archives/community/`                  选择`Linux-Generic`版本

---

##### 下载

```bash
wget https://cdn.mysql.com/archives/mysql-5.7/mysql-5.7.20-linux-glibc2.12-x86_64.tar.gz
```

##### 解压

```bash
tar -zxvf mysql-5.7.20-linux-glibc2.12-x86_64.tar.gz
```

##### 规划目录

> `mysql`为根目录，`mysql-5.7.20-linux-glibc2.12-x86_64`为二进制目录，`data`为数据目录。

```bash
mkdir -p /opt/mysql/data
mv mysql-5.7.20-linux-glibc2.12-x86_64 /opt/mysql/
```

##### 新建用户与组

```bash
groupadd mysql
useradd -r -s /sbin/nologin -g mysql mysql -d /opt/mysql
```

```bash
chown -R mysql:mysql /opt/mysql
```

##### 配置环境

```bash
echo 'export PATH=/opt/mysql/mysql-5.7.20-linux-glibc2.12-x86_64/bin:$PATH' >> /etc/profile
source /etc/profile
```

##### 初始化

```bash
mysqld --initialize --user=mysql --basedir=/opt/mysql/mysql-5.7.20-linux-glibc2.12-x86_64 --datadir=/opt/mysql/data
```

> 倘若报错：mysqld: error while loading shared libraries: libaio.so.1: cannot open shared object file: No such file or directory
>
> 执行解决：`yum install -y libaio`

> --initialize : 带有安全机制（含有默认密码）
>
> --initialize-insecure : 安全机制->关闭

##### 配置文件

```ini
[mysqld]
user=mysql
basedir=/opt/mysql/mysql-5.7.20-linux-glibc2.12-x86_64
datadir=/opt/mysql/data
server_id=6
port=3306
socket=/tmp/mysql.sock

[mysql]
socket=/tmp/mysql.sock
prompt=3306 [\\d]>
```

##### 启动

```bash
/opt/mysql/mysql-5.7.20-linux-glibc2.12-x86_64/support-files/mysql.server start
```

> 复制`mysql.server`到`/etc/init.d`目录下，可以使用`service`启动。

```bash
cp /opt/mysql/mysql-5.7.20-linux-glibc2.12-x86_64/support-files/mysql.server /etc/init.d/mysqld
```

```bash
service mysqld start|stop|restart
```

##### 设密

```bash
mysqladmin -uroot -p password 123
```

