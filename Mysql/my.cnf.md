- **标签**
  - **服务端**
    1. [**mysqld**]
    2. [**mysqld_safe**]
    3. [**server**]
  - **客户端**
    1. [**mysql**]
    2. [**mysqldump**]
    3. [**client**]

- **配置项**
  - **key=value**形式

---

- [**mysqld**]

  user=mysql

  basedir=软件位置

  datadir=数据位置

  socket=服务器端的位置

  server_id=6，一般主从配置时，用到。【**1 - 65536**】

  port=3306

  log_error=/........,错误日志位置

- [**mysql**]

  socket=服务器端的位置

  prompt=Master [\\\d]>    提示作用

---

