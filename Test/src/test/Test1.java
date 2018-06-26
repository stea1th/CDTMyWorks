/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;




import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

/**
 *
 * @author vvlasov
 */
public class Test1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws javax.xml.bind.JAXBException
     * @throws org.xml.sax.SAXException
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public static void main(String[] args) throws IOException, JAXBException, SAXException, ParserConfigurationException, TransformerConfigurationException, TransformerException {

        System.out.println(Test1.toXmlWithComment(new First(), "second", "it's a comment"));

    }

    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, IOException, ParserConfigurationException, SAXException, TransformerConfigurationException, TransformerException {

        
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        dbf.setCoalescing(true);
        Document document = db.parse(new ByteArrayInputStream(writer.toString().getBytes()));
        Element root = document.getDocumentElement();
        document.setXmlStandalone(false);
        //System.out.println(root.getChildNodes().getLength());
        
        //System.out.println(root.getNodeName());
        walkThrough(root, tagName, comment, document);
        
        //Element root2 = document.getDocumentElement();
        //walkThrough(root2, tagName, comment, document);
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(source, result);
        
        return result.getWriter().toString();//writer.toString();
    }
    
    public static void walkThrough(Node start, String tagName, String comment, Document document){
        //System.out.println(start.getNodeName()+" = "+start.getNodeValue());
        
        /*Node cmnt = document.createComment(comment);
        for(Node child = start.getFirstChild(); child!= null; child = start.getNextSibling()){
            
            if(child.getNodeName().equals(tagName)){
                
                child.getParentNode().insertBefore(cmnt, child);
            }
            walkThrough(child, tagName, comment, document);
        }*/
        /*Node el = document.createComment(comment);
        System.out.println(el.getNodeName()+" "+el.getNodeValue());
        NodeList tag = document.getElementsByTagName(tagName);
        for (int i = 0; i < tag.getLength(); i++) {
            tag.item(i).getParentNode().insertBefore(el, tag.item(i));
            //tag.item(i).insertBefore(el, tag.item(i));
            //System.out.println(el.getNodeName()+" "+el.getNodeValue());
            
        }*/
        Node cmnt = document.createComment(comment);
        NodeList list = start.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            //System.out.println(node.getNodeValue());
            if(node.getNodeValue()!=null && node.getNodeValue().matches("&lt;")){
               //list.item(i).getParentNode()(document.createComment(comment), list.item(i));
               System.out.println(node.getNodeValue());
               
               node.setNodeValue(document.createCDATASection(node.getNodeValue()).getWholeText());
               
            }
            //System.out.println(list.item(i).getNodeName()+" "+list.item(i).getNodeValue());
            walkThrough(node, tagName, comment, document);
        }
    }

    @XmlRootElement(name = "first")
    public static class First {

        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4;
        @XmlElement(name = "forth")
        public Second[] third = new Second[]{new Second()};
        @XmlElement(name = "fifth")
        public String item5 = "need CDATA because of \"";
    }

    public static class Second {

        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
    }
}

/*System.out.println("--------------------------------------");
        //String makeComment = String.format("<!--%s-->\n<%s", comment, tagName);

        //String result = Pattern.compile("<" + tagName).matcher(writer.toString()).replaceAll(makeComment).replace("yes", "no");
        String line = "";
        String sub = "";
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(writer.toString().replace("yes", "no").getBytes())))) {
            while (reader.ready()) {
                line = reader.readLine();
                if(line.contains("<"+tagName)){
                    builder.append(String.format("<!--%s-->\n", comment));
                }
                if (line.contains("&lt;") || line.contains("&gt;") || line.contains("&amp;") || line.contains("&quot;")
                        || line.contains("&apos;")) {
                    sub = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")).replace("&lt;", "<")
                            .replace("&amp;", "&").replace("&gt;", ">").replace("&quot;", "«").replace("&apos;", "‘");
                    line =line.replace(line.substring(line.indexOf(">") + 1, line.lastIndexOf("<")), "<![CDATA[" + sub + "]]>");
                }
                builder.append(line.trim()+"\n");
            }
        }
        return builder.toString();
    }*/
