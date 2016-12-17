package com.albion.common.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DOMParser {

  private Document root;

  public DOMParser(String resourcePath)
  {

    File file = new File(resourcePath);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;
    try
    {
      dBuilder = dbFactory.newDocumentBuilder();
      root = dBuilder.parse(file);
      root.getDocumentElement().normalize();
    }
    catch (ParserConfigurationException e)
    {
      e.printStackTrace();
    }
    catch (SAXException e)
    {

      e.printStackTrace();
    }
    catch (IOException e)
    {

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
