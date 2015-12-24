/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;

@ActionID(
    category = "File",
id = "com.bi.right.customer.NewAction")
@ActionRegistration(
    iconBase = "com/bi/right/customer/nouvel_affaire16x16.png",
displayName = "#CTL_NewAction")
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 1575),
    @ActionReference(path = "Toolbars/File", position = 300),
    @ActionReference(path = "Shortcuts", name = "D-N")
})
@Messages("CTL_NewAction=Nouvelle Affaire")
public final class NewAction implements ActionListener {
      final OpenerJDialog f = new OpenerJDialog(WindowManager.getDefault().getMainWindow(), true);

    @Override
    public void actionPerformed(ActionEvent e) {
	SwingUtilities.invokeLater(new Runnable() {
    	    @Override
	    public void run() {
		
		    f.setVisible(true);
		
                
	    }
	});
         
    }
}
