package hello.core.singletone;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingetoneTest {
    @Test
    void singletoneBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingetoneBean.class);

        SingetoneBean bean1 = ac.getBean(SingetoneBean.class);
        SingetoneBean bean2 = ac.getBean(SingetoneBean.class);

        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);

        Assertions.assertThat(bean1).isSameAs(bean2);
        ac.close();
    }

    @Scope("singleton")
    static class SingetoneBean{
        @PostConstruct
        public void init(){
            //soutm
            System.out.println("SingetoneBean.init");

        }

        @PreDestroy
        public void destroy(){
            System.out.println("SingetoneBean.destroy");

        }

    }

}
