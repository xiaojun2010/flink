1. 启动prometheus,执行这句：
```
/usr/local/bin/prometheus --config.file=/usr/local/etc/prometheus.yml --web.listen-address=127.0.0.1:9090
```
访问： http://localhost:9090/


2. 启动grafana
```
   brew services start grafana
   ```
访问：http://localhost:3000/
用户名：admin
密码：admin123
3. 
参考：
https://zhuanlan.zhihu.com/p/696365357