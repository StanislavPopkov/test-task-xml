package ru.parsertest;

import com.google.common.io.Resources;
import ru.parsertest.jaxbparser.JaxbParser;
import ru.parsertest.schema.ObjectFactory;
import ru.parsertest.schema.Order;
import ru.parsertest.schema.Par;
import ru.parsertest.staxparser.StaxStreamProcessor;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {
            Main main = new Main();

            Order order = main.jaxbParse();
            List<String> documentListJaxb = main.jaxbDocumentList(order);
            System.out.println("Jaxb парсер");
            System.out.println("Отсортированная коллекция документов:");
            System.out.println(documentListJaxb);

            System.out.println("Коллекция атрибутов name=\"ГРАЖДАНСТВО\":");
            List<Par> attributeNamesList = main.jaxbAttribyteNamesList(order);
            Map<String, String> attribyteNamesMapJaxb = new HashMap<>();
            attributeNamesList.forEach(par -> attribyteNamesMapJaxb.putAll(par.parToMap()));
            System.out.println(attribyteNamesMapJaxb);

            System.out.println("Stax парсер");
            System.out.println("Отсортированная коллекция документов:");
            List<String> documentListStax = main.staxDocumentList();
            System.out.println(documentListStax);

            System.out.println("Коллекция атрибутов name=\"ГРАЖДАНСТВО\":");
            Map<String, String> attributeNamesMapStax = main.staxAttribyteNamesMap();
            System.out.println(attributeNamesMapStax);

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }


    }

    public Order jaxbParse() throws FileNotFoundException, JAXBException {
        JaxbParser parser = new JaxbParser(ObjectFactory.class);
        parser.setSchema("data.xsd");
        return parser.unmarshal(new FileReader( "C:/Users/I am/Desktop/uchoba/j/testTaskSberbank/src/main/resources/data.xml"));
    }

    public List<String> jaxbDocumentList (Order order) {
        List<Par> parsList = order.getServices().getServ().getPars().getPar();
        List<String> documentListJaxb = parsList.stream().filter(par -> "ВИД_ДОК".equals(par.getName()))
                .flatMap(par -> par.getContent().stream()).map(p -> p.getValue()).sorted().collect(Collectors.toList());
        return documentListJaxb;
    }

    public List<Par> jaxbAttribyteNamesList (Order order) {
        List<Par> attributeNamesList = order.getServices().getServ().getPars().getPar()
                .stream().filter(par -> "1".equals(par.getStep()) && "ГРАЖДАНСТВО".equals(par.getName())).collect(Collectors.toList());
        return attributeNamesList;
    }


    public List<String> staxDocumentList() throws FileNotFoundException, XMLStreamException {
        List<String> documentListStax = new ArrayList<>();
        try (StaxStreamProcessor processor =
                     new StaxStreamProcessor(new FileReader( "C:/Users/I am/Desktop/uchoba/j/testTaskSberbank/src/main/resources/data.xml"))) {
            XMLStreamReader reader = processor.getReader();
            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLEvent.START_ELEMENT && "par".equals(reader.getLocalName())
                        && "ВИД_ДОК".equals(reader.getAttributeValue("", "name"))) {
                    while (reader.hasNext()) {
                            event = reader.next();
                            if (event == XMLEvent.START_ELEMENT && "par_list".equals(reader.getLocalName())) {
                                documentListStax.add(reader.getAttributeValue("", "value"));
                            } else if (event == XMLEvent.START_ELEMENT && !"par_list".equals(reader.getLocalName())) {
                                break;
                            }
                        }
                }
            }
        }
        documentListStax.sort(Comparator.naturalOrder());
        return documentListStax;
    }


    public Map<String, String>  staxAttribyteNamesMap() throws FileNotFoundException, XMLStreamException {
        Map<String, String> documentMapStax = new HashMap<>();
        try (StaxStreamProcessor processor =
                     new StaxStreamProcessor(new FileReader("C:/Users/I am/Desktop/uchoba/j/testTaskSberbank/src/main/resources/data.xml"))) {
            XMLStreamReader reader = processor.getReader();
            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLEvent.START_ELEMENT && "par".equals(reader.getLocalName())
                        && "ГРАЖДАНСТВО".equals(reader.getAttributeValue("", "name"))) {
                    int attributeCount = reader.getAttributeCount();
                    for (int i = 0; i < attributeCount; i++) {
                        documentMapStax.put(reader.getAttributeLocalName(i), reader.getAttributeValue(i));
                    }
                    }
                }
            }
        return documentMapStax;
    }
}
