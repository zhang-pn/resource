[Nginx官方文档](http://nginx.org/en/docs/http/ngx_http_proxy_module.html#proxy_pass)
*****

```
proxy_pass http://localhost:8000/uri/;
```

可以是具体的IP，也可是域名。

URI传递规则：(关于proxy_pass的参数路径问题)

> If the proxy_pass directive is specified with a URI, then when a request is passed to the server, the part of a normalized request URI matching the location is replaced by a URI specified in the directive: 

```
location /name/ {
    proxy_pass http://127.0.0.1/remote/;
}
```

如果 proxy_pass 包含有URI，那么location的path将会被替换。说白了，举个例子：

如果请求是 `http://www.demo.com/name/gosuncn/index.html` 那么，被location的`/name/`匹配到了，然后转发给代理时，`/name/`将会被proxy_pass替换掉：`http://127.0.0.1/remote/gosuncn/index.html`。

> If proxy_pass is specified without a URI, the request URI is passed to the server in the same form as sent by a client when the original request is processed, or the full normalized request URI is passed when processing the changed URI: 

```
location /some/path/ {
    proxy_pass http://127.0.0.1;
}
```

这种情况，比如传来了`http://www.demo.com/some/path/gosuncn/index.html`,转发给代理后：`http://127.0.0.1/some/path/gosuncn/index.html` 。

---

如果location使用正则表达式，那么proxy_pass不应该带有URI。

如果使用了rewrite命令，那么proxy_pass也不应该带有URI。

在proxy_pass中使用变量时，proxy_pass也不应该带有URI。

[WebSocket](http://nginx.org/en/docs/http/websocket.html) 代理时，需要其他特殊配置。