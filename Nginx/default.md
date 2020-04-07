[Nginx官网文档](http://nginx.org/en/docs/http/request_processing.html#how_to_prevent_undefined_server_names)
*****
> 假设有3台虚拟主机都监听80端口

```
server {     # 主机 1
    listen      80;
    server_name example.org www.example.org;
    ...
}

server {     # 主机 2
    listen      80;
    server_name example.net www.example.net;
    ...
}

server {     # 主机 3
    listen      80;
    server_name example.com www.example.com;
    ...
}
```

> 当有一个请求发生时，通过请求头`Host`决定哪台主机相应。当`Host`是`example.net`时，则第二台主机响应。如果请求头`Host`是未知的(`未匹配`)则默认为第一台主机响应，但是，若某台主机的`listen`属性有`default_server`修饰，则默认由该主机响应。如：

```
server {
    listen      80 default_server;
    server_name example.net www.example.net;
    ...
}
```