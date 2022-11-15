package Tools;



import Entities.Consultation;
import Entities.Medicament;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel {
    private String[] colonnes;
    private Object[][] lignes;

    @Override
    public String getColumnName(int column) {
        return colonnes[column];
    }

    @Override
    public int getRowCount() {
        return lignes.length;
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return lignes[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        lignes[row][column] = value;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 3;
    }

    public void loadDatasConsultation(ArrayList<Consultation> getAllConsultations) {

        String[] nomsColonnes = new String[]{"Numéro", "Date", "Nom du patient", "Nom du medecin", "Montant"};
        Object[][] rows = new Object[getAllConsultations.size()][5];
        int i = 0;
        Consultation[] lesConsultations = new Consultation[0];
        for (Consultation consultation : lesConsultations) {
            colonnes[i][0] = consultation.getNumero();
            colonnes[i][1] = consultation.getDate();
            colonnes[i][2] = consultation.getNomPatient();
            colonnes[i][3] = consultation.getNomMedecin();
            colonnes[i][4] = consultation.getMontant();
            i++;
        }
        fireTableChanged(null);
    }
}
