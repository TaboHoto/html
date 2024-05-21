package tabou.html;
import java.io.InputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXSource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.ccil.cowan.tagsoup.Parser;
import tabou.xml.Xpath;
public class HtmlToXml{
 public static void main(String[] args)throws Exception{
  Document dom = loadDom(System.in);
  Xpath.printDom(dom);
 }
 public static Document loadDom(InputStream input) {
 Parser parser = new Parser();

 try {
   parser.setFeature(Parser.namespacesFeature, false);
   parser.setFeature(Parser.namespacePrefixesFeature, false);
   parser.setFeature(Parser.defaultAttributesFeature,false);
   parser.setFeature("http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons",false);
   DOMResult result = new DOMResult();
   Transformer transformer = TransformerFactory.newInstance().newTransformer();
   transformer.transform(new SAXSource(parser, new InputSource(input)), result);
   return (Document) result.getNode();
 } catch (TransformerException | SAXException e) {
   throw new RuntimeException(e);
 }
}
}
