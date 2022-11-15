package Vues;

import Controlers.*;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmConsulter extends JFrame
{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblConsultations;
    private JTable tblConsultations;
    private JLabel lblMedicaments;
    private JTable tblMedicaments;

    public FrmConsulter()
    {
        this.setTitle("Consulter");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        CtrlConsultation ctrlConsultation = new CtrlConsultation();
        CtrlMedecin ctrlMedecin = new CtrlMedecin();
        CtrlMedicament ctrlMedicament = new CtrlMedicament();
        CtrlPatient ctrlPatient = new CtrlPatient();
        CtrlPrescrire ctrlPrescrire = new CtrlPrescrire();


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);


                ModelJTable modelJTable = new ModelJTable();
                modelJTable.loadDatasConsultation(ctrlConsultation.GetAllConsultations());
                tblConsultations.setModel(modelJTable);


            }
        });
        tblConsultations.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // A vous de jouer

            }
        });
    }
}
