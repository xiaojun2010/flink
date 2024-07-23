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

https://juejin.cn/post/7152837166190739486

https://github.com/yangchuansheng/prometheus-handbook

https://prometheus.wang/promql/prometheus-metrics-types.html

https://hulining.gitbook.io/prometheus/prometheus/management_api

https://blog.csdn.net/dl_11/article/details/136885380

https://blog.csdn.net/rainbowhhyhhy/article/details/135943216

https://cloud.tencent.com/developer/article/2048811

https://blog.csdn.net/m0_58476313/article/details/135336755

https://juejin.cn/post/7041922404615979021?from=search-suggest


https://docs.micrometer.io/micrometer/reference/concepts/histogram-quantiles.html


https://blog.csdn.net/m0_75209491/article/details/135950341


https://github.com/zalando/zmon

https://github.com/zalando-zmon
