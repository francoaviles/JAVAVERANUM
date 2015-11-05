/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.beans.PropertyVetoException;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Duoc
 */
public class IFrameHelper {
    public void openContenidoAdmin(javax.swing.JInternalFrame iframe, javax.swing.JPanel panel) throws PropertyVetoException{
        panel.removeAll();
        iframe.setVisible(true);
        iframe.setMaximizable(true);
        iframe.setBorder(null);
        panel.add(iframe);
        iframe.setSelected(true);
        BasicInternalFrameUI b = (BasicInternalFrameUI)iframe.getUI();
        b.setNorthPane(null);
        b.setWestPane(null);
        b.setSouthPane(null);
        b.setEastPane(null);
    }
}
