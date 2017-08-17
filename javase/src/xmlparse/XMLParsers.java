package xmlparse;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.helpers.DefaultHandler;

public class XMLParsers {

	public static void main(String[] args) {
		final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<work-contact-info>"
				+ "<Location>Shanghai-shuion-333</Location>"
				+ "<Postal>200020</Postal>" + "<Tel><fix>63262299</fix>"
				+ "<mobile>1581344454</mobile></Tel>"
				+ "<Appellation>Mr. Wang</Appellation>"
				+ "</work-contact-info>";
		StAX(xml);

//		long current = System.currentTimeMillis();
//		for (int i = 0; i < 10000; i++) {
//			StAX(xml);
//		}
//		current = System.currentTimeMillis() - current;
//		System.out.println(current);

//		current = System.currentTimeMillis();
//		for (int i = 0; i < 10000; i++) {
//			SAX(xml);
//		}
//		current = System.currentTimeMillis() - current;
//		System.out.println(current);
//
//		current = System.currentTimeMillis();
//		for (int i = 0; i < 10000; i++) {
//			DOM(xml);
//		}
//		current = System.currentTimeMillis() - current;
//		System.out.println(current);
	}

	private static void StAX(final String xml) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream input;
		try {
			input = new ByteArrayInputStream(xml.getBytes());
			XMLEventReader xmlEventReader = inputFactory
					.createXMLEventReader(input);
			while (xmlEventReader.hasNext()) {
				XMLEvent event = xmlEventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					System.out.println(startElement);
				}

				if (event.isCharacters()) {
					Characters text = event.asCharacters();
					if (!text.isWhiteSpace()) {
						System.out.println(text);
					}
				}
				
				if(event.isEndElement()){
					EndElement endElement = event.asEndElement();
					System.out.println(endElement);
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	private static void SAX(final String xml) {
		SAXParserFactory f = SAXParserFactory.newInstance();
		InputStream input;
		try {
			SAXParser p = f.newSAXParser();
			input = new ByteArrayInputStream(xml.getBytes());
			p.parse(input, new DefaultHandler());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void DOM(final String xml) {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		InputStream input;
		try {
			DocumentBuilder p = f.newDocumentBuilder();
			input = new ByteArrayInputStream(xml.getBytes());
			p.parse(input);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
