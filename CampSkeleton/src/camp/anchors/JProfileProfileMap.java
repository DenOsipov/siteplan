/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JProfileProfileMap.java
 *
 * Created on 09-Nov-2010, 00:53:58
 */

package camp.anchors;

import campskeleton.Plan;
import campskeleton.Profile;
import java.util.Map;
import org.twak.utils.ListDownLayout;

/**
 *
 * @author twak
 */
public class JProfileProfileMap extends javax.swing.JPanel {

    Plan plan;

    /** Creates new form JProfileProfileMap */
    public JProfileProfileMap() {
        initComponents();
    }
    public JProfileProfileMap( Plan plan, Map map, Iterable keys ) {
        this.plan = plan;
        initComponents();

        update(map, keys);
    }

    public void update( Map map, Iterable<Profile> keys )
    {
        profilePanel.removeAll();
        profilePanel.setLayout( new ListDownLayout() );
        for ( Profile p : keys )
            profilePanel.add( new JProfileProfileItem( plan, p, map ) );
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        profilePanel = new javax.swing.JPanel();

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(profilePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel profilePanel;

    // End of variables declaration//GEN-END:variables

}
