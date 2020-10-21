package com.siying;

import com.siying.service.SomeService;
import com.siying.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void test01() {
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    /**
     * Spring默认创建对象的时机：在创建Spring的容器时，会创建配置文件中的所有的对象。
     * Spring创建对象：默认调用的是无参数构造方法
     */
    @Test
    public void test02() {
        // 使用Spring容器创建对象
        // 1. 指定Spring配置文件的名称
        String config = "beans.xml";
        // 2. 创建表示Spring容器的对象，ApplicationContext
        // ApplicationContext：表示Spring容器，通过容器获取对象了
        // ClassPathXmlApplicationContext：表示从类路径中加载Spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 容器中获取某个对象，要调用对象的方法
        // getBean("配置文件中的bean的id值")
        SomeService service = (SomeService) ac.getBean("someService");
        // 使用Spring创建好的对象
        service.doSome();
    }

    @Test
    public void test03() {
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 使用Spring提供的方法，获取容器中定义的对象的数量
        int nums = ac.getBeanDefinitionCount();
        System.out.println("容器中定义的对象数量：" + nums);
        // 容器中每个定义对象的名称
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    // 获取一个非自定义的类的对象
    @Test
    public void test04() {
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 使用getBean();
        Date my = (Date) ac.getBean("mydate");
        System.out.println("Date: " + my);
    }
}

