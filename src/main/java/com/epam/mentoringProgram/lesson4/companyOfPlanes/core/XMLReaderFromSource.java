package com.epam.mentoringProgram.lesson4.companyOfPlanes.core;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.FileIsEmptyException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CargoPlane;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLReaderFromSource extends DataReaderFromSource {
    @Override
    public CompanyOfPlanes readData() throws FileIsEmptyException {

        setSourceName("inputFileXML.xml");

        CompanyOfPlanes companyOfPlanes = new CompanyOfPlanes();

        if (getSourceName().length() == 0) {
            throw new FileIsEmptyException();
        } else {
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(getSourceName());
                document.getDocumentElement().normalize();
                NodeList nodeList = document.getElementsByTagName("plane");
                for (int temp = 0; temp < nodeList.getLength(); temp ++){
                    Node node = nodeList.item(temp);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        if (element.getAttribute("planeType").contains("P")) {
                            try {
                                PassengerPlane passengerPlane = new PassengerPlane(element.
                                        getElementsByTagName("name").item(0).getTextContent(),
                                        Double.valueOf(element.
                                                getElementsByTagName("carrying").item(0).getTextContent()),
                                        Double.valueOf(element.
                                                getElementsByTagName("distance").item(0).getTextContent()),
                                        Integer.valueOf(element
                                                .getElementsByTagName("seatsNumber").item(0).getTextContent()));
                                companyOfPlanes.addPlanesToCompanyList(passengerPlane);
                            } catch (NumberFormatException e) {
                                System.out.println("There was an invalid parameter : plane  ("
                                        + element.getElementsByTagName("name").item(0).getTextContent()
                                        + ") won't be added to list!");
                            }
                        } else if (element.getAttribute("planeType").contains("C")) {
                            try {
                                CargoPlane cargoPlane = new CargoPlane(element.
                                        getElementsByTagName("name").item(0).getTextContent(),
                                        Double.valueOf(element.
                                                getElementsByTagName("carrying").item(0).getTextContent()),
                                        Double.valueOf(element.
                                                getElementsByTagName("distance").item(0).getTextContent()),
                                        Integer.valueOf(element.
                                                getElementsByTagName("boxNumber").item(0).getTextContent()));
                                companyOfPlanes.addPlanesToCompanyList(cargoPlane);
                            } catch (NumberFormatException e) {
                                System.out.println("There was an invalid parameter : plane ("
                                        + element.getElementsByTagName("name").item(0).getTextContent()
                                        + ") won't be added to list!");
                            }
                        }
                    }
                }
                return companyOfPlanes;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
