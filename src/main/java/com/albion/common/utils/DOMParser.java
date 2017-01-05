package com.albion.common.utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParser {

  private Document root;

  public DOMParser(String resourcePath) {

    File file = new File(resourcePath);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;
    try {
      dBuilder = dbFactory.newDocumentBuilder();
      root = dBuilder.parse(file);
      root.getDocumentElement().normalize();
    }
    catch (ParserConfigurationException | SAXException | IOException e) {
      e.printStackTrace();
    }
  }

  public Document getRoot()
  {
    return root;
  }

  public void setRoot(Document root)
  {
    this.root = root;
  }
}
