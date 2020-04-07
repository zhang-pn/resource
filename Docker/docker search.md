```bash
[root@DockerHub ~]# docker search nginx
NAME                              DESCRIPTION                                     STARS               OFFICIAL            AUTOMATED
nginx                             Official build of Nginx.                        11945               [OK]                
jwilder/nginx-proxy               Automated Nginx reverse proxy for docker con…   1652                                    [OK]
richarvey/nginx-php-fpm           Container running Nginx + PHP-FPM capable of…   740                                     [OK]
linuxserver/nginx                 An Nginx container, brought to you by LinuxS…   76                                      
bitnami/nginx                     Bitnami nginx Docker Image                      70                                      [OK]
```

---

(1/3): **--automated :**只列出 automated build类型的镜像；

```bash
[root@DockerHub ~]# docker search --automated nginx
Flag --automated has been deprecated, use --filter=is-automated=true instead
NAME                              DESCRIPTION                                     STARS               OFFICIAL            AUTOMATED
jwilder/nginx-proxy               Automated Nginx reverse proxy for docker con…   1652                                    [OK]
richarvey/nginx-php-fpm           Container running Nginx + PHP-FPM capable of…   740                                     [OK]
bitnami/nginx                     Bitnami nginx Docker Image                      70                                      [OK]
tiangolo/nginx-rtmp               Docker image with Nginx using the nginx-rtmp…   53                                      [OK]
nginxdemos/hello                  NGINX webserver that serves a simple page co…   27                                      [OK]
```

---

(2/3): **--no-trunc :**显示完整的镜像描述；

---

(3/3): **-s :**列出收藏数不小于指定值的镜像 ;

```bash
[root@DockerHub ~]# docker search -s 740 nginx
Flag --stars has been deprecated, use --filter=stars=3 instead
NAME                      DESCRIPTION                                     STARS               OFFICIAL            AUTOMATED
nginx                     Official build of Nginx.                        11945               [OK]                
jwilder/nginx-proxy       Automated Nginx reverse proxy for docker con…   1652                                    [OK]
richarvey/nginx-php-fpm   Container running Nginx + PHP-FPM capable of…   740                                     [OK]
[root@DockerHub ~]# 
```

