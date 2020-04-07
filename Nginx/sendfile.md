[Nginx官方文档](http://nginx.org/en/docs/http/ngx_http_core_module.html#sendfile)
*****
设置为on表示启动高效传输文件的模式。

sendfile可以让Nginx在传输文件时直接在磁盘和tcp socket之间传输数据。

如果这个参数不开启，会先在用户空间（Nginx进程空间）申请一个buffer，用read函数把数据从磁盘读到cache，再从cache读取到用户空间的buffer，再用write函数把数据从用户空间的buffer写入到内核的buffer，最后到tcp socket。

开启这个参数后可以让数据不用经过用户buffer。

---

```
location /video/ {
    sendfile       on;
    tcp_nopush     on;
    aio            on;
}
```

---

零拷贝是什么?[博客](https://www.cnblogs.com/pengdonglin137/articles/7995528.html)

---

[nginx AIO机制与sendfile机制](http://www.178linux.com/54790)

[aio官方](http://nginx.org/en/docs/http/ngx_http_core_module.html#aio)异步文件读取

```
location /video/ {
    sendfile on;
    sendfile_max_chunk 256k; 
    aio threads;
    directio 512k;
    output_buffers 1 128k;
}
```

---

