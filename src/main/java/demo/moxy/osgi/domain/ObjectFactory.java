package demo.moxy.osgi.domain;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Object Factory for creating person
 */
@XmlRegistry
public class ObjectFactory {
    public Person createPerson() {
        return new Person();
    }
}
