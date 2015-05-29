package com.battlenex.game.npcs;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
public class NPCSpawns {
 
        /**
         * Spawns npcs retrieved from an xml file throughout the world
         */
        public static void spawnNPCS() {
                try {
                        final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                        final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                        final Document doc = dBuilder.parse(new File("./data/npcs/xml/npcspawns.xml"));
                        doc.getDocumentElement().normalize();
                        final NodeList nList = doc.getElementsByTagName("Npc");
                        for (int i = 0; i < nList.getLength(); i++) {
                                final Node nNode = nList.item(i);
                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                        final Element eElement = (Element) nNode;
                                        final int npcId = Integer
                                                        .parseInt(eElement.getAttribute("npcId"));
                                        final int x = Integer
                                                        .parseInt(eElement.getElementsByTagName("X")
                                                                        .item(0).getTextContent());
                                        final int y = Integer
                                                        .parseInt(eElement.getElementsByTagName("Y")
                                                                        .item(0).getTextContent());
                                        final int height = Integer.parseInt(eElement
                                                        .getElementsByTagName("Height").item(0)
                                                        .getTextContent());
                                        final int walk = Integer.parseInt(eElement
                                                        .getElementsByTagName("Walk").item(0)
                                                        .getTextContent());
                                        final int life = Integer.parseInt(eElement
                                                        .getElementsByTagName("Life").item(0)
                                                        .getTextContent());
                                        final int maxHit = Integer.parseInt(eElement
                                                        .getElementsByTagName("MaxHit").item(0)
                                                        .getTextContent());
                                        final int attack = Integer.parseInt(eElement
                                                        .getElementsByTagName("AttackLevel").item(0)
                                                        .getTextContent());
                                        final int defence = Integer.parseInt(eElement
                                                        .getElementsByTagName("DefenceLevel").item(0)
                                                        .getTextContent());
                                        NPCHandler.newNPC(npcId, x, y, height, walk, life, maxHit, attack, defence);
                                }
                        }
                } catch (final Exception e) {
                        e.printStackTrace();
                }
        }
 
}
