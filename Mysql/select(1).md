```mysql
zhangpn [(none)]>select @@port;
+--------+
| @@port |
+--------+
|   3306 |
+--------+
1 row in set (0.00 sec)
```

```mysql
select @@basedir;
select @@datadir;
show variables like 'datadir';
show variables like 'innodb%commit';
select @@socket;
select @@server_id;
```

```mysql
zhangpn [mysql]>select database();
+------------+
| database() |
+------------+
| mysql      |
+------------+
1 row in set (0.00 sec)
```

```mysql
select now();
select user();
select concat('a','b');
```

```mysql
zhangpn [mysql]>select user, host from mysql.user where user = 'root';
+------+------+
| user | host |
+------+------+
| root | %    |
+------+------+
1 row in set (0.00 sec)
```

```mysql
select user, host, max_connections from mysql.user where max_connections < 10;
select user, host, max_connections from mysql.user where user like 'r%t';
select user, host, max_connections from mysql.user where user in ('root', 'mysql.sys');
select user, host, max_connections from mysql.user where max_connections between 0 and 10;
```

```mysql
zhangpn [(none)]>select id, name, age, team from test.student;
+----+----------+------+---------+
| id | name     | age  | team    |
+----+----------+------+---------+
|  1 | zhangpn  |   25 | math    |
|  2 | apollo   |   22 | english |
|  3 | paul     |   32 | math    |
|  4 | flash    |   26 | english |
|  5 | kongfu   |   33 | china   |
|  6 | shanghai |   62 | china   |
+----+----------+------+---------+
6 rows in set (0.00 sec)
```

```mysql
zhangpn [(none)]>select team, max(age), min(age), avg(age), sum(age), count(age) from test.student group by team;
+---------+----------+----------+----------+----------+------------+
| team    | max(age) | min(age) | avg(age) | sum(age) | count(age) |
+---------+----------+----------+----------+----------+------------+
| china   |       62 |       33 |  47.5000 |       95 |          2 |
| english |       26 |       22 |  24.0000 |       48 |          2 |
| math    |       32 |       25 |  28.5000 |       57 |          2 |
+---------+----------+----------+----------+----------+------------+
3 rows in set (0.00 sec)
```

```mysql
group_concat():列转行
zhangpn [(none)]>select team, group_concat(team) from test.student where age > 30 group by team;
+-------+--------------------+
| team  | group_concat(team) |
+-------+--------------------+
| china | china,china        |
| math  | math               |
+-------+--------------------+
2 rows in set (0.00 sec)
```

