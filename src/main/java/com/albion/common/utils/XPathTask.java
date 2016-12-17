package com.albion.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class XPathTask {

  protected Document doc;

  public XPathTask(String inputFileName) throws Exception
  {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true); // never forget this!
    DocumentBuilder builder = factory.newDocumentBuilder();
    doc = builder.parse(inputFileName);

  }
  public XPathTask(File aFile) throws Exception
  {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true); // never forget this!
    DocumentBuilder builder = factory.newDocumentBuilder();
    doc = builder.parse(aFile);

  }

  public NodeList processQuery(String queryString) throws Exception
  {
    XPathFactory factory = XPathFactory.newInstance();
    XPath xpath = factory.newXPath();
    XPathExpression expr = xpath.compile(queryString);
    Object result = expr.evaluate(doc, XPathConstants.NODESET);
    NodeList nodes = (NodeList) result;
    return nodes;
  }

  public List<String> getTextValueByQuery(String queryString) throws Exception
  {

    List<String> list = new ArrayList<String>();

    XPathFactory factory = XPathFactory.newInstance();
    XPath xpath = factory.newXPath();
    XPathExpression expr = xpath.compile(queryString);
    Object result = expr.evaluate(doc, XPathConstants.NODESET);

    NodeList nodes = (NodeList) result;
    for (int i = 0; i < nodes.getLength(); i++)
    {
      list.add(nodes.item(i).getNodeValue());
    }
    return list;
  }

  public Map<String, String> makeHashMap(String keyXPath, String valueXPath) throws Exception
  {

    List<String> names = null;
    List<String> values = null;
    Map<String, String> map = new HashMap<String, String>();

    names = getTextValueByQuery(keyXPath);
    values = getTextValueByQuery(valueXPath);

    if (names.size() == values.size())
    {
      for (int i = 0; i < names.size(); i++)
      {
        map.put(names.get(i), values.get(i));
      }
    }
    return map;
  }

  protected Document getDocument()
  {
    return doc;
  }
}
