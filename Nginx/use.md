[Nginx官网文档 - use ](http://nginx.org/en/docs/ngx_core_module.html#use)
*****
[Nginx官网文档 - epoll ](http://nginx.org/en/docs/events.html#epoll)
可以指定使用的方法，通常不需要指定，因为nginx通常会默认使用最有效的方法。
```
events {
    use epoll;
}
```