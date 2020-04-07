### sock方式:

```bash
mysql -uroot -p -S /tmp/mysql.sock
```

`-S /tmp/mysql.sock`可以在配置文件里配置。

### tcp方式:

```bash
mysql -uroot -p -h 10.0.0.51 -P 3306
```

