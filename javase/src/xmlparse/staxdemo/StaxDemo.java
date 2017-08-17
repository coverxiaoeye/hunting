package xmlparse.staxdemo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxDemo {
	//基于事件流的方式来做的，通过使用流的ＡＰＩ，像指针一样的来处理文档，每一个节点都可以返回一个事件。处理完以后由JVM来回收内存。
	public static void main(String[] args) throws IOException,
			XMLStreamException {
		StaxDemo test = new StaxDemo();
		//得到该类所在的包路径：/D:/SourceCodes/Study/Interview/javase/target/classes/xmlparse/staxdemo/
		String dir = test.getClass().getResource("").getPath();
		File file = new File(dir+"test.xml");
		test.read(file);
	}

	public void read(File file) throws IOException, XMLStreamException {
		Long time = null;
		XMLInputFactory factory = XMLInputFactory.newInstance();
		Reader fileReader = new FileReader(file);
		factory.setProperty(XMLInputFactory.IS_COALESCING, Boolean.TRUE);
		XMLStreamReader reader = factory.createXMLStreamReader(fileReader);
		try {
			int event = reader.getEventType();//获取节点类型,结果是以整形的方式返回的。

			//这里的3个对象是具体的POJO
			Item item = null;
			Ref ref = null;
			List<Ref> refList = null;//用来存放POJO的集合

			while (true) {
				switch (event) {
				case XMLStreamConstants.START_DOCUMENT://表示的是文档的开通节点。
					time = System.currentTimeMillis();
					break;
				case XMLStreamConstants.START_ELEMENT://开始解析开始节点
					if (reader.getLocalName().equals("item")) {//判断节点的名字
						item = new Item();//实例化一个节点ＰＯＪＯ类
						refList = new ArrayList<Ref>();

						//给节点赋值
						item.setType(reader.getAttributeValue(0));//getAttributeValue(index)获取属性的值，可能有多个属性。
						item.setName(reader.getAttributeValue(1));
						item.setSeq(reader.getAttributeValue(2));

					}

					if (reader.getLocalName().equals("status")) {

						item.setStatus(reader.getElementText());

					}

					if (reader.getLocalName().equals("desc")) {
						item.setDesc(reader.getElementText());

					}

					if (reader.getLocalName().equals("ref")) {

						ref = new Ref();
						ref.setSource(reader.getAttributeValue(0));
						if (reader.getAttributeCount() > 2) {
							ref.setUrl(reader.getAttributeValue(1));
						}
						ref.setText(reader.getElementText());
						
						refList.add(ref);
//						System.out.println("-----------refs--ref-------------");
//
//						if (reader.getAttributeCount() > 2) {
//							System.out.println("url: "
//									+ reader.getAttributeValue(1));
//						}

					}
					break;

				case XMLStreamConstants.CHARACTERS:
					// if(reader.isWhiteSpace())
					// break;
					break;
					//文档的结束元素
				case XMLStreamConstants.END_ELEMENT:
					if (reader.getLocalName().equals("item")) {
						item.setRefList(refList);
					}

					break;
					//文档的结束。
				case XMLStreamConstants.END_DOCUMENT:
					System.out.println("-----------end Document--------");
					time = System.currentTimeMillis() - time;
					System.out.println("耗时: " + time + "毫秒");
					System.out.println(item);
					break;
				}

				if (!reader.hasNext()) {
					break;
				}
				event = reader.next();
			}
		} finally {
			reader.close();
		}
	}
}