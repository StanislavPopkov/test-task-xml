package ru.parsertest.application;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.parsertest.application.jaxbparser.JaxbParser;
import ru.parsertest.application.repository.AppRepository;
import ru.parsertest.application.schema.ObjectFactory;
import ru.parsertest.application.schema.Order;
import ru.parsertest.application.schema.Par;
import ru.parsertest.application.staxparser.StaxStreamProcessor;
import ru.parsertest.config.AppConfig;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private AppRepository appRepository;

    public Main() {
        try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
            this.appRepository = ctx.getBean(AppRepository.class);
        }
    }

    public static void main(String[] args) {
        System.setProperty("path", "C:/Users/I am/Desktop/uchoba/j/testTaskSberbank/src/main/resources/xml/data.xml");
        try {
            Main main = new Main();

            Order order = main.jaxbParse();
            List<String> documentListJaxb = main.jaxbDocumentList(order);
            System.out.println("Jaxb парсер");
            System.out.println("Отсортированная коллекция документов:");
            System.out.println(documentListJaxb);

            System.out.println("Коллекция атрибутов name=\"ГРАЖДАНСТВО\":");
            List<Par> attributeNamesList = main.jaxbAttribyteNamesList(order);
            Map<String, String> attributeNamesMapJaxb = new HashMap<>();
            attributeNamesList.forEach(par -> attributeNamesMapJaxb.putAll(par.parToMap()));
            System.out.println(attributeNamesMapJaxb);

            System.out.println();

            System.out.println("Stax парсер");
            System.out.println("Отсортированная коллекция документов:");
            List<String> documentListStax = main.staxDocumentList();
            System.out.println(documentListStax);

            System.out.println("Коллекция атрибутов name=\"ГРАЖДАНСТВО\":");
            Map<String, String> attributeNamesMapStax = main.staxAttribyteNamesMap();
            System.out.println(attributeNamesMapStax);

            System.out.println();
            System.out.println("Репозиторий с типами документов:");
            System.out.println(main.getAppRepository().findByType("пасп"));
            System.out.println(main.getAppRepository().get("паспортрф"));
            System.out.println(main.getAppRepository().getAll());
            System.out.println(main.getAppRepository().save("лицензия2"));
            System.out.println(main.getAppRepository().delete("УДОСТОВЕРВОЕНСЛУЖ"));


        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public AppRepository getAppRepository() {
        return appRepository;
    }

    public Order jaxbParse() throws FileNotFoundException, JAXBException {
        JaxbParser parser = new JaxbParser(ObjectFactory.class);
        parser.setSchema("xml/data.xsd");
        return parser.unmarshal(new FileReader( System.getProperty("path")));
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
                     new StaxStreamProcessor(new FileReader( System.getProperty("path")))) {
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
                     new StaxStreamProcessor(new FileReader(System.getProperty("path")))) {
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
