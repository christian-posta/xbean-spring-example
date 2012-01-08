package com.christianposta.postaprojects.xbeanspring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 1/3/12
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestSpringConfig {

    @Test
    public void testBeanGetsCreated() {

        // Got to use the XBean version of the Application Context
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext-test.xml");
        assertEquals(1, context.getBeansOfType(SimpleBean.class).size());

        SimpleBean bean = context.getBean(SimpleBean.class);
        assertEquals("testMe", bean.getMyProperty());

        SimpleController controller = bean.getSimpleController();
        assertEquals("testMeToo", controller.getControllerName());

        List<ComplexController> controllers = bean.getControllers();
        assertEquals(3, controllers.size());

    }
}
