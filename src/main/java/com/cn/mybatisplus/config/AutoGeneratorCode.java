package com.cn.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class AutoGeneratorCode {
    public static void main(String[] args) {
        //构建代码生成器对象
        AutoGenerator msg = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String path = System.getProperty("user.dir");
        gc.setOutputDir(path + "/src/main/java");
        gc.setAuthor("zmy");
        gc.setOpen(false);//是否打开资源管理器
        gc.setFileOverride(false);//代码生成后是否覆盖原有的
        gc.setDateType(DateType.ONLY_DATE);
        gc.setIdType(IdType.ID_WORKER);
        gc.setServiceName("%sService");//去除service的I前缀
        gc.setSwagger2(true);
        msg.setGlobalConfig(gc);
        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        msg.setDataSource(dsc);
        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.cn.mybatisplus");
        pc.setEntity("pojo");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        msg.setPackageInfo(pc);
        //策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("user");//创建的表名字
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true); // 自动lombok；
        sc.setLogicDeleteFieldName("deleted");//逻辑删除设置
        // 自动填充配置        
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        sc.setTableFillList(tableFills);
        // 乐观锁        
        sc.setVersionFieldName("version");
        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(true); // localhost:8080/hello_id_2
        msg.setStrategy(sc);
        msg.execute();
    }
}
