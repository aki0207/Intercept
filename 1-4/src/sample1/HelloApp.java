package sample1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {
    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
        // ProxyFactoryBean�N���X�������Ɏw�肵�Ă���B���̃v���L�V�ɂ�胁�\�b�h���C���^�[�Z�v�g�����B
        MessageBean bean = (MessageBean)factory.getBean("proxy");

        bean.sayHello();
    }
}