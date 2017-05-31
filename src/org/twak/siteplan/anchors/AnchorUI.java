/*
 * AnchorUI.java
 *
 * Created on 24-Jun-2010, 01:42:23
 */

package org.twak.siteplan.anchors;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;

import org.twak.siteplan.campskeleton.SitePlan;
import org.twak.utils.WeakListener;

/**
 *
 * @author twak
 */
public class AnchorUI extends javax.swing.JPanel implements WeakListener.Changed
{
    Anchor anchor;
    ButtonGroup bg;

    /** Creates new form AnchorUI */
    public AnchorUI()
    {
        initComponents();
    }
    public AnchorUI( Anchor anchor, ButtonGroup bg )
    {
        this.anchor = anchor;
        this.bg = bg;
        initComponents();
        nameLabel.setText(anchor.name);
        bg.add(selectButton);
        SitePlan.instance.selectedAnchorListeners.add(this);
        SitePlan.instance.somethingChangedListeners.add(this);
        changed();
    }

    public void changed()
    {
        updateButton();
    }

    public void updateButton()
    {
        if (SitePlan.instance.selectedAnchor != anchor)
            selectButton.setSelected(false);

        int count = 0;

        if (SitePlan.instance.plan.countMarkerMatches(anchor.getPlanGen()) > 0)
            count++;

        if (SitePlan.instance.plan.countMarkerMatches(anchor.getProfileGen()) > 0)
            count++;
        
        selectButton.setText( count + "/2" );
        selectButton.setForeground( count < 2 ? Color.red : Color.green );
    }

    public JToggleButton getButton()
    {
        return selectButton;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectButton = new javax.swing.JToggleButton();
        nameLabel = new javax.swing.JLabel();

        selectButton.setText("0/2");
        selectButton.setToolTipText("click on anchors after clicking this to locate feature");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("a very very long name that goes on and on and one");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(selectButton)
                .addComponent(nameLabel))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        SitePlan.instance.nowSelectingFor(anchor);
    }//GEN-LAST:event_selectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nameLabel;
    protected javax.swing.JToggleButton selectButton;
    // End of variables declaration//GEN-END:variables
}
