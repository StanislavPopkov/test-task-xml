package ru.parsertest.jaxbparser;

import com.google.common.io.Resources;
import org.xml.sax.SAXException;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import java.io.*;


public class JaxbParser {

    protected Marshaller marshaller;
    protected Unmarshaller unmarshaller;
    protected Schema schema;

    public JaxbParser(Class... classesToBeBound) {
        try {
            init(JAXBContext.newInstance(classesToBeBound));
        } catch (JAXBException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void init(JAXBContext ctx) throws JAXBException {
        marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        unmarshaller = ctx.createUnmarshaller();
    }

    public <T> T unmarshal(Reader reader) throws JAXBException {
        return (T) unmarshaller.unmarshal(reader);
    }

    public void setSchema(String resource) {
        this.schema = Schemas.ofURL(Resources.getResource(resource));
        unmarshaller.setSchema(schema);
        marshaller.setSchema(schema);
    }

    public void validate(String str) throws IOException, SAXException {
        validate(new StringReader(str));
    }

    public void validate(Reader reader) throws IOException, SAXException {
        schema.newValidator().validate(new StreamSource(reader));
    }
}
