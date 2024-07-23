打开 http://localhost:10111/status/prometheus

搜索 dataWareHouse

```

```

![1721656471799](image/READE/1721656471799.png)

```
# HELP dataWareHouse_total  
# TYPE dataWareHouse_total counter
dataWareHouse_total{application="demo",method_name="queryTgtUserIds",table_name="ads_risk_share_trait_same_user_act_stat_hi",} 66.0
dataWareHouse_total{application="demo",method_name="queryShareTraitTgtUseridList",table_name="ads_risk_share_trait_same_user_act_stat_hi",} 67.0
dataWareHouse_total{application="demo",method_name="queryByParentUserId",table_name="ads_usr_offline_features_df",} 133.0
dataWareHouse_total{application="demo",method_name="queryByUserAndCount",table_name="ads_risk_share_trait_same_user_act_stat_hi",} 67.0
dataWareHouse_total{application="demo",method_name="queryUserIds",table_name="ads_risk_share_trait_same_user_act_stat_hi",} 66.0
```

![1721656527940](image/READE/1721656527940.png)

![1721656591479](image/READE/1721656591479.png)

![1721656626704](image/READE/1721656626704.png)

```
dataWareHouse_total{application="demo",method_name="queryTgtUserIds",table_name="ads_risk_share_trait_same_user_act_stat_hi",}
```

![1721656672158](image/READE/1721656672158.png)

![1721656686361](image/READE/1721656686361.png)

```
rate(dataWareHouse_total{application="demo",table_name="ads_risk_share_trait_same_user_act_stat_hi",}[5m])
```

![1721656704467](image/READE/1721656704467.png)

```
dataWareHouse_timer{application="demo",method_name="queryTgtUserIds",table_name="ads_risk_share_trait_same_user_act_stat_hi"}
```

![1721656749376](image/READE/1721656749376.png)

![1721656761549](image/READE/1721656761549.png)


![1721657249807](image/READE/1721657249807.png)
