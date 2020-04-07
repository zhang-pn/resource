### 安装 :zap:

> 下载 安装包 nginx-1.16.1.tar.gz <http://nginx.org/en/download.html>

##### 编译与安装 :zap:

```bash
./configure --prefix=/usr/local/nginx
make
make install
```

- **报错**

  ```
  ./configure: error: the HTTP rewrite module requires the PCRE library.
  You can either disable the module by using --without-http_rewrite_module
  option, or install the PCRE library into the system, or build the PCRE library
  statically from the source with nginx by using --with-pcre=<path> option.
  ```

  **解决**

  ```bash
  yum -y install pcre-devel
  ```

- **报错**

  ```
  ./configure: error: the HTTP gzip module requires the zlib library.
  You can either disable the module by using --without-http_gzip_module
  option, or install the zlib library into the system, or build the zlib library
  statically from the source with nginx by using --with-zlib=<path> option.
  ```

  **解决**

  ```bash
  yum install -y zlib-devel
  ```

### 使用 :zap:

##### 检查配置 :zap:

```bash
nginx -t
```

##### 启动程序 :zap:

```bash
nginx
```

##### 重载配置 :zap:

```bash
nginx -s reload
```

##### 立即停止 :zap:

```bash
nginx -s stop
```

##### 平滑停止 :zap:

```bash
nginx -s quit
```

##### 查看进程 :zap:

```bash
ps -ef | grep nginx
```