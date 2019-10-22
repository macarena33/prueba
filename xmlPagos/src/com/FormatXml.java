package com;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.xml.sax.InputSource;


import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;



public class FormatXml {

    private static final int TABULADO = 4;
    private static final int ANCHO_LINEA = 120;


    public static final String formatear(String xml)
    {
        String retorno = null;


        try
        {
            final Document documento = parseXmlFile(xml);
            OutputFormat format = new OutputFormat(documento);
            format.setLineWidth(ANCHO_LINEA);
            format.setIndenting(true);
            format.setIndent(TABULADO);
            Writer salida = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(salida, format);
            serializer.serialize(documento);
            retorno = salida.toString();
        } catch (Exception e)
        {
            retorno = null;
        }


        return retorno;
    }


    private static final Document parseXmlFile(String entrada)
    {
        Document retorno = null;


        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(entrada));
            retorno = db.parse(is);
        } catch (Exception e)
        {
            retorno = null;
        }


        return retorno;
    }	
	
}
