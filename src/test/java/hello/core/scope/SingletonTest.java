package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Singleton.class);

        Singleton singleton1 = ac.getBean(Singleton.class);
        Singleton singleton2 = ac.getBean(Singleton.class);

        System.out.println("singleton1 = " + singleton1);
        System.out.println("singleton2 = " + singleton2);

        Assertions.assertThat(singleton1).isSameAs(singleton2);

        ac.close();


    }


    @Scope("singleton")
    static class Singleton {

        @PostConstruct
        public void init() {
            System.out.println("Singleton.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("Singleton.destroy");
        }

    }
}
