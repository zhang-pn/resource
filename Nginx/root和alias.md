[Nginx官方文档alias](http://nginx.org/en/docs/http/ngx_http_core_module.html#alias)
*****
[Nginx官方文档root](http://nginx.org/en/docs/http/ngx_http_core_module.html#root)
*****
| 语法:   | `root path;`                             |
| ----- | ---------------------------------------- |
| 默认值:  | `root html;`                             |
| 使用位置: | `http`, `server`, `location`, `if in location` |

```
location /i/ {
    root /data/w3;
}
```

请求：`/i/top.gif` , 服务器将`/data/w3/i/top.gif`文件响应给请求。

请求：               ` /i/top.gif`

响应：`/data/w3/i/top.gif`

---

| 语法:   | `alias path;` |
| ----- | ------------- |
| 默认值:  | —             |
| 使用位置: | `location`    |

```
location /i/ {
    alias /data/w3/images/;
}
```

请求：`/i/top.gif` , 服务器将`/data/w3/images/top.gif`文件响应给请求。

请求：                        ` /i/top.gif`

响应：`/data/w3/images/top.gif`

---