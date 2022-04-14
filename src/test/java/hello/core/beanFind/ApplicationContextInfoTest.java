package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    public void findAllBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for(String beanName : beanDefinitionNames) {
            Object bean = ac.getBean(beanName);
            System.out.println("beanName = " + beanName + ", object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    public void findApplicationBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for(String beanName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);
            
            // Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanName);
                System.out.println("beanName = " + beanName + " [object = " + bean + "]");
            }
        }
    }
}
