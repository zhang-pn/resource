[Nginx官网文档](http://nginx.org/en/docs/http/ngx_http_proxy_module.html#proxy_set_header)
*****
请求头重新定义。

```
proxy_set_header   Host             $host;
proxy_set_header   X-Real-IP        $remote_addr;
proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;
```