[Nginx官网文档](http://nginx.org/en/docs/http/ngx_http_headers_module.html#expires)
*****
> 在回应请求时，在响应头中添加[Expires]和[Cache-Control],起到控制页面缓存的作用。

```
location ~ \.(jpg|png|gif)$ {
	root /home/images;
	expires 30d;  # 表示 30天后过期。
}
```

* expires -1; 表示永久过期。

校验Expires、Cache-Control(max_age)头，若未过期，则直接使用缓存。
若已过期，则：
校验Etag，若存在则校验Etag，ID一致则返回304使用缓存，若一致则服务器返回最新文件。
若不存在Etag，则：
校验Last-Modified，若一致则返回304使用缓存，若一致则服务器返回最新文件。
