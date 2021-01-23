//package com.nifei.config;
//
//import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.reflection.MetaObject;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Slf4j
//@Component
//public class MyMetaObjectHandler implements MetaObjectHandler {
//
//
//    // 新增的时候自动填充
//    @Override
//    public void insertFill(MetaObject metaObject) {
//        log.info("start insert fill ....");
//        this.setFieldValByName("createTime",new Date(),metaObject);
//        this.setFieldValByName("updateTime", new Date(), metaObject);
//        this.setFieldValByName("deleteFlag", 0, metaObject);
//    }
//
//    // 更新的税后自动填充
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        log.info("start update fill ....");
//        this.setFieldValByName("updateTime", new Date(),metaObject);
//    }
//}
