/*
jc -cp .:$JA/tagsoup-1.2.jar tabou/http/HtmlXpath.java
*/
package tabou.html;
import tabou.xml.Xpath;
import org.w3c.dom.Document;
public class HtmlXpath{
 public static void main(String[] args)throws Exception{
  Document dom = HtmlToXml.loadDom(System.in);
  new Xpath().document(dom)
  .xpath(args[0]).printXml();
 }
}
