[Nginx官网文档](http://nginx.org/en/docs/http/ngx_http_core_module.html#location)
`location [ = | ~ | ~* | ^~ ] uri { ... }`

> A location can either be defined by a prefix string, or by a regular expression. Regular expressions are specified with the preceding “`~*`” modifier (for case-insensitive matching), or the “`~`” modifier (for case-sensitive matching). To find location matching a given request, nginx first checks locations defined using the prefix strings (prefix locations). Among them, the location with the longest matching prefix is selected and remembered. Then regular expressions are checked, in the order of their appearance in the configuration file. The search of regular expressions terminates on the first match, and the corresponding configuration is used. If no match with a regular expression is found then the configuration of the prefix location remembered earlier is used.

`~*`表示正则忽略大小写匹配。`~`表示正则不忽略大小写匹配。

先检查前缀匹配，路径最长匹配的location将被记录下来；再检查正则匹配，按照在配置文件出现位置的顺序；一旦正则匹配到，该被匹配的location配置将被使用。否则使用被记录下的路径最长匹配的location。

> If the longest matching prefix location has the “`^~`” modifier then regular expressions are not checked.

如果最长匹配前缀位置具有`^~`修饰符，则不检查正则表达式。

> Also, using the “`=`” modifier it is possible to define an exact match of URI and location. If an exact match is found, the search terminates. For example, if a “`/`” request happens frequently, defining “`location = /`” will speed up the processing of these requests, as search terminates right after the first comparison. Such a location cannot obviously contain nested locations.

`=`表示精确匹配。
一旦精确匹配成功，则匹配立刻终止。例如，如果请求`/`十分频繁，那么设置`location = /`将会提高速度。

---

**总结**：匹配类型大体分为`精确`、`前缀` 、`正则`。前缀分为`普通`前缀和带`^~`前缀。正则分是否区分大小写两种。精确匹配优先级最高(匹配即终止)。
然后在`前缀` 、`正则`中选择：首先前缀匹配选出最长路径匹配的location，判断其是否有`^~`修饰；若有则立即终止；若无则记录下此最长匹配路径的location，进行正则匹配；正则匹配按照在配置文件中的顺序依次匹配，若匹配到则终止；若未匹配到则使用记录下的最长匹配路径的location。[流程图展示](https://www.processon.com/view/link/5dde4501e4b0df12b4a5c710)

---

Nginx[  指令  官方文档](http://nginx.org/en/docs/dirindex.html)

Nginx[  变量  官方文档](http://nginx.org/en/docs/varindex.html)
