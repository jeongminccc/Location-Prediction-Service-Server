package com.chamjik.dbserver.controller;


import com.chamjik.dbserver.domain.RawVO;
import com.chamjik.dbserver.service.RawService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RawController {

    private final RawService rawService;

    @GetMapping("/dbserver/raw")
    public final List<RawVO> findSelect(@RequestParam(value="author", defaultValue = "")String author) throws Exception {
        List<RawVO> param = rawService.findByAuthor(author);

        System.out.println("Request");
        return param;
    }

    @GetMapping("/dbserver/find")
    public final void findAll() throws Exception {
        List<RawVO> all = rawService.findAll();

        for(int i=0; i<all.size(); i++){
            System.out.println("Author : " + all.get(i).getAuthor());
            System.out.println("Latitude : " + all.get(i).getLatitude());
            System.out.println("Longitude : " + all.get(i).getLongitude());
            System.out.println("Timestamp : " + all.get(i).getTimestamp());
            System.out.println("Timezone : " + all.get(i).getTimezone());
        }
    }

    @GetMapping("/dbserver/insert")
    public final void insertAll() throws Exception {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dm = factory.newDocumentBuilder();
            Document parser = dm.parse("C:/Temp/test.xml");
            NodeList list = parser.getElementsByTagName("position");
            List<RawVO> pList = new ArrayList<>();

            for (int i = 0; i < list.getLength(); i++) {
                Node position = list.item(i);
                NodeList aList = position.getChildNodes();
                RawVO p = new RawVO();

                for (int j = 0; j < aList.getLength(); j++) {
                    Node item = aList.item(j);
                    String temp = item.getNodeName();
                    if (temp.equals("#text")) continue;
                    if (temp.equals("author")) p.setAuthor(item.getTextContent());
                    if (temp.equals("timestamp")) p.setTimestamp(item.getTextContent());
                    if (temp.equals("timezone")) p.setTimezone(item.getTextContent());
                    if (temp.equals("latitude")) p.setLatitude(item.getTextContent());
                    if (temp.equals("longitude")) p.setLongitude(item.getTextContent());
                }
                pList.add(p);
            }
            rawService.insertRaw(pList);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}