# util
全局常用工具类

步骤：

    1.根build.gradle

        allprojects {
            repositories {
                google()
                jcenter()
                maven { url 'https://jitpack.io' } //添加仓库
            }
        }
    2.module的build.gradle

         compile 'com.github.wangfeixixi:util:v1.3'//添加依赖，如下提示，替换最新版本号
             
    [![](https://jitpack.io/v/wangfeixixi/util.svg)](https://jitpack.io/#wangfeixixi/util)
        
        
    3.manifest文件添加
         <application
            android:name="wangfei.util.BaseApp"        
    
完工体验：

如果觉得好请给我点赞哈！

如果需要进一步交流，邮件哦：xuanyuanxixi@foxmail.com


