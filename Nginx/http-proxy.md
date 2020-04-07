```
location / {
    root /home/html;
    index index.html;
    expires 30d;
    gzip on;
    gzip_comp_level 3;
    gzip_types text/css text/xml application/javascript text/plain application/msword application/pdf application/x-javascript;
}
```
*****