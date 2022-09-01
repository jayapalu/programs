
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Body {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        Heart hobj = ctx.getBean("heart", Heart.class);

        hobj.pumpHeart();

    }
}
