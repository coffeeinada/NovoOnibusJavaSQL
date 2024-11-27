import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class GeradorXML {
    public static void gerarXML(Passageiro passageiro) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Passageiro.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(passageiro, System.out);
    }
}
