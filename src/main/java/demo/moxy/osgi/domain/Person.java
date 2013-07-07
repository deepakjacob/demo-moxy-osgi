package demo.moxy.osgi.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: deepakjacob
 * Date: 06/07/13
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Person {
    private String name;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*@Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }*/
}
