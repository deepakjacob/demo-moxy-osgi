package demo.moxy.osgi;

import demo.moxy.osgi.domain.Person;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

/**
 * Using JAXB in OSGI using Eclipselink Moxy
 */
public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        marshalToXml();
        unmarshalToJava(context);
    }

    private void unmarshalToJava(BundleContext context) throws JAXBException {
        // The follwing commented line creates a file w.r.t osgi environment (felix )
        // though it looks like an absolute path. Refrain from using it in prod envs
        // as it changes relative to the environment.

        //File file = new File("~/Development/person.xml");

        URL url = context.getBundle().getResource("demo/moxy/osgi/domain/person.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Person person = (Person) jaxbUnmarshaller.unmarshal(url);
        System.out.println(person);
    }

    private void marshalToXml() throws JAXBException {
        Person person = new Person();
        person.setName("John Dewey");
        person.setId(54);

        JAXBContext jc = JAXBContext.newInstance("demo.moxy.osgi.domain", Person.class.getClassLoader());
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(person, System.out);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("____________________________________");
        System.out.println("Stopped : " + context);
        System.out.println("____________________________________");
    }

}
